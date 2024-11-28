
CREATE TABLE Employees (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           employee_id BIGINT UNIQUE NOT NULL,
                           password VARCHAR(255),
                           first_name VARCHAR(255),
                           last_name VARCHAR(255),
                           email VARCHAR(255) UNIQUE NOT NULL,
                           title VARCHAR(255),
                           photograph_path VARCHAR(255),
                           department VARCHAR(255)
);


CREATE TABLE Courses (
                         course_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         course_code VARCHAR(255) UNIQUE NOT NULL,
                         name VARCHAR(255),
                         description TEXT,
                         year INT,
                         term VARCHAR(255),
                         faculty VARCHAR(255),
                         credits INT,
                         capacity INT
);


CREATE TABLE Faculty_Courses (
                                 id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                 faculty BIGINT NOT NULL,
                                 course_id BIGINT NOT NULL
);
