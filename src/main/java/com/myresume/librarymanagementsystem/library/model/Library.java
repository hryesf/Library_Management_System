package com.myresume.librarymanagementsystem.library.model;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Library {
    @Id
    int LIBRARY_ID ;
    String LIBRARY_NAME;
    String LIBRARY_ADDRESS;
    int LIBRARY_REGION;
    int LIBRARY_TEL;
}
