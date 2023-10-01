package com.myresume.librarymanagementsystem.employee.model;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class Employee {
    @Id
    private int EMP_ID;
    private final String EMP_NAME;
    private final String EMP_LASTNAME;
    private final String EMP_NATIONALCODE;
    private int EMP_GENDER;
    private Date EMP_BOD;
    private String EMP_EMAIL;
    private String EMP_MOBILE;
    private String EMP_TEL;
    private String EMP_ADDRESS;
    private Date EMP_ENDDATE;
    private String EMP_DESCRIPTION;
    private int EMP_EDUCATION_LEVEL;
}
