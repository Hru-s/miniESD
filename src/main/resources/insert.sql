INSERT INTO Employees (id, employee_id, password, first_name, last_name, email, title, photograph_path, department)
VALUES
    (1, 101, '$2a$10$2H9YG8IXg/D2GzkUv9RCxe/OsOx0zOJwgxR7KNuSbx8t.JjXrEvwq', 'John', 'Doe', 'john.doe@example.com', 'Manager', 'uploads/images/1.png', 'HR'),
    (2, 102, '$2a$10$2H9YG8IXg/D2GzkUv9RCxe/OsOx0zOJwgxR7KNuSbx8t.JjXrEvwq', 'Jane', 'Smith', 'jane.smith@example.com', 'Software Engineer', 'uploads/images/2.png', 'IT'),
    (3, 103, '$2a$10$2H9YG8IXg/D2GzkUv9RCxe/OsOx0zOJwgxR7KNuSbx8t.JjXrEvwq', 'Alice', 'Brown', 'alice.brown@example.com', 'Accountant', 'uploads/images/3.png', 'Finance'),
    (4, 104, '$2a$10$2H9YG8IXg/D2GzkUv9RCxe/OsOx0zOJwgxR7KNuSbx8t.JjXrEvwq', 'Bob', 'Taylor', 'bob.taylor@example.com', 'Admin Officer', 'uploads/images/4.png', 'Administration'),
    (5, 105, '$2a$10$2H9YG8IXg/D2GzkUv9RCxe/OsOx0zOJwgxR7KNuSbx8t.JjXrEvwq', 'Charlie', 'Johnson', 'charlie.johnson@example.com', 'Analyst', 'uploads/images/5.png', 'Marketing');



INSERT INTO Courses (course_code, name, description, year, term, faculty, credits, capacity)
VALUES
                                                                                                 ('CSE101', 'Introduction to Programming', 'Learn the basics of programming using Python.', 2024, 'Fall', 'Dr. John Smith', 3, 50),
                                                                                                 ('CSE102', 'Data Structures', 'Detailed study of data structures and algorithms.', 2024, 'Fall', 'Dr. Emily Davis', 4, 40),
                                                                                                 ('CSE201', 'Database Management Systems', 'Understanding relational database systems.', 2024, 'Spring', 'Dr. Michael Brown', 3, 45),
                                                                                                 ('CSE202', 'Operating Systems', 'Explore concepts of modern operating systems.', 2024, 'Spring', 'Dr. Sarah Johnson', 4, 35),
                                                                                                 ('CSE301', 'Computer Networks', 'Learn about protocols and network architectures.', 2024, 'Fall', 'Dr. Robert Wilson', 4, 30),
                                                                                                 ('CSE302', 'Artificial Intelligence', 'Introduction to AI techniques and applications.', 2024, 'Spring', 'Dr. Lisa White', 3, 40),
                                                                                                 ('CSE401', 'Machine Learning', 'Advanced machine learning algorithms and models.', 2024, 'Fall', 'Dr. David Lee', 3, 30),
                                                                                                 ('CSE402', 'Cybersecurity', 'Principles and practices of securing systems.', 2024, 'Spring', 'Dr. Susan Taylor', 4, 25),
                                                                                                 ('CSE403', 'Cloud Computing', 'Learn about distributed systems and cloud platforms.', 2024, 'Fall', 'Dr. Chris Hall', 3, 50),
                                                                                                 ('CSE404', 'Software Engineering', 'Study methodologies for large-scale software projects.', 2024, 'Spring', 'Dr. Karen Moore', 4, 40);



