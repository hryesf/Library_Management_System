package com.myresume.librarymanagementsystem.bookauthor.repository;

import com.myresume.librarymanagementsystem.bookauthor.entity.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookAuthorRepository extends JpaRepository<BookAuthor, Integer> {
}
