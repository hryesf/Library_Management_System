package com.myresume.librarymanagementsystem.employee.service;

import com.myresume.librarymanagementsystem.employee.entity.Employee;
import com.myresume.librarymanagementsystem.employee.repository.EmployeeRepository;
import com.myresume.librarymanagementsystem.exception.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeConverter employeeConverter;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeConverter employeeConverter) {
        this.employeeRepository = employeeRepository;
        this.employeeConverter = employeeConverter;
    }

    public EmployeeDTO saveEmployee(Employee employee) {
        return employeeConverter.toDto(employeeRepository.save(employee));
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeConverter.EmployeeDTOList(employeeRepository.findAll());
    }

    public EmployeeDTO getEmployeeById(Long id) {
        return employeeConverter.toDto(employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("employee with id " + id + " not Found")));
    }

    public String deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
        return "employee with code " + id + " removed";
    }


}
