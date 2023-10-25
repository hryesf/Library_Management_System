package com.myresume.librarymanagementsystem.book.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.myresume.librarymanagementsystem.author.entity.Author;
import com.myresume.librarymanagementsystem.category.entity.Category;
import com.myresume.librarymanagementsystem.publisher.entity.Publisher;
import com.myresume.librarymanagementsystem.jointables.borrowedbook.entity.BorrowedBook;
import com.myresume.librarymanagementsystem.jointables.donatedbook.entity.DonatedBook;
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
@Table(name = "book")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    @NaturalId
    @NotBlank(message = "Book Title can not be empty!")
    @Column(name = "book_title",
            columnDefinition = "varchar(20)")
    private String bookTitle;

    @NotNull(message = "You must enter the borrow state!")
    @Column(name = "book_is_borrowed")
    private Integer bookIsBorrowed;

    @Column(name = "book_edition")
    private Integer bookEdition;

    @ManyToOne
    @JoinColumn(name = "book_author_id",
            referencedColumnName = "author_id",
            foreignKey = @ForeignKey( name = "book_author_id_fk"))
    private Author author;

    @ManyToOne
    @JoinColumn(name = "book_category_id",
            referencedColumnName = "category_id",
            foreignKey = @ForeignKey( name = "book_category_id_fk"))
    private Category category;

    @ManyToOne
    @JoinColumn(name = "book_publisher_id",
            referencedColumnName = "publisher_id",
            foreignKey = @ForeignKey( name = "book_publisher_id_fk"))
    private Publisher publisher;

    @OneToMany(mappedBy = "book",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("book")
    private Set<BorrowedBook> borrowedBookList = new HashSet<>();

    @OneToMany(mappedBy = "book",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("book")
    private Set<DonatedBook> donatedBookList = new HashSet<>();

    public Book(String bookTitle, Integer bookIsBorrowed) {
        this.bookTitle = bookTitle;
        this.bookIsBorrowed = bookIsBorrowed;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id=" + bookId +
                ", Title='" + bookTitle + '\'' +
                ", IsBorrowed=" + bookIsBorrowed +
                ", Edition=" + bookEdition +
                ", AuthorName=" + author.getAuthorName() +
                ", CategoryName=" + category.getCategoryName() +
                ", PublisherName=" + publisher.getPublisherName() +
                ", borrowedBooks=" + borrowedBookList.toString() +
                ", donatedBooks=" + donatedBookList.toString() +
                '}';
    }
}
