
ALTER TABLE Faculty_Courses
    ADD CONSTRAINT fk_faculty
        FOREIGN KEY (faculty)
            REFERENCES Employees(id)
            ON DELETE CASCADE;

ALTER TABLE Faculty_Courses
    ADD CONSTRAINT fk_course
        FOREIGN KEY (course_id)
            REFERENCES Courses(course_id)
            ON DELETE CASCADE;
