package com.side_project.daily_assistant.adapter.out.board;
import com.side_project.daily_assistant.adapter.out.common.isDeleted;
import com.side_project.daily_assistant.domain.BaseEntity;
import com.side_project.daily_assistant.dto.requestdto.board.CreatePostReq;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@Table(name = "post")
public class PostEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "board_category")
    private String boardCategory;

    private String userId;

    private String title;

    private String content;

    private String image;

    @Column(name = "post_category")
    private String postCategory;

    @Column(name = "view_count")
    private Long viewCount;

    @Column(name = "likes_count")
    private Long likesCount;

    @Column(name = "is_deleted")
    @Enumerated(EnumType.STRING)
    private isDeleted isDeleted;

    private LocalDateTime createdDateTime;

    private LocalDateTime modifiedDateTime;

    @Builder
    private PostEntity(
            Long id,
            String boardCategory,
            String userId,
            String title,
            String content,
            String image,
            String postCategory,
            Long viewCount,
            Long likesCount,
            isDeleted isDeleted,
            LocalDateTime createdDateTime,
            LocalDateTime modifiedDateTime) {
        this.id = id;
        this.boardCategory = boardCategory;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.image = image;
        this.postCategory = postCategory;
        this.viewCount = viewCount;
        this.likesCount = likesCount;
        this.isDeleted = isDeleted;
        this.createdDateTime = createdDateTime;
        this.modifiedDateTime = modifiedDateTime;
    }

    public static PostEntity create(CreatePostReq createPostReq) {
        return PostEntity.builder()
                .userId(createPostReq.userId())
                .title(createPostReq.title())
                .content(createPostReq.content())
                .image(createPostReq.image())
                .postCategory(createPostReq.postCategory())
                .createdDateTime(LocalDateTime.now())
                .modifiedDateTime(LocalDateTime.now())
                .build();
    }
}