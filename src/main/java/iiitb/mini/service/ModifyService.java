package iiitb.mini.service;

import iiitb.mini.dto.CourseIdRequest;
import iiitb.mini.dto.addCourseResponse;
import iiitb.mini.dto.ModifyRequest;
import iiitb.mini.dto.deleteCourseResponse;
import iiitb.mini.entity.Courses;
import iiitb.mini.entity.Employees;
import iiitb.mini.entity.FacultyCourses;
import iiitb.mini.helper.JWTHelper;
import iiitb.mini.repo.CoursesRepo;
import iiitb.mini.repo.EmployeeRepo;
import iiitb.mini.repo.FacultyCoursesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModifyService {
    @Autowired
    final EmployeeRepo employeeRepo;
    private final JWTHelper jwtHelper;
    private final FacultyCoursesRepo facultyCoursesRepo;
    private final CoursesRepo coursesRepo;
    public void modifyDetails(ModifyRequest modifyRequest,String token){
        Long id = Long.valueOf(jwtHelper.extractUsername(token));
        Employees originalEmp = employeeRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Record with employee ID " + modifyRequest.employeeId() + " not found."));

        if(!employeeRepo.findByEmployeeId(modifyRequest.employeeId()).isEmpty() && employeeRepo.findByEmployeeId(modifyRequest.employeeId()).get().getId()!=originalEmp.getId())
        {
            throw new IllegalArgumentException("Employee ID " + modifyRequest.employeeId() + " is already in use!");
        }
        if(!employeeRepo.findByEmail(modifyRequest.email()).isEmpty() && employeeRepo.findByEmail(modifyRequest.email()).get().getEmail()!=originalEmp.getEmail())
        {throw new IllegalArgumentException("Email " + modifyRequest.email() + " is already in use!");
        }

        Employees modifiedEmp = Employees.builder()
                .id(originalEmp.getId())
                .employeeId(modifyRequest.employeeId())
                .password(originalEmp.getPassword())
                .firstName(modifyRequest.firstName())
                .lastName(modifyRequest.lastName())
                .email(modifyRequest.email())
                .title(modifyRequest.title())
                .photographPath(originalEmp.getPhotographPath())
                .department(modifyRequest.department())
                .build();

        employeeRepo.save(modifiedEmp);
    }

    public addCourseResponse addFacultyCourses(String token, CourseIdRequest courseIdRequest) {
        Long id = Long.valueOf(jwtHelper.extractUsername(token));
        // Extract course IDs from the request
        List<Long> courseIds = courseIdRequest.getCourseIds();

        // Fetch existing courses in a single query
        List<Courses> existingCourses = coursesRepo.findByCourseIdIn(courseIds);

        // Create a set of valid course IDs
        Set<Long> validCourseIds = existingCourses.stream()
                .map(Courses::getCourseId)
                .collect(Collectors.toSet());

        // Prepare response details
        List<String> addedCourses = new ArrayList<>();
        List<String> errors = new ArrayList<>();

        for (Long courseId : courseIds) {
            if (validCourseIds.contains(courseId)) {
                // Check if the faculty-course pair already exists
                Optional<FacultyCourses> existingFacultyCourse = facultyCoursesRepo
                        .findByFacultyAndCourseId(id, courseId);

                if (existingFacultyCourse.isPresent()) {
                    errors.add("Course ID " + courseId + " is already assigned to this faculty.");
                } else {
                    // Create and save FacultyCourses record
                    FacultyCourses facultyCourse = FacultyCourses.builder()
                            .faculty(id)
                            .courseId(courseId)
                            .build();
                    facultyCoursesRepo.save(facultyCourse);
                    addedCourses.add("Course ID " + courseId + " added successfully.");
                }
            } else {
                errors.add("Course ID " + courseId + " does not exist.");
            }
        }

        return new addCourseResponse(addedCourses, errors);
    }



    public deleteCourseResponse deleteCourses(CourseIdRequest courseIdRequest, String token) {
        Long id = Long.valueOf(jwtHelper.extractUsername(token));
        List<String> deletedCourses = new ArrayList<>();
        List<String> errors = new ArrayList<>();

        // Get all the FacultyCourses for the given facultyId
        List<FacultyCourses> facultyCourses = facultyCoursesRepo.findByFaculty(id);

        // If the facultyCourses list is empty, return an error message
        if (facultyCourses.isEmpty()) {
            errors.add("No matching records found.");
            return new deleteCourseResponse(deletedCourses, errors);
        }

        // Iterate over facultyCourses and delete each course that matches the request
        for (FacultyCourses facultyCourse : facultyCourses) {
            try {
                // Check if the courseId is in the list of courses to be deleted
                if (courseIdRequest.getCourseIds().contains(facultyCourse.getCourseId())) {
                    facultyCoursesRepo.delete(facultyCourse);  // Deleting the record
                    deletedCourses.add("Course ID " + facultyCourse.getCourseId() + " deleted successfully.");
                }
            } catch (Exception e) {
                errors.add("Error deleting Course ID " + facultyCourse.getCourseId() + ": " + e.getMessage());
            }
        }

        // Return the response containing the lists of deleted courses and errors
        return new deleteCourseResponse(deletedCourses, errors);
    }
}
