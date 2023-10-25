package com.myresume.librarymanagementsystem.employee.controller;

import com.myresume.librarymanagementsystem.employee.entity.Employee;
import com.myresume.librarymanagementsystem.employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(path = "api/v1/employees")
public class EmployeeController {

    final EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/{employee_id}")
    Employee getEmployee(@PathVariable("employee_id") Long id) {
        return employeeService.getEmployeeById(id);
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
        Employee employee = employeeService.getEmployeeById(employee_id);
        employee.setEmployeeIsHired(employee_isHired);
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping(path = "/update/{employee_id}")
    Employee updateEmployeeById(@PathVariable("employee_id") Long employee_id, @RequestBody Employee updatedEmployee) {
        Employee employee = employeeService.getEmployeeById(employee_id);
        employee.setEmployeeEmail(updatedEmployee.getEmployeeEmail());
        employee.setEmployeeMobile(updatedEmployee.getEmployeeMobile());
        employeeService.saveEmployee(employee);
        return employee;
    }
}
