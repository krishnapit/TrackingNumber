CREATE TABLE tracking_numbers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tracking_number VARCHAR(255) NOT NULL UNIQUE,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);
