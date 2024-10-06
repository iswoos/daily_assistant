package com.side_project.daily_assistant.application.port.board.out;

import com.side_project.daily_assistant.dto.requestdto.board.CreatePostReq;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;

import java.util.List;

public interface CreatePostPort {
    GetPostRes createPost(CreatePostReq createPost, String imageFolderUUID, List<String> prePutSignedUrls, List<String> getImageUrls);
}
