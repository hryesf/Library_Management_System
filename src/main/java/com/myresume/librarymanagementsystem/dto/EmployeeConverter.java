package com.myresume.librarymanagementsystem.dto;


import com.myresume.librarymanagementsystem.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeConverter {
    public EmployeeDTO toDto(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmployeeName(employee.getEmployeeName());
        dto.setEmployeeLastName(employee.getEmployeeLastName());
        dto.setEmployeeNationalCode(employee.getEmployeeNationalCode());
        dto.setEmployeeEmail(employee.getEmployeeEmail());
        dto.setEmployeeMobile(employee.getEmployeeMobile());
        dto.setEmployeeIsHired(employee.getEmployeeIsHired());

        return dto;
    }

    public List<EmployeeDTO> EmployeeDTOList (List<Employee> employeeList){
        return employeeList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Employee toEntity(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setEmployeeName(dto.getEmployeeName());
        employee.setEmployeeLastName(dto.getEmployeeLastName());
        employee.setEmployeeNationalCode(dto.getEmployeeNationalCode());
        employee.setEmployeeEmail(dto.getEmployeeEmail());
        employee.setEmployeeMobile(dto.getEmployeeMobile());
        employee.setEmployeeIsHired(dto.getEmployeeIsHired());


        return employee;
    }
}
