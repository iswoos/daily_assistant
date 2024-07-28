package com.side_project.daily_assistant.adapter.out.board;
import com.side_project.daily_assistant.adapter.out.common.isDeleted;
import com.side_project.daily_assistant.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicInsert
@Builder
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
}