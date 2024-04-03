package com.myresume.librarymanagementsystem.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
    private String employeeName;
    private String employeeLastName;
    private String employeeNationalCode;
    private String employeeEmail;
    private String employeeMobile;
    private Integer employeeIsHired;

}
