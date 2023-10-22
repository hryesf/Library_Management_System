package com.myresume.librarymanagementsystem.jointables.donatedbook.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.myresume.librarymanagementsystem.book.entity.Book;
import com.myresume.librarymanagementsystem.library.entity.Library;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class DonatedBook {

    @EmbeddedId
    private DonatedBookId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("bookId")
    @JoinColumn(name = "libbook_book_id",
            foreignKey = @ForeignKey( name = "library_book_book_id_fk"))
    @JsonIgnoreProperties("donatedBooks")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("libraryId")
    @JoinColumn(name = "libbook_library_id",
            foreignKey = @ForeignKey( name = "library_book_library_id_fk"))
    @JsonIgnoreProperties("donatedBooks")
    private Library library;

    private LocalDate libbook_donateDate;

    @Override
    public String toString() {
        return "DonatedBook{" +
                "id=" + id +
                ", book=" + book.getBook_title() +
                ", library=" + library.getLibrary_name() +
                ", libbook_donateDate=" + libbook_donateDate +
                '}';
    }
}
