package com.side_project.daily_assistant.service.board;

import com.side_project.daily_assistant.application.port.in.board.CreatePostUseCase;
import com.side_project.daily_assistant.application.port.out.board.CreatePostPort;
import com.side_project.daily_assistant.dto.requestdto.board.CreatePostReq;
import com.side_project.daily_assistant.util.s3.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class CreatePostService implements CreatePostUseCase {

    private final CreatePostPort createPostPort;
    private final FileService fileService;

    @Override
    public String createPost(CreatePostReq createPost, List<MultipartFile> images) {
        String imageFolderUUID = UUID.randomUUID().toString();
        List<String> preSignedUrls = new ArrayList<>();

        for (MultipartFile image : images) {
            String fileName = image.getOriginalFilename();
            String preSignedUrl = fileService.getPreSignedUrl("board-image/" + imageFolderUUID, fileName);
            preSignedUrls.add(preSignedUrl);
        }

        return createPostPort.createPost(createPost, imageFolderUUID, preSignedUrls);
    }
}
