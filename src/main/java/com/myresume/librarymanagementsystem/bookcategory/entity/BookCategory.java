package com.myresume.librarymanagementsystem.bookcategory.entity;

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
public class BookCategory {

    @Id
    @SequenceGenerator(name = "bocat_id_sequence", sequenceName = "bocat_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bocat_id_sequence")
    private Integer bocat_id;

    @NotBlank(message = "Name must be not empty!")
    @Column(columnDefinition = "varchar(20)")
    private String bocat_name;


    @Column(columnDefinition = "varchar(100)")
    private String bocat_description;
}
