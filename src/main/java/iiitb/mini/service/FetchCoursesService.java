package iiitb.mini.service;

import iiitb.mini.entity.Courses;
import iiitb.mini.entity.FacultyCourses;
import iiitb.mini.repo.CoursesRepo;
import iiitb.mini.repo.FacultyCoursesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FetchCoursesService {

    private final FacultyCoursesRepo facultyCoursesRepo;
    private final CoursesRepo coursesRepo;

    public List<CourseResponse> getCourses(String employeeId) {
        List<FacultyCourses> facultyCourses = facultyCoursesRepo.findByFaculty(employeeId);

        List<Long> courseIds = facultyCourses.stream()
                .map(fc -> Long.parseLong(fc.getCourseId()))
                .collect(Collectors.toList());

        List<Courses> courses = coursesRepo.findByCourseIdIn(courseIds);

        return courses.stream()
                .map(course -> new CourseResponse(course.getCourseId(), course.getName()))
                .collect(Collectors.toList());
    }

    public List<CourseResponse> getAllCourses() {
        // Fetch all courses from the Courses table
        List<Courses> courses = coursesRepo.findAll();

        // Map courses to response format
        return courses.stream()
                .map(course -> new CourseResponse(course.getCourseId(), course.getName()))
                .collect(Collectors.toList());
    }
    public record CourseResponse(Long courseId, String name) {}
}
