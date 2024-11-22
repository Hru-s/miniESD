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
@Table(name = "Employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="employee_id", unique = true, nullable = false)
    private Long employeeId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email", unique = true, nullable = false)
    private String email;

    @Column(name="title")
    private String title;

    @Column(name="photograph_path")
    private String photographPath;

    @Column(name="department") //foreign key
    private String department;



}
