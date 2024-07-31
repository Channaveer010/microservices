-- Check if the type already exists

DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'course_status_enum') THEN
        EXECUTE 'CREATE TYPE course_status_enum AS ENUM (
            ''DRAFT'',
            ''REVIEW'',
            ''APPROVED'',
            ''ON-HOLD'',
            ''REJECTED'',
            ''PUBLISHED'',
            ''ARCHIVED''
        )';
    END IF;
END
$$;

/*CREATE CAST (varchar AS order_status) WITH INOUT AS IMPLICIT;
*/
CREATE TABLE course_status (
    course_status_id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    course_description VARCHAR(255) NOT NULL,
    course_status course_status_enum NOT NULL
);

-- Insert sample data
INSERT INTO course_status (course_description, course_status) VALUES
    ('The course is in draft state and not yet published.', 'DRAFT'),
    ('The course is under review before publication.', 'REVIEW'),
    ('The course has been approved for publishing.', 'APPROVED'),
    ('The course is on hold and may not be published.', 'ON_HOLD'),
    ('The course has been rejected and will not be published.', 'REJECTED'),
    ('The course has been published and is available.', 'PUBLISHED'),
    ('The course is archived and no longer active.', 'ARCHIVED');