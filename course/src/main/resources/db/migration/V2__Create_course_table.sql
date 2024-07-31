-- Check if the table already exists
-- If not, create the table
CREATE TABLE IF NOT EXISTS course (
    course_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),  -- UUID primary key
    course_name VARCHAR(255) NOT NULL,
    course_description VARCHAR(1000) NOT NULL,
    start_date_time TIMESTAMP NULL,
    end_date_time TIMESTAMP NULL,
    course_status course_status_enum NOT NULL,  -- Enum type for course_status
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);