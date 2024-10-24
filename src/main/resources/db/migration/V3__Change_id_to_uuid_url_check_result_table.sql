-- Enable UUID extension if not already enabled
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Add a new UUID column
ALTER TABLE url_check_result ADD COLUMN id_new UUID;

-- Generate UUIDs for existing rows
UPDATE url_check_result SET id_new = uuid_generate_v4();

-- Remove the old 'id' column and set 'id_new' as the primary key
ALTER TABLE url_check_result DROP COLUMN id CASCADE;
ALTER TABLE url_check_result RENAME COLUMN id_new TO id;
