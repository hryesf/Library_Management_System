package com.myresume.librarymanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Category")
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @NotBlank(message = "Name must be not empty!")
    @Column(name = "category_name",
            columnDefinition = "varchar(20)")
    private String categoryName;


    @Column(name = "category_description",
            columnDefinition = "varchar(100)")
    private String categoryDescription;
}
