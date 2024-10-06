package com.side_project.daily_assistant.adapter.comment.out;

import com.side_project.daily_assistant.adapter.board.out.PostEntity;
import com.side_project.daily_assistant.adapter.common.isDeleted;
import com.side_project.daily_assistant.domain.BaseEntity;
import com.side_project.daily_assistant.dto.requestdto.comment.CreateCommentReq;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
@DynamicInsert
@Table(name = "comment")
public class CommentEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private PostEntity post;

    @Column(name = "user_id")
    private String userId;

    private String content;

    @Enumerated(EnumType.STRING)
    private isDeleted is_deleted;

    @Builder
    private CommentEntity(
            Long id,
            PostEntity post,
            String userId,
            String content,
            isDeleted is_deleted,
            LocalDateTime createdDateTime,
            LocalDateTime modifiedDateTime) {
        this.id = id;
        this.post = post;
        this.userId = userId;
        this.content = content;
        this.is_deleted = is_deleted;
        this.createdDateTime = createdDateTime;
        this.modifiedDateTime = modifiedDateTime;
    }

    public static CommentEntity create(CreateCommentReq createCommentReq, PostEntity postEntity) {
        return CommentEntity.builder()
                .post(postEntity)
                .userId(createCommentReq.userId())
                .content(createCommentReq.content())
                .createdDateTime(LocalDateTime.now())
                .modifiedDateTime(LocalDateTime.now())
                .build();
    }
}
