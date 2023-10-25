package com.myresume.librarymanagementsystem.jointables.donatedbook.entity;

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

    private Long bookId;
    private Long libraryId;
}
