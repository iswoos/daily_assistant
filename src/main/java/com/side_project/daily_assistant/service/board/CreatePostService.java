package com.side_project.daily_assistant.service.board;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.side_project.daily_assistant.application.port.board.in.CreatePostUseCase;
import com.side_project.daily_assistant.application.port.board.out.CreatePostPort;
import com.side_project.daily_assistant.dto.requestdto.board.CreatePostReq;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;
import com.side_project.daily_assistant.util.s3.FileService;
import com.side_project.daily_assistant.util.s3.FileService.imageUrlsResult;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CreatePostService implements CreatePostUseCase {

	private final CreatePostPort createPostPort;
	private final FileService fileService;

	@Override
	public GetPostRes createPost(CreatePostReq createPost, List<MultipartFile> images) {
		String imageFolderUUID = UUID.randomUUID().toString();

		imageUrlsResult imageUrlsResult = fileService.generatePreSignedPutUrlsAndGetUrls(images,
			"board-image/" + imageFolderUUID);

		return createPostPort.createPost(createPost, imageFolderUUID, imageUrlsResult.getPrePutSignedUrls(),
			imageUrlsResult.getGetImageUrls());
	}
}
