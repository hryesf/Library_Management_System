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

    @GetMapping(path = "/{emp_id}")
    Employee getEmployee(@PathVariable("emp_id") int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    String saveEmployee(@Valid @RequestBody Employee newEmployee) {
        System.out.println("Post Request ran ...");
        return employeeService.saveEmployee(newEmployee).toString() + "\nSaved in database";
    }

    @DeleteMapping(path = "/{emp_id}")
    String deleteEmployeeById(@PathVariable("emp_id") int emp_id) {
        return employeeService.deleteEmployeeById(emp_id);
    }

    @PutMapping(path = "/update/hiredMode/{emp_id}")
    Employee updateActiveFlagById(@PathVariable("emp_id") int emp_id, @RequestParam int emp_isHired) {
        Employee employee = employeeService.getEmployeeById(emp_id);
        employee.setEmp_isHired(emp_isHired);
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping(path = "/update/{emp_id}")
    Employee updateEmployeeById(@PathVariable("emp_id") int emp_id, @RequestBody Employee updatedEmployee) {
        Employee employee = employeeService.getEmployeeById(emp_id);
        employee.setEmp_email(updatedEmployee.getEmp_email());
        employee.setEmp_mobile(updatedEmployee.getEmp_mobile());
        employeeService.saveEmployee(employee);
        return employee;
    }
}
