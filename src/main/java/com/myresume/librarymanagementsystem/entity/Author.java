package com.myresume.librarymanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

//@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Author")
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long authorId;

    @NotBlank(message = "Name must be not empty!")
    @Column(name = "author_name",
            columnDefinition = "varchar(20)")
    private String authorName;

    @NotBlank(message = "Last name must be not empty!")
    @Column(name = "author_last_name",
            columnDefinition = "varchar(50)")
    private String authorLastName;

    @Column(name = "author_artistic_name",
            columnDefinition = "varchar(50)")
    private String authorArtisticName;

    @Column(name = "author_description",
            columnDefinition = "varchar(100)")
    private String authorDescription;
}
