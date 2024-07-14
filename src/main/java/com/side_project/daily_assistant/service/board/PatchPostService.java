package com.side_project.daily_assistant.service.board;

import com.side_project.daily_assistant.application.port.in.board.PatchPostUseCase;
import com.side_project.daily_assistant.application.port.out.board.PatchPostPort;
import com.side_project.daily_assistant.dto.requestdto.board.ModifyPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatchPostService implements PatchPostUseCase {

    private final PatchPostPort patchPostPort;

    @Override
    public void patchPost(Long id, ModifyPostReq modifyPostReq) {
        patchPostPort.patchPost(id, modifyPostReq);
    }
}
