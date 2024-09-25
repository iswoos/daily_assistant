package com.side_project.daily_assistant.adapter.out.comment;

import com.side_project.daily_assistant.application.port.out.comment.GetCommentListPort;
import com.side_project.daily_assistant.dto.responsedto.comment.GetCommentRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class GetCommentListPersistenceAdapter implements GetCommentListPort {

    private final CommentRepository commentRepository;

    @Override
    public List<GetCommentRes> getCommentList(Long id) {
        // 쿼리로 어떻게 풀지부터 생각해봐야할듯?
        /* 특정 댓글의 바로 아래단계의 댓글 리스트만 추출하는 쿼리
        select
            *
        FROM
           comment AS c
        JOIN
            comment_closure cc ON c.comment_id = cc.child_comment_id
        WHERE
           cc.parent_comment_id = {8};

        기획 의도
        1. 게시물 조회 시, 최상단 루트의 댓글 목록이 노출됨
        2. 그 중, 바로 아래 단계 댓글이 존재하는 것들은 count하여 답글 N개 형식으로 뜨게 함
        3. 불러온 것들 중, 바로 아래 단계 댓글이 존재하는 것들은 동일하게 count한 값이 더 뜨게 함

        // 맨 처음 게시물 조회했을 때 사용해하는 쿼리
        select
            *
        from
            comment as c
        join
            comment_clousre cc on c.comment_id = cc.child_comment_id
        where
            cc.


        // depth가 없는 것들이랑, 0인 댓글들 모두 조회하게 함.
        select
            *
        from
            comment as c
        join
            comment_closure cc on c.comment_id = cc.child_comment_id
            and c.post_Id = {post_id}
            and cc.depth = {0}

        select
            *
        from
            comment_clousre as cc
        where
            cc.parent_comment_id = {전달받은 부모 comment_id}
            and cc.depth = {전달받은 depth} => 프론트에서 보내줘야할 것 같은데, 이 방식이 좋은 거려나?



        // 답글 보기 누를 경우, postId에 맞는 게시물들 중, parentID를 가지는 댓글들 중 depth가 그 다음 단계인 걸 가지는 댓글들을 가져옴

        */

        List<CommentEntity> commentList = commentRepository.findAllByPostId(id);
        return commentList.stream()
                .map(GetCommentRes::fromEntity)
                .collect(Collectors.toList());
    }
}
