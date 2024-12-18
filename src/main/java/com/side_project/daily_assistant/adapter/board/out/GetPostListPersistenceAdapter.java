package com.side_project.daily_assistant.adapter.board.out;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.side_project.daily_assistant.adapter.common.isDeleted;
import com.side_project.daily_assistant.application.port.board.out.GetPostListPort;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetPostListPersistenceAdapter implements GetPostListPort {

	private final PostRepository postRepository;

	@Override
	public List<GetPostRes> getPostList(Pageable pageable) {

		Page<PostEntity> page = postRepository.findAllByIsDeleted(isDeleted.N, pageable);
		//        System.out.println("Total Pages: " + page.getTotalPages()); // 총 페이지 수
		//        System.out.println("Total Elements: " + page.getTotalElements()); // 전체 요소 수
		//        System.out.println("Current Page Number: " + page.getNumber()); // 현재 페이지 번호 (0부터 시작)
		//        System.out.println("Page Size: " + page.getSize()); // 한 페이지에 들어가는 요소 수
		//        System.out.println("Is First Page: " + page.isFirst()); ㅜ// 첫 번째 페이지인지 확인
		//        System.out.println("Is Last Page: " + page.isLast()); // 마지막 페이지인지 확인
		//        System.out.println("Has Next Page: " + page.hasNext()); // 다음 페이지가 있는지 확인
		//        System.out.println("Has Previous Page: " + page.hasPrevious()); // 이전 페이지가 있는지 확인

		// 현재 페이지의 데이터 출력
		List<PostEntity> postEntityList = page.getContent();
		//        posts.forEach(post -> {
		//            System.out.println("Post ID: " + post.getId());
		//            System.out.println("Post Title: " + post.getTitle());
		//            // 필요한 다른 필드도 출력 가능
		//        });

		return postEntityList.stream()
			.map(GetPostRes::fromEntity)
			.collect(Collectors.toList());

		//        return null;
		//        List<PostEntity> postEntityList = postRepository.findAllByIsDeleted(isDeleted.N, pageable);
		//        return postEntityList.stream()
		//                .map(GetPostRes::fromEntity)
		//                .collect(Collectors.toList());
	}
}
