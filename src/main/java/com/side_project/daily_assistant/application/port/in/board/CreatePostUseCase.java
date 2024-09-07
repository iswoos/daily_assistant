package com.side_project.daily_assistant.application.port.in.board;

import com.side_project.daily_assistant.dto.requestdto.board.CreatePostReq;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CreatePostUseCase {
    String createPost(CreatePostReq createPostReq, List<MultipartFile> images);
}
