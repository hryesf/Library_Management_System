package com.myresume.librarymanagementsystem.bookauthor.entity;

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
public class BookAuthor {

    @Id
    @SequenceGenerator(name = "boauth_id_sequence", sequenceName = "boauth_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "boauth_id_sequence")
    private Integer boauth_id;

    @NotBlank(message = "Name must be not empty!")
    @Column(columnDefinition = "varchar(20)")
    private String boauth_name;

    @NotBlank(message = "Last name must be not empty!")
    @Column(columnDefinition = "varchar(50)")
    private String boauth_lastName;

    @Column(columnDefinition = "varchar(50)")
    private String boauth_artisticName;

    @Column(columnDefinition = "varchar(100)")
    private String boauth_description;
}
