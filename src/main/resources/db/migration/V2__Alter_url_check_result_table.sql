-- V2__Alter_url_check_result_table.sql
-- Add a new column for checked_at and adjust the exists column to is_reachable

ALTER TABLE url_check_result
    RENAME COLUMN exists TO is_reachable;

ALTER TABLE url_check_result
    ADD COLUMN checked_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP;
