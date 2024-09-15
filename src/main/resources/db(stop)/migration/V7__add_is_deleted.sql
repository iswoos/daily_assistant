ALTER TABLE post
    ADD COLUMN is_deleted VARCHAR(1) DEFAULT 'N' NOT NULL;

UPDATE post
    SET is_deleted = 'N';

ALTER TABLE comment
    ADD COLUMN is_deleted VARCHAR(1) DEFAULT 'N' NOT NULL;

UPDATE comment
SET is_deleted = 'N';