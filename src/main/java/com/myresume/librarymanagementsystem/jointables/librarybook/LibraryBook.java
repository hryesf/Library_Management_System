package com.myresume.librarymanagementsystem.jointables.librarybook;

import com.myresume.librarymanagementsystem.book.entity.Book;
import com.myresume.librarymanagementsystem.library.entity.Library;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class LibraryBook {

    @EmbeddedId
    private LibraryBookId id;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "libbook_book_id")
    private Book book;

    @ManyToOne
    @MapsId("libraryId")
    @JoinColumn(name = "libbook_library_id")
    private Library library;

    private Date libbook_donateDate;
}
