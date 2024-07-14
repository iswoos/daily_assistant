package com.side_project.daily_assistant.application.port.out.board;

import com.side_project.daily_assistant.dto.requestdto.board.ModifyPostReq;

public interface PatchPostPort {
    void patchPost(Long id, ModifyPostReq modifyPostReq);
}
