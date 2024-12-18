package com.side_project.daily_assistant.application.port.board.out;

import java.util.List;

import com.side_project.daily_assistant.dto.requestdto.board.CreatePostReq;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;

public interface CreatePostPort {
	GetPostRes createPost(CreatePostReq createPost, String imageFolderUUID, List<String> prePutSignedUrls,
		List<String> getImageUrls);
}
