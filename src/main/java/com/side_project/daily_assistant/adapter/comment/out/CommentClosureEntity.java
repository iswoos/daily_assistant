package com.side_project.daily_assistant.adapter.comment.out;

import com.side_project.daily_assistant.adapter.common.isDeleted;
import com.side_project.daily_assistant.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@DynamicUpdate
@Table(name = "comment_closure")
public class CommentClosureEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_comment_id")
    private CommentEntity parentComment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "child_comment_id", nullable = false)
    private CommentEntity childComment;

    @Column(name = "depth", nullable = false)
    private int depth;

    @Column(name = "is_deleted")
    @Enumerated(EnumType.STRING)
    private isDeleted isDeleted;

    @Builder
    private CommentClosureEntity(
            Long id,
            CommentEntity parentComment,
            CommentEntity childComment,
            int depth,
            isDeleted isDeleted,
            LocalDateTime createdDateTime,
            LocalDateTime modifiedDateTime) {
        this.id = id;
        this.parentComment = parentComment;
        this.childComment = childComment;
        this.depth = depth;
        this.isDeleted = isDeleted;
        this.createdDateTime = createdDateTime;
        this.modifiedDateTime = modifiedDateTime;
    }

    public static CommentClosureEntity create(CommentEntity parent, CommentEntity createComment, int depth) {
        return CommentClosureEntity.builder()
                .parentComment(parent)
                .childComment(createComment)
                .depth(depth)
                .createdDateTime(LocalDateTime.now())
                .modifiedDateTime(LocalDateTime.now())
                .build();
    }

    public CommentClosureEntity(CommentEntity parentComment, CommentEntity childComment) {
        this.parentComment = parentComment;
        this.childComment = childComment;
    }
}
