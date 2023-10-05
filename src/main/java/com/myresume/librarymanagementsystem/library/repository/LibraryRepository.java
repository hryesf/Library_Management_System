package com.myresume.librarymanagementsystem.library.repository;

import com.myresume.librarymanagementsystem.library.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {
}
