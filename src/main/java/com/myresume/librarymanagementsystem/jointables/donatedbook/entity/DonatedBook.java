package com.myresume.librarymanagementsystem.jointables.donatedbook.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.myresume.librarymanagementsystem.book.entity.Book;
import com.myresume.librarymanagementsystem.library.entity.Library;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "DonatedBook")
@Table(name = "donated_book")
public class DonatedBook {

    @EmbeddedId
    private DonatedBookId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("bookId")
    @JoinColumn(name = "book_id",
            foreignKey = @ForeignKey( name = "donated_book_book_id_fk"))
    @JsonIgnoreProperties("donatedBookList")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("libraryId")
    @JoinColumn(name = "library_id",
            foreignKey = @ForeignKey( name = "donated_book_library_id_fk"))
    @JsonIgnoreProperties("donatedBookList")
    private Library library;

    @Column(name = "donate_date")
    private LocalDate DonateDate;

    @Override
    public String toString() {
        return "DonatedBook{" +
                "id=" + id +
                ", book=" + book.getBookTitle() +
                ", library=" + library.getLibraryName() +
                ", DonateDate=" + DonateDate +
                '}';
    }
}
