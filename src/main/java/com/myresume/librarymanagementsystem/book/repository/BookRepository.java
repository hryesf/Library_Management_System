package com.myresume.librarymanagementsystem.book.repository;

import com.myresume.librarymanagementsystem.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
