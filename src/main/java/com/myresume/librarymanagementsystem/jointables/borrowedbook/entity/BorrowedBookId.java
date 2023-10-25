package com.myresume.librarymanagementsystem.jointables.borrowedbook.entity;

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

    private Long memberId;
    private Long bookId;
}
