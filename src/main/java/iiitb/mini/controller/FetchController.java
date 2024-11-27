package iiitb.mini.controller;

import iiitb.mini.dto.DetailsResponse;
import iiitb.mini.dto.ModifyRequest;
import iiitb.mini.service.FetchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/api")
public class FetchController {
    private final FetchService fetchService;

    @GetMapping("/courses")
    public ResponseEntity<List<FetchService.CourseResponse>> getAllCoursesMethod() {
        List<FetchService.CourseResponse> courses = fetchService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/details")
    public ResponseEntity<DetailsResponse> detailsMethod(@RequestHeader("Authorization") String token) {
        System.out.println(token);
        DetailsResponse response = fetchService.getDetails(token);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/myCourses")
    public ResponseEntity<List<FetchService.CourseResponse>> getCoursesMethod(@RequestHeader("Authorization") String token) {
        List<FetchService.CourseResponse> courses = fetchService.getCourses(token);
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/image")
    public ResponseEntity<byte[]> getImageMethod(@RequestHeader("Authorization") String token) {
        try {
            byte[] photo = fetchService.getImage(token);

            // Set the appropriate content type for the photo
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "image/png");  // Change to "image/jpeg" if it's JPG

            return new ResponseEntity<>(photo, headers, HttpStatus.OK);
        } catch (IOException e) {
            System.out.println("error");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
