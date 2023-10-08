package com.myresume.librarymanagementsystem.bookcategory.repository;


import com.myresume.librarymanagementsystem.bookcategory.entity.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer> {
}
