package iiitb.mini.repo;

import iiitb.mini.entity.FacultyCourses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FacultyCoursesRepo extends JpaRepository<FacultyCourses, Long> {
    List<FacultyCourses> findByFaculty(Long faculty);
    FacultyCourses findByCourseId(Long courseId);
    List<FacultyCourses> findByCourseIdIn(List<Long> courseIds);
    Optional<FacultyCourses> findByFacultyAndCourseId(Long facultyId, Long courseId);
}