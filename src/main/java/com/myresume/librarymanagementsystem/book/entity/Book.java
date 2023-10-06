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
@Entity
@Table
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int book_id;

    @NotBlank(message = "Book Title can not be empty!")
    private String book_title;

    @NotNull(message = "You must enter the borrow state!")
    private int book_isBorrowed;

    private int book_edition;
    private int book_category_id;
    private int book_author_id;
    private int book_publisher_id;
}
