package com.myresume.librarymanagementsystem.bookcategory.entity;

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
public class BookCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bocat_id;

    @NotBlank(message = "Name must be not empty!")
    @Column(columnDefinition = "varchar(20)")
    private String bocat_name;


    @Column(columnDefinition = "varchar(100)")
    private String bocat_description;
}
