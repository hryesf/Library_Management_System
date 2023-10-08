package com.myresume.librarymanagementsystem.bookpublisher.entity;

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
public class BookPublisher {

    @Id
    @SequenceGenerator(name = "bopub_id_sequence", sequenceName = "bopub_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bopub_id_sequence")
    private Integer bopub_id;

    @NotBlank(message = "Name must be not empty!")
    @Column(columnDefinition = "varchar(20)")
    private String bopub_name;


    @Column(columnDefinition = "varchar(100)")
    private String bopub_description;
}
