package iiitb.mini.repo;

import iiitb.mini.entity.FacultyCourses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyCoursesRepo extends JpaRepository<FacultyCourses, Long> {
    List<FacultyCourses> findByFaculty(String facultyId);
}