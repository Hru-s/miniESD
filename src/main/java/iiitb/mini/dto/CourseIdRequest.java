package iiitb.mini.dto;

import lombok.Data;

import java.util.List;

@Data
public class CourseIdRequest {
    private List<Long> courseIds;
}