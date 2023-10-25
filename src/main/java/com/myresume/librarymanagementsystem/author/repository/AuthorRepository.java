package com.myresume.librarymanagementsystem.author.repository;

import com.myresume.librarymanagementsystem.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
