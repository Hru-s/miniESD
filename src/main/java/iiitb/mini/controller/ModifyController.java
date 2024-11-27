package iiitb.mini.controller;

import iiitb.mini.dto.CourseIdRequest;
import iiitb.mini.dto.addCourseResponse;
import iiitb.mini.dto.ModifyRequest;
import iiitb.mini.dto.deleteCourseResponse;
import iiitb.mini.service.ModifyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ModifyController {
    @Autowired
    ModifyService modifyService;

    @PostMapping("/modify")
    public String modify(@RequestBody @Valid ModifyRequest request,@RequestHeader("Authorization") String token) {
        modifyService.modifyDetails(request,token);
        String msg = "hi";
        return msg;
    }


        @PostMapping("addCourses")
        public ResponseEntity<addCourseResponse> addFacultyCourses(
                @RequestHeader("Authorization") String token,
                @RequestBody CourseIdRequest courseRequests
        ) {
            addCourseResponse response = modifyService.addFacultyCourses(token, courseRequests);
            return ResponseEntity.ok(response);
    }

    @PostMapping("deleteCourses")
    public ResponseEntity<deleteCourseResponse> deleteFacultyCourses(
            @RequestHeader("Authorization") String token,
            @RequestBody CourseIdRequest courseRequests
    ) {
        deleteCourseResponse response = modifyService.deleteCourses(courseRequests,token);
        return ResponseEntity.ok(response);
    }

}
