package com.myresume.librarymanagementsystem.bookauthor.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

//@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class BookAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
