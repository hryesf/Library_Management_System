package com.myresume.librarymanagementsystem.bookpublisher.entity;

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
public class BookPublisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bopub_id;

    @NotBlank(message = "Name must be not empty!")
    @Column(columnDefinition = "varchar(20)")
    private String bopub_name;


    @Column(columnDefinition = "varchar(100)")
    private String bopub_description;
}
