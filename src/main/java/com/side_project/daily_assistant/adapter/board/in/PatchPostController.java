package com.side_project.daily_assistant.adapter.board.in;

import com.side_project.daily_assistant.application.port.board.in.PatchPostUseCase;
import com.side_project.daily_assistant.dto.global.response.ApiResponse;
import com.side_project.daily_assistant.dto.requestdto.board.ModifyPostReq;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import static com.side_project.daily_assistant.util.ImagesCheck.*;

@RestController
@RequiredArgsConstructor
public class PatchPostController {

    private final PatchPostUseCase patchPostUseCase;

    // 게시글 수정
    @PatchMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse<GetPostRes>> patchPost(
            @PathVariable Long postId,
            @RequestPart("post") ModifyPostReq modifyPost,
            @RequestPart(value = "images", required = false) List<MultipartFile> images
    ) {
        if (imageListNullOrEmpty(images)) {
            images = new ArrayList<>();
        } else {
            imageListSizeMaximum(images);
            imageListVolumeSizeMaximum(images);
        }

        ApiResponse<GetPostRes> response = ApiResponse.ok(patchPostUseCase.patchPost(postId, modifyPost, images));
        return ApiResponse.toResponseEntity(response);
    }
}
