package com.side_project.daily_assistant.adapter.out.board;

import com.side_project.daily_assistant.adapter.out.comment.CommentEntity;
import com.side_project.daily_assistant.adapter.out.common.isDeleted;
import com.side_project.daily_assistant.domain.BaseEntity;
import com.side_project.daily_assistant.dto.requestdto.board.CreatePostReq;
import com.side_project.daily_assistant.util.StringListConverter;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@DynamicUpdate
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

    private String imageFolderUUID;

    @Lob
    @Convert(converter = StringListConverter.class)
    private List<String> imageUrls;

    @Column(name = "post_category")
    private String postCategory;

    @Column(name = "view_count")
    private Long viewCount;

    @Column(name = "likes_count")
    private Long likesCount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
    private List<CommentEntity> comments  = new ArrayList<>();

    @Column(name = "is_deleted")
    @Enumerated(EnumType.STRING)
    private isDeleted isDeleted;


    @Builder
    private PostEntity(
            Long id,
            String boardCategory,
            String userId,
            String title,
            String content,
            String imageFolderUUID,
            List<String> imageUrls,
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
        this.imageFolderUUID = imageFolderUUID;
        this.imageUrls = imageUrls;
        this.postCategory = postCategory;
        this.viewCount = viewCount;
        this.likesCount = likesCount;
        this.isDeleted = isDeleted;
        this.createdDateTime = createdDateTime;
        this.modifiedDateTime = modifiedDateTime;
    }

    public static PostEntity create(CreatePostReq createPostReq, String imageFolderUUID, List<String> imageUrls) {
        return PostEntity.builder()
                .userId(createPostReq.userId())
                .title(createPostReq.title())
                .content(createPostReq.content())
                .postCategory(createPostReq.postCategory())
                .imageFolderUUID(imageFolderUUID)
                .imageUrls(imageUrls)
                .createdDateTime(LocalDateTime.now())
                .modifiedDateTime(LocalDateTime.now())
                .build();
    }
}