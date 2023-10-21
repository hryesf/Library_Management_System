package com.myresume.librarymanagementsystem.book.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.myresume.librarymanagementsystem.bookauthor.entity.BookAuthor;
import com.myresume.librarymanagementsystem.bookcategory.entity.BookCategory;
import com.myresume.librarymanagementsystem.bookpublisher.entity.BookPublisher;
import com.myresume.librarymanagementsystem.jointables.borrowedbook.entity.BorrowedBook;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Book")
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer book_id;

    @NaturalId
    @NotBlank(message = "Book Title can not be empty!")
    private String book_title;

    @NotNull(message = "You must enter the borrow state!")
    private Integer book_isBorrowed;

    private Integer book_edition;

    @ManyToOne
    @JoinColumn(name = "book_author_id", referencedColumnName = "boauth_id",
            foreignKey = @ForeignKey( name = "book_author_id_fk"))
    private BookAuthor book_author_id;

    @ManyToOne
    @JoinColumn(name = "book_category_id", referencedColumnName = "bocat_id",
            foreignKey = @ForeignKey( name = "book_category_id_fk"))
    private BookCategory book_category_id;

    @ManyToOne
    @JoinColumn(name = "book_publisher_id", referencedColumnName = "bopub_id",
            foreignKey = @ForeignKey( name = "book_publisher_id_fk"))
    private BookPublisher book_publisher_id;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("book")
    private Set<BorrowedBook> borrowedBooks = new HashSet<>();

    public Book(String book_title, Integer book_isBorrowed) {
        this.book_title = book_title;
        this.book_isBorrowed = book_isBorrowed;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", book_title='" + book_title + '\'' +
                ", book_isBorrowed=" + book_isBorrowed +
                ", book_edition=" + book_edition +
                ", borrowedBooks=" + borrowedBooks.toString() +
                '}';
    }
}
