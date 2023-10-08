package com.myresume.librarymanagementsystem.book.entity;

import com.myresume.librarymanagementsystem.bookauthor.entity.BookAuthor;
import com.myresume.librarymanagementsystem.bookcategory.entity.BookCategory;
import com.myresume.librarymanagementsystem.bookpublisher.entity.BookPublisher;
import com.myresume.librarymanagementsystem.jointables.librarybook.LibraryBook;
import com.myresume.librarymanagementsystem.jointables.memberbook.MemberBook;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "book_author_id", referencedColumnName = "boauth_id")
    private BookAuthor book_author_id;

    @ManyToOne
    @JoinColumn(name = "book_category_id", referencedColumnName = "bocat_id")
    private BookCategory book_category_id;

    @ManyToOne
    @JoinColumn(name = "book_publisher_id", referencedColumnName = "bopub_id")
    private BookPublisher book_publisher_id;

    @OneToMany(mappedBy = "book")
    private List<LibraryBook> libraryBookList;

    @OneToMany(mappedBy = "book")
    private List<MemberBook> memberBookList;
}
