package com.myresume.librarymanagementsystem.employee.entity;

import com.myresume.librarymanagementsystem.gender.entity.Gender;
import com.myresume.librarymanagementsystem.library.entity.Library;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Employee")
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @NotBlank(message = "Name must be not empty!")
    @Column(name = "employee_name",
            columnDefinition = "varchar(20) default 'unknown'")
    private String employeeName;

    @NotBlank(message = "Last name must be not empty!")
    @Column(name = "employee_last_name",
            columnDefinition = "varchar(50) default 'unknown'")
    private String employeeLastName;

    @NotBlank(message = "National Code must be not empty!")
    @Digits(integer = 10,
            fraction = 0,
            message = "Member National Code must be a number with at most 10 digits")
    @Column(name = "employee_national_code",
            columnDefinition = "varchar(10)",
            unique = true)
    private String employeeNationalCode;

    @ManyToOne
    @JoinColumn(name = "employee_gender_id",
            referencedColumnName = "gender_id",
            foreignKey = @ForeignKey( name = "employee_gender_id_fk"))
    private Gender employeeGenderId;

    @Past(message = "the input date for Birth Date is not valid! it should belong to past!")
    @Column(name = "employee_bod")
    private Date employeeBOD;

    @Email(message = "the input Email is not valid!")
    @Column(name = "employee_email",
            columnDefinition = "varchar(50)",
            unique = true)
    private String employeeEmail;

    @Digits(integer = 12,
            fraction = 0,
            message = "The phone nu,ber is not correct!")
    @Column(name = "employee_mobile",
            columnDefinition = "varchar(20)")
    private String employeeMobile;

    @Digits(integer = 1,
            fraction = 1,
            message = "Please just enter one number 1/0")
    @Column(name = "employee_is_hired")
    private Integer employeeIsHired;

    @ManyToOne
    @JoinColumn(name = "employee_library_id",
            referencedColumnName = "library_id",
            foreignKey = @ForeignKey( name = "employee_library_id_fk"))
    private Library employeeLibraryId;

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeLastName='" + employeeLastName + '\'' +
                ", employeeNationalCode='" + employeeNationalCode + '\'' +
                ", employeeGenderId=" + employeeGenderId.getGenderName() +
                ", employeeBOD=" + employeeBOD +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeeMobile='" + employeeMobile + '\'' +
                ", employeeIsHired=" + employeeIsHired.toString() +
                ", employeeLibraryId=" + employeeLibraryId.toString() +
                '}';
    }

    /*private String employee_TEL;
    private String employee_ADDRESS;
    private Date employee_ENDDATE;
    private String employee_DESCRIPTION;
    private Integer employee_EDUCATION_LEVEL;*/
}
