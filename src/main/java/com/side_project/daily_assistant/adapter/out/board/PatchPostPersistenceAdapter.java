package com.side_project.daily_assistant.adapter.out.board;

import com.side_project.daily_assistant.application.port.out.board.PatchPostPort;
import com.side_project.daily_assistant.domain.board.Post;
import com.side_project.daily_assistant.dto.requestdto.board.ModifyPostReq;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;
import com.side_project.daily_assistant.exception.CustomException;
import com.side_project.daily_assistant.exception.ErrorCode;
import com.side_project.daily_assistant.util.s3.FileService;
import com.side_project.daily_assistant.util.s3.FileService.imageUrlsResult;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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

        PostEntity postEntity = postRepository.findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.POST_NOT_FOUND)
        );

        // UUID를 fe에게 보내준다 -> 해당 값으로 FE에서는 폴더를 찾아가서 모든 이미지들을 지운다.
        // -> 불가능하다, 왜냐하면 해당값으로 FE에서 폴더찾아가서 삭제하려면 권한인증이 되어있어야 하기 때문에.
        // -> 그러니깐 그냥 기존 presigned url넘겨서 찾아가서 delete하게 하자. 그러기 위해서 delete 정책 생성하자.
        // -> 꼭 삭제를 해야할까..?? 어차피 불러오는 객체주소를 post테이블의 image_urls 컬럼에서 리스트 형식으로 관리하고 있고, 삭제하는 게 맞나 싶은데..
        // -> 우선순위에서 우선 낮춰두고, 다른 작업을 진행하자. 다른 작업이랑 의존도가 크지않아서, 언제든지 진행해도 되는 작업이니깐

        Post post = Post.fromEntity(postEntity);
        String imageFolderUUID = post.getImageFolderUUID();

        imageUrlsResult imageUrlsResult = fileService.generatePreSignedPutUrlsAndGetUrls(images, "board-image/" + imageFolderUUID);

        post.updatedPostInfo(modifyPostReq, imageUrlsResult.getGetImageUrls());
        PostEntity updatedPostEntity = postRepository.save(post.toEntity(post));
        GetPostRes getPostRes = GetPostRes.fromEntity(updatedPostEntity, imageUrlsResult.getPrePutSignedUrls());

        return getPostRes;
    }
}
