package iiitb.mini.service;

import iiitb.mini.dto.DetailsResponse;
import iiitb.mini.dto.ModifyRequest;
import iiitb.mini.entity.Courses;
import iiitb.mini.entity.Employees;
import iiitb.mini.entity.FacultyCourses;
import iiitb.mini.helper.JWTHelper;
import iiitb.mini.repo.CoursesRepo;
import iiitb.mini.repo.EmployeeRepo;
import iiitb.mini.repo.FacultyCoursesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FetchService {

    private final FacultyCoursesRepo facultyCoursesRepo;
    private final CoursesRepo coursesRepo;
    private final EmployeeRepo employeeRepo;
    private final JWTHelper jwtHelper;

    public List<CourseResponse> getCourses(String token) {
        // Extract the faculty ID from the JWT token
        Long id = Long.valueOf(jwtHelper.extractUsername(token));

        // Get all FacultyCourses associated with the faculty
        List<FacultyCourses> facultyCourses = facultyCoursesRepo.findByFaculty(id);

        // Extract the courseIds directly (no need to parse as String -> Long)
        List<Long> courseIds = facultyCourses.stream()
                .map(FacultyCourses::getCourseId)  // Assuming courseId is already a Long in FacultyCourses
                .collect(Collectors.toList());

        // Fetch the Courses using the list of courseIds
        List<Courses> courses = coursesRepo.findByCourseIdIn(courseIds);

        // Map the Courses to CourseResponse objects
        return courses.stream()
                .map(course -> new CourseResponse(course.getCourseId(), course.getName()))
                .collect(Collectors.toList());
    }

    public DetailsResponse getDetails(String token)
    {
        Long id = Long.valueOf(jwtHelper.extractUsername(token));
        Employees employees = employeeRepo.findById(id).get();

        DetailsResponse detailsResponse = new DetailsResponse(
                employees.getEmployeeId(),
                employees.getFirstName(),
                employees.getLastName(),
                employees.getEmail(),
                employees.getTitle(),
                employees.getDepartment()
        );

        return detailsResponse;

    }

    public byte[] getImage(String token) throws IOException {
        Long id = Long.valueOf(jwtHelper.extractUsername(token));
        Employees employees = employeeRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found with ID " + id));
        System.out.println("record retrieved\n");
        String photoPath = employees.getPhotographPath();
        Path path = Paths.get(photoPath);
        System.out.println(photoPath+"\n");
        if (Files.exists(path)) {
            System.out.println("path got\n");
            return Files.readAllBytes(path);  // Return photo file bytes
        } else {
            System.out.println("path failed\n ");
            throw new IOException("Photo not found at the specified path.");
        }
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
