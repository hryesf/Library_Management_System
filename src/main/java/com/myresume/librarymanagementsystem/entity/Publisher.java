package com.myresume.librarymanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Publisher")
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private Long publisherId;

    @NotBlank(message = "Name must be not empty!")
    @Column(name = "publisher_name",
            columnDefinition = "varchar(20)")
    private String publisherName;


    @Column(name = "publisher_description",
            columnDefinition = "varchar(100)")
    private String publisherDescription;
}
