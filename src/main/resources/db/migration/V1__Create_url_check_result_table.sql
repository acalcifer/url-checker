-- V1__Create_url_check_result_table.sql
CREATE TABLE url_check_result (
    id BIGSERIAL PRIMARY KEY,
    url VARCHAR(255) NOT NULL,
    exists BOOLEAN NOT NULL
);
