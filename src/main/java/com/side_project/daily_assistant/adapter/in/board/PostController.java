package com.side_project.daily_assistant.adapter.in.board;

import com.side_project.daily_assistant.application.port.in.board.*;
import com.side_project.daily_assistant.dto.global.response.ApiResponse;
import com.side_project.daily_assistant.dto.requestdto.board.CreatePostReq;
import com.side_project.daily_assistant.dto.requestdto.board.ModifyPostReq;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;
import com.side_project.daily_assistant.exception.CustomException;
import com.side_project.daily_assistant.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.side_project.daily_assistant.util.ImagesCheck.imageListNotNullOrNotEmpty;
import static com.side_project.daily_assistant.util.ImagesCheck.imageListNullOrEmpty;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final CreatePostUseCase createPostUseCase;
    private final GetPostUseCase getPostUseCase;
    private final GetPostListUseCase getPostListUseCase;
    private final PatchPostUseCase patchPostUseCase;
    private final DeletePostUseCase deletePostUseCase;
    private final LikePostUseCase likePostUseCase;

    private static final int MAX_IMAGE_COUNT = 40;         // 최대 이미지 개수
    private static final long MAX_TOTAL_IMAGE_SIZE = 100 * 1024 * 1024; // 최대 이미지 총 용량 (100MB)


    // 게시글 전체조회
    @GetMapping("/posts")
    public ResponseEntity<ApiResponse<List<GetPostRes>>> getPostList(){
        ApiResponse<List<GetPostRes>> response = ApiResponse.ok(getPostListUseCase.getPostList());
        return ApiResponse.toResponseEntity(response);
    }

    // 게시글 단건조회
    @GetMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse<GetPostRes>> getPost(@PathVariable Long postId) {
        ApiResponse<GetPostRes> response = ApiResponse.ok(getPostUseCase.getPost(postId));
        return ApiResponse.toResponseEntity(response);
    }

    /*
    FE단에서 이미지 등록할 경우(여러개든 한개든 상관없음), 이미지 전용 테이블을 따로 파서 게시물이랑 1:N관계 맺자.
    (기존 게시글 테이블의 Image_url에 이미지 여러개일 경우 , 으로 구분시켜놓으면 정규화도 안 맞고... 짜치니까)
    */

    // 게시글 등록
    @PostMapping("/posts")
    public ResponseEntity<ApiResponse<String>> createPost(
            @RequestPart("post") CreatePostReq createPost,
            @RequestPart(value = "images", required = false) List<MultipartFile> images
    ) {
        if(imageListNotNullOrNotEmpty(images)){
            validateImages(images);
        }
        ApiResponse<String> response = ApiResponse.ok(createPostUseCase.createPost(createPost, images));
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

    // 게시글 수정
    @PatchMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse<String>> patchPost(@PathVariable Long postId, @RequestBody ModifyPostReq modifyPost) {
        ApiResponse<String> response = ApiResponse.ok(patchPostUseCase.patchPost(postId, modifyPost));
        return ApiResponse.toResponseEntity(response);
    }

    // 게시글 삭제
    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse<String>> deletePost(@PathVariable Long postId) {
        ApiResponse<String> response = ApiResponse.ok(deletePostUseCase.deletePost(postId));
        return ApiResponse.toResponseEntity(response);
    }

    // 게시글 추천
    @PatchMapping("/posts/{postId}/likes")
    public ResponseEntity<ApiResponse<String>> likePost(@PathVariable Long postId) {
        ApiResponse<String> response = ApiResponse.ok(likePostUseCase.likePost(postId));
        return ApiResponse.toResponseEntity(response);
    }

}
