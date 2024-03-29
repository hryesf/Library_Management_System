package com.myresume.librarymanagementsystem.repository;

import com.myresume.librarymanagementsystem.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
