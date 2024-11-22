package iiitb.mini.service;

import iiitb.mini.dto.ModifyRequest;
import iiitb.mini.entity.Employees;
import iiitb.mini.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModifyService {
    final EmployeeRepo employeeRepo;
    public void modifyDetails(ModifyRequest modifyRequest){
        if(!employeeRepo.findByEmployeeId(modifyRequest.newId()).isEmpty())
        {throw new IllegalArgumentException("Employee ID " + modifyRequest.newId() + " is already in use!");
        }
        if(!employeeRepo.findByEmail(modifyRequest.email()).isEmpty())
        {throw new IllegalArgumentException("Email " + modifyRequest.email() + " is already in use!");
        }
        Employees originalEmp = employeeRepo.findByEmployeeId(modifyRequest.oldId())
                .orElseThrow(() -> new IllegalArgumentException("Record with employee ID " + modifyRequest.oldId() + " not found."));

        Employees modifiedEmp = Employees.builder()
                .id(originalEmp.getId())
                .employeeId(modifyRequest.newId())
                .firstName(modifyRequest.firstName())
                .lastName(modifyRequest.lastName())
                .email(modifyRequest.email())
                .title(modifyRequest.title())
                .photographPath(originalEmp.getPhotographPath())
                .department(originalEmp.getDepartment())
                .build();

        employeeRepo.save(modifiedEmp);
    }
}
