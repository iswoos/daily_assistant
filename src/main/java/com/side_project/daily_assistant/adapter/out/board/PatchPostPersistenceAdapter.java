package com.side_project.daily_assistant.adapter.out.board;

import com.side_project.daily_assistant.application.port.out.board.PatchPostPort;
import com.side_project.daily_assistant.domain.board.Post;
import com.side_project.daily_assistant.dto.requestdto.board.ModifyPostReq;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;
import com.side_project.daily_assistant.exception.CustomException;
import com.side_project.daily_assistant.exception.ErrorCode;
import com.side_project.daily_assistant.util.s3.FileService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@DynamicUpdate
public class PatchPostPersistenceAdapter implements PatchPostPort {

    private final PostRepository postRepository;
    private final FileService fileService;

    @Override
    public GetPostRes patchPost(Long id, ModifyPostReq modifyPostReq, List<MultipartFile> images) {
        List<String> prePutSignedUrls = new ArrayList<>();
        List<String> getImageUrls = new ArrayList<>();

        PostEntity postEntity = postRepository.findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.POST_NOT_FOUND)
        );

        // UUID를 fe에게 보내준다 -> 해당 값으로 FE에서는 폴더를 찾아가서 모든 이미지들을 지운다.
        // -> 불가능하다, 왜냐하면 해당값으로 FE에서 폴더찾아가서 삭제하려면 권한인증이 되어있어야 하기 때문에.
        // -> 그러니깐 그냥 기존 presigned url넘겨서 찾아가서 delete하게 하자. 그러기 위해서 delete 정책 생성하자.

        // 업로드해야하는 이미지를 create로직과 유사하게 FE에 넘겨준다. -> 해당 값을 토대로 FE에서는 S3에 업로드하는 로직을 태우면 된다.

        Post post = Post.fromEntity(postEntity);
        String imageFolderUUID = post.getImageFolderUUID();

        for (MultipartFile image : images) {
            String fileName = image.getOriginalFilename();

            String fullFilePath = fileService.createPath("board-image/" + imageFolderUUID, fileName);

            String putPreSignedUrl = fileService.getPutPreSignedUrl(fullFilePath);
            prePutSignedUrls.add(putPreSignedUrl);

            String getImageUrl = fileService.getFileUrl(fullFilePath);
            getImageUrls.add(getImageUrl);
        }

        post.updatedPostInfo(modifyPostReq, getImageUrls);
        PostEntity updatedPostEntity = postRepository.save(post.toEntity(post));
        GetPostRes getPostRes = GetPostRes.fromEntity(updatedPostEntity, prePutSignedUrls);

        System.out.println(getPostRes);

        return getPostRes;
    }
}
