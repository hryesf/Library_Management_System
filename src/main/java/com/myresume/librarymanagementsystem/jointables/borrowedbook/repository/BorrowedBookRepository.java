package com.myresume.librarymanagementsystem.jointables.borrowedbook.repository;

import com.myresume.librarymanagementsystem.jointables.borrowedbook.entity.BorrowedBook;
import com.myresume.librarymanagementsystem.jointables.borrowedbook.entity.BorrowedBookId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, BorrowedBookId> {

}
