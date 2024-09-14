package com.side_project.daily_assistant.application.port.out.board;

import com.side_project.daily_assistant.dto.requestdto.board.CreatePostReq;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CreatePostPort {
    String createPost(CreatePostReq createPost, List<MultipartFile> images);
}
