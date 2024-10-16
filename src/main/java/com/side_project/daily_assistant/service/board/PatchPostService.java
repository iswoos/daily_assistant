package com.side_project.daily_assistant.service.board;

import com.side_project.daily_assistant.application.port.board.in.PatchPostUseCase;
import com.side_project.daily_assistant.application.port.board.out.PatchPostPort;
import com.side_project.daily_assistant.dto.requestdto.board.ModifyPostReq;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatchPostService implements PatchPostUseCase {

    private final PatchPostPort patchPostPort;

    @Override
    public GetPostRes patchPost(Long id, ModifyPostReq modifyPostReq, List<MultipartFile> images) {
        return patchPostPort.patchPost(id, modifyPostReq, images);
    }
}
