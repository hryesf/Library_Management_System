package com.myresume.librarymanagementsystem.repository;

import com.myresume.librarymanagementsystem.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
}
