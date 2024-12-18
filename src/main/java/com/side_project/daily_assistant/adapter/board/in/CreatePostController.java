package com.side_project.daily_assistant.adapter.board.in;

import static com.side_project.daily_assistant.util.ImagesCheck.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.side_project.daily_assistant.application.port.board.in.CreatePostUseCase;
import com.side_project.daily_assistant.dto.global.response.ApiResponse;
import com.side_project.daily_assistant.dto.requestdto.board.CreatePostReq;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CreatePostController {

	private final CreatePostUseCase createPostUseCase;

	// 게시글 등록
	// 현재 s3경로 >> board-image / 게시물 UUID /게시물 이미지들
	// 변경예정 s3경로 >> board-image / 게시물 작성자ID / 게시물 UUID / 게시물 이미지들
	@PostMapping("/posts")
	public ResponseEntity<ApiResponse<GetPostRes>> createPost(@RequestPart("post") CreatePostReq createPost,
		@RequestPart(value = "images", required = false) List<MultipartFile> images) {
		if (imageListNullOrEmpty(images)) {
			images = new ArrayList<>();
		} else {
			imageListSizeMaximum(images);
			imageListVolumeSizeMaximum(images);
		}

		ApiResponse<GetPostRes> response = ApiResponse.ok(createPostUseCase.createPost(createPost, images));
		return ApiResponse.toResponseEntity(response);
	}
}
