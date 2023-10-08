package com.myresume.librarymanagementsystem.jointables.librarybook;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class LibraryBookId implements Serializable {

    @Column(name = "libbook_book_id")
    private Integer bookId;

    @Column(name = "libbook_library_id")
    private Integer libraryId;
}
