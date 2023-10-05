package com.myresume.librarymanagementsystem.employee.repository;

import com.myresume.librarymanagementsystem.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
