package com.myresume.librarymanagementsystem.jointables.donatedbook.entity;

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
public class DonatedBookId implements Serializable {

    @Column(name = "libbook_book_id")
    private Integer bookId;

    @Column(name = "libbook_library_id")
    private Integer libraryId;
}
