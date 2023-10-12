package com.myresume.librarymanagementsystem.gender.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Gender {

    @Id
    @SequenceGenerator(name = "gender_id_sequence", sequenceName = "gender_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gender_id_sequence")
    private Integer gender_id;

    @NotBlank(message = "Name must be not empty!")
    @Column(columnDefinition = "varchar(10) default 'unknown'")
    private String gender_name;

    public Gender(String gender_name) {
        this.gender_name = gender_name;
    }
}
