package com.myresume.librarymanagementsystem.publisher.repository;

import com.myresume.librarymanagementsystem.publisher.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
