package com.myresume.librarymanagementsystem.book.entity;

import com.myresume.librarymanagementsystem.bookauthor.entity.BookAuthor;
import com.myresume.librarymanagementsystem.bookcategory.entity.BookCategory;
import com.myresume.librarymanagementsystem.bookpublisher.entity.BookPublisher;
import com.myresume.librarymanagementsystem.jointables.borrowedbook.entity.BorrowedBook;
import com.myresume.librarymanagementsystem.jointables.donatedbook.entity.DonatedBook;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import java.util.HashSet;
import java.util.Set;

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
    private Set<DonatedBook> donatedBookList = new HashSet<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BorrowedBook> borrowedBookList = new HashSet<>();

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", book_title='" + book_title + '\'' +
                ", book_isBorrowed=" + book_isBorrowed +
                ", book_edition=" + book_edition +
                ", book_author_id=" + book_author_id +
                ", book_category_id=" + book_category_id +
                ", book_publisher_id=" + book_publisher_id +
                ", donatedBookList=" + donatedBookList +
                /*", borrowedBookList=" + borrowedBookList +*/
                ", borrowedBookList=" + (borrowedBookList != null ? borrowedBookList.size() : 0) +
                '}';
    }
}
