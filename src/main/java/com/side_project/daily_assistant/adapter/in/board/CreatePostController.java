package com.side_project.daily_assistant.adapter.in.board;

import com.side_project.daily_assistant.application.port.in.board.CreatePostUseCase;
import com.side_project.daily_assistant.dto.global.response.ApiResponse;
import com.side_project.daily_assistant.dto.requestdto.board.CreatePostReq;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;
import com.side_project.daily_assistant.exception.CustomException;
import com.side_project.daily_assistant.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.side_project.daily_assistant.util.ImagesCheck.imageListNotNullOrNotEmpty;

@RestController
@RequiredArgsConstructor
public class CreatePostController {

    private final CreatePostUseCase createPostUseCase;
    private static final int MAX_IMAGE_COUNT = 40;
    private static final long MAX_TOTAL_IMAGE_SIZE = 100 * 1024 * 1024;

    // 게시글 등록
    @PostMapping("/posts")
    public ResponseEntity<ApiResponse<GetPostRes>> createPost(
            @RequestPart("post") CreatePostReq createPost,
            @RequestPart(value = "images", required = false) List<MultipartFile> images
    ) {
        if(imageListNotNullOrNotEmpty(images)){
            validateImages(images);
        }
        ApiResponse<GetPostRes> response = ApiResponse.ok(createPostUseCase.createPost(createPost, images));
        return ApiResponse.toResponseEntity(response);
    }

    private void validateImages(List<MultipartFile> images) {
        if (images.size() > MAX_IMAGE_COUNT) {
            new CustomException(ErrorCode.EXCEEDED_IMAGE_UPLOAD_MAX_COUNT);
        }

        long totalSize = 0;
        for (MultipartFile image : images) {
            totalSize += image.getSize();
        }

        if (totalSize > MAX_TOTAL_IMAGE_SIZE) {
            new CustomException(ErrorCode.EXCEEDED_MAX_TOTAL_IMAGE_SIZE);
        }
    }
}
