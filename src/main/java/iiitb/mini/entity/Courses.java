package iiitb.mini.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Courses")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "course_code", unique = true, nullable = false)
    private String courseCode;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "year")
    private Integer year;

    @Column(name = "term")
    private String term;

    @Column(name = "faculty") // Foreign key reference to Employees table
    private String faculty;

    @Column(name = "credits")
    private Integer credits;

    @Column(name = "capacity")
    private Integer capacity;
}
