CREATE TABLE `member` (
                          `latitude` double DEFAULT NULL,
                          `longitude` double DEFAULT NULL,
                          `created_date_time` datetime(6) DEFAULT NULL,
                          `member_id` bigint NOT NULL AUTO_INCREMENT,
                          `modified_date_time` datetime(6) DEFAULT NULL,
                          `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                          `user_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                          PRIMARY KEY (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `post` (
                        `created_date_time` datetime(6) DEFAULT NULL,
                        `modified_date_time` datetime(6) DEFAULT NULL,
                        `post_id` bigint NOT NULL AUTO_INCREMENT,
                        `content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `user_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        PRIMARY KEY (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;