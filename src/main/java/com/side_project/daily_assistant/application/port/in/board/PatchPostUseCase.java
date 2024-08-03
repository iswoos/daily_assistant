package com.side_project.daily_assistant.application.port.in.board;

import com.side_project.daily_assistant.dto.requestdto.board.CreatePostReq;
import com.side_project.daily_assistant.dto.requestdto.board.ModifyPostReq;

public interface PatchPostUseCase {
    String patchPost(Long id, ModifyPostReq modifyPostReq);
}
