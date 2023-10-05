package com.myresume.librarymanagementsystem.employee.service;

import com.myresume.librarymanagementsystem.employee.model.Employee;
import com.myresume.librarymanagementsystem.employee.repository.EmployeeRepository;
import com.myresume.librarymanagementsystem.exception.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class EmployeeService {

    final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("employee with id " + id + " not Found"));
    }

    public String deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
        return "employee with code " + id + " removed";
    }


}
