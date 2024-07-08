CREATE TABLE comment (
     comment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
     post_id BIGINT NOT NULL,
     parent_id BIGINT,
     content VARCHAR(255) NOT NULL,
     CONSTRAINT fk_post FOREIGN KEY (post_id) REFERENCES post(post_id) ON DELETE CASCADE,
     CONSTRAINT fk_parent FOREIGN KEY (parent_id) REFERENCES comment(comment_id) ON DELETE CASCADE
);