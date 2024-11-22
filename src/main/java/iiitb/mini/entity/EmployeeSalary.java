package iiitb.mini.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employee_Salary")
public class EmployeeSalary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="employee_id") //foreign key
    private Long employeeId;

    @Column(name="payment_date")
    private LocalDate paymentDate;

    @Column(name="amount")
    private Double amount;

    @Column(name="description")
    private String description;


}
