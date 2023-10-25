package com.myresume.librarymanagementsystem.gender.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Gender")
@Table(name = "gender")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gender_id")
    private Long genderId;

    @NotBlank(message = "Name must be not empty!")
    @Column(name = "gender_name",
            columnDefinition = "varchar(10) default 'unknown'")
    private String genderName;

    public Gender(String genderName) {
        this.genderName = genderName;
    }
}
