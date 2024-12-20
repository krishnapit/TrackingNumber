CREATE TABLE tracking_numbers (
    id SERIAL PRIMARY KEY,
    tracking_number VARCHAR(16) UNIQUE,
    created_at TIMESTAMP
);
