package com.side_project.daily_assistant.adapter.out.comment;

import com.side_project.daily_assistant.adapter.out.board.PostEntity;
import com.side_project.daily_assistant.adapter.out.common.isDeleted;
import com.side_project.daily_assistant.domain.BaseEntity;
import com.side_project.daily_assistant.domain.board.Post;
import com.side_project.daily_assistant.dto.requestdto.comment.CreateCommentReq;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private CommentEntity parent;

    @OneToMany(mappedBy = "parent")
    private List<CommentEntity> replies = new ArrayList<>();

    @Column(name = "user_id")
    private String userId;

    private String content;

    @Enumerated(EnumType.STRING)
    private isDeleted is_deleted;

    @Builder
    private CommentEntity(
            Long id,
            PostEntity post,
            CommentEntity parent,
            String userId,
            String content,
            isDeleted is_deleted,
            LocalDateTime createdDateTime,
            LocalDateTime modifiedDateTime) {
        this.id = id;
        this.post = post;
        this.parent = parent;
        this.userId = userId;
        this.content = content;
        this.is_deleted = is_deleted;
        this.createdDateTime = createdDateTime;
        this.modifiedDateTime = modifiedDateTime;
    }

    public static CommentEntity craete(CreateCommentReq createCommentReq, PostEntity postEntity, CommentEntity commentEntity) {
        return CommentEntity.builder()
                .post(postEntity)
                .parent(commentEntity)
                .userId(createCommentReq.userId())
                .content(createCommentReq.content())
                .createdDateTime(LocalDateTime.now())
                .modifiedDateTime(LocalDateTime.now())
                .build();
    }
}
