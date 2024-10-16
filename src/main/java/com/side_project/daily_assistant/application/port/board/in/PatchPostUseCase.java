package com.side_project.daily_assistant.application.port.board.in;

import com.side_project.daily_assistant.dto.requestdto.board.ModifyPostReq;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PatchPostUseCase {
    GetPostRes patchPost(Long id, ModifyPostReq modifyPostReq, List<MultipartFile> images);
}
