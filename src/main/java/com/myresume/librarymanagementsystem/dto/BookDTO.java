package com.myresume.librarymanagementsystem.dto;

import lombok.Data;

@Data
public class BookDTO {
    private String bookTitle;
    private Integer bookIsBorrowed;
    private Integer bookEdition;
    private String authorName;
    private String categoryName;
    private String publisherName;

}
