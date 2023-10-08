package com.myresume.librarymanagementsystem.bookpublisher.repository;

import com.myresume.librarymanagementsystem.bookpublisher.entity.BookPublisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookPublisherRepository extends JpaRepository<BookPublisher, Integer> {
}
