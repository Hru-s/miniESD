package iiitb.mini.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class addCourseResponse {
    private List<String> addedCourses;
    private List<String> errors;
}
