package com.side_project.daily_assistant.application.port.in.board;

import com.side_project.daily_assistant.dto.requestdto.board.CreatePostReq;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CreatePostUseCase {
    GetPostRes createPost(CreatePostReq createPostReq, List<MultipartFile> images);
}
