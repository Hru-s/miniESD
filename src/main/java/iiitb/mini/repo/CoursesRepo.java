package iiitb.mini.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import iiitb.mini.entity.Courses;
import java.util.List;



public interface CoursesRepo extends JpaRepository<Courses, Long> {
    List<Courses> findByCourseIdIn(List<Long> courseIds);
}