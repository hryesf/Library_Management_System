package com.myresume.librarymanagementsystem.member.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mem_id;

    @NotBlank(message = "Name must be not empty!")
    private String mem_name;

    @NotBlank(message = "Last name must be not empty!")
    private String mem_lastName;

    @NotBlank(message = "National Code must be not empty!")
    @Digits(integer = 10, fraction = 0, message = "Member National Code must be a number with at most 10 digits")
    private String mem_nationalCode;

    @Digits(integer = 1, fraction = 0, message = "Please just enter one number 1/0")
    private int mem_gender;
    @Past(message = "the input date for Birth Date is not valid! it should belong to past!")
    private Date mem_bod;

    @Email(message = "the input Email is not valid!")
    private String mem_email;

    @Digits(integer = 12, fraction = 0, message = "The phone nu,ber is not correct!")
    private String mem_mobile;

    @Digits(integer = 1, fraction = 0, message = "Please just enter one number 1/0")
    private int mem_isActive;

    private int mem_registrar_id;

    /*private String MEM_TEL;
    private String MEM_ADDRESS;
    private Date MEM_REGISTERED_DATE;
    private String MEM_DESCRIPTION;
    private int MEM_STATUS_ID;
    private int MEM_EDUCATION_LEVEL_ID;*/
}
