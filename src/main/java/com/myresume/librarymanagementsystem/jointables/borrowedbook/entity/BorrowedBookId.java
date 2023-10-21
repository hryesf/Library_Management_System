package com.myresume.librarymanagementsystem.jointables.borrowedbook.entity;

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
public class BorrowedBookId implements Serializable {

    @Column(name = "borrowedBook_member_id")
    private Integer memberId;

    @Column(name = "borrowedBook_book_id")
    private Integer bookId;
}
