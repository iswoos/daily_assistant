package com.side_project.daily_assistant.adapter.out.board;

import com.side_project.daily_assistant.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

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

    private String board_category;

    private String userId;

    private String title;

    private String content;

    private String image;

    private String post_category;

    private Long view_count;

    private Long likes_count;
}