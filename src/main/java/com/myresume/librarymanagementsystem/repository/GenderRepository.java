package com.myresume.librarymanagementsystem.repository;

import com.myresume.librarymanagementsystem.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Long> {
}
