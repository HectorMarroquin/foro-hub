CREATE TABLE topics (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    message VARCHAR(255),
    topic_status VARCHAR(255),
    user_id BIGINT,
    course_id BIGINT,
    created_at DATETIME,
    CONSTRAINT fk_topics_users FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);