package com.myresume.librarymanagementsystem.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Library {

    @Id
    @SequenceGenerator(initialValue = 100,name = "number")
    @GeneratedValue(strategy = GenerationType.IDENTITY , generator = "number")
    int library_id ;

    @NotBlank(message = "Library Name must be not empty!")
    String library_name;

    @NotBlank(message = "Library Address must be not empty!")
    String library_address;

    @NotBlank(message = "Region of library  must be not empty!")
    String library_region;

    @NotBlank(message = "Phone Number must be not empty!")
    @Digits(integer = 12, fraction = 0, message = "Please Enter a valid telephone number")
    String library_tel;
}
