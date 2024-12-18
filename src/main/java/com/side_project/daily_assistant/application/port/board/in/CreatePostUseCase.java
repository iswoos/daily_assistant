package com.side_project.daily_assistant.application.port.board.in;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.side_project.daily_assistant.dto.requestdto.board.CreatePostReq;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;

public interface CreatePostUseCase {
	GetPostRes createPost(CreatePostReq createPostReq, List<MultipartFile> images);
}
