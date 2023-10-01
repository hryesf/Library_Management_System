package com.myresume.librarymanagementsystem.book.model;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Book {
    @Id
    private int BOOK_ID;
    private final String BOOK_TITLE;
    private final int BOOK_EDITION;
    private final double BOOK_PRICE;
    private final int BOOK_CATEGORY_ID;
    private final int BOOK_AUTHOR_ID;
    private final int BOOK_STATUS_ID;
    private final int BOOK_PUBLISHER_ID;
}
