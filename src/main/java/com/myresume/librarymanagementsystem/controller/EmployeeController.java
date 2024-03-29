package com.myresume.librarymanagementsystem.controller;

import com.myresume.librarymanagementsystem.entity.Employee;
import com.myresume.librarymanagementsystem.service.EmployeeConverter;
import com.myresume.librarymanagementsystem.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeConverter employeeConverter;


    EmployeeController(EmployeeService employeeService, EmployeeConverter employeeConverter) {
        this.employeeService = employeeService;
        this.employeeConverter = employeeConverter;
    }

    @GetMapping
    String getAllEmployees() {
        return employeeService.getAllEmployees().toString();
    }

    @GetMapping(path = "/{employee_id}")
    String getEmployee(@PathVariable("employee_id") Long id) {
        return employeeService.getEmployeeById(id).toString();
    }

    @PostMapping
    String saveEmployee(@Valid @RequestBody Employee newEmployee) {
        System.out.println("Post Request ran ...");
        return employeeService.saveEmployee(newEmployee).toString() + "\nSaved in database";
    }

    @DeleteMapping(path = "/{employee_id}")
    String deleteEmployeeById(@PathVariable("employee_id") Long emp_id) {
        return employeeService.deleteEmployeeById(emp_id);
    }

    @PutMapping(path = "/update/hiredMode/{employee_id}")
    Employee updateActiveFlagById(@PathVariable("employee_id") Long employee_id, @RequestParam int employee_isHired) {
        Employee employee = employeeConverter.toEntity(employeeService.getEmployeeById(employee_id));
        employee.setEmployeeIsHired(employee_isHired);
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping(path = "/update/{employee_id}")
    Employee updateEmployeeById(@PathVariable("employee_id") Long employee_id, @RequestBody Employee updatedEmployee) {
        Employee employee = employeeConverter.toEntity(employeeService.getEmployeeById(employee_id));
        employee.setEmployeeEmail(updatedEmployee.getEmployeeEmail());
        employee.setEmployeeMobile(updatedEmployee.getEmployeeMobile());
        employeeService.saveEmployee(employee);
        return employee;
    }
}
