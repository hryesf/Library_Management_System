package com.myresume.librarymanagementsystem.gender.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gender_id;

    @NotBlank(message = "Name must be not empty!")
    @Column(columnDefinition = "varchar(10) default 'unknown'")
    private String gender_name;

    public Gender(String gender_name) {
        this.gender_name = gender_name;
    }
}
