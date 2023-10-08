package com.myresume.librarymanagementsystem.employee.entity;

import com.myresume.librarymanagementsystem.gender.entity.Gender;
import com.myresume.librarymanagementsystem.library.entity.Library;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Employee")
@Table
public class Employee {
    @Id
    @SequenceGenerator(name = "employee_id_seq", sequenceName = "employee_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_seq")
    private Integer emp_id;

    @NotBlank(message = "Name must be not empty!")
    @Column(columnDefinition = "varchar(20) default 'unknown'")
    private String emp_name;

    @NotBlank(message = "Last name must be not empty!")
    @Column(columnDefinition = "varchar(50) default 'unknown'")
    private String emp_lastName;

    @NotBlank(message = "National Code must be not empty!")
    @Digits(integer = 10, fraction = 0, message = "Member National Code must be a number with at most 10 digits")
    @Column(columnDefinition = "varchar(20)", unique = true)
    private String emp_nationalCode;

    @ManyToOne
    @JoinColumn(name = "emp_gender_id", referencedColumnName = "gender_id")
    private Gender emp_gender_id;

    @Past(message = "the input date for Birth Date is not valid! it should belong to past!")
    private Date emp_bod;

    @Email(message = "the input Email is not valid!")
    @Column(columnDefinition = "varchar(50)", unique = true)
    private String emp_email;

    @Digits(integer = 12, fraction = 0, message = "The phone nu,ber is not correct!")
    private String emp_mobile;

    @Digits(integer = 1, fraction = 1, message = "Please just enter one number 1/0")
    private Integer emp_isHired;

    @ManyToOne
    @JoinColumn(name = "emp_library_id", referencedColumnName = "library_id")
    private Library emp_library_id;

    /*private String EMP_TEL;
    private String EMP_ADDRESS;
    private Date EMP_ENDDATE;
    private String EMP_DESCRIPTION;
    private Integer EMP_EDUCATION_LEVEL;*/
}
