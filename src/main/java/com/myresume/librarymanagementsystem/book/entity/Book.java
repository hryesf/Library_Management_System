package com.myresume.librarymanagementsystem.book.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Book")
@Table
public class Book {
    
    @Id
    @SequenceGenerator(name = "book_id_seq", sequenceName = "book_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_seq")
    private Integer book_id;

    @NotBlank(message = "Book Title can not be empty!")
    private String book_title;

    @NotNull(message = "You must enter the borrow state!")
    private Integer book_isBorrowed;

    private Integer book_edition;
    private Integer book_category_id;
    private Integer book_author_id;
    private Integer book_publisher_id;
}
