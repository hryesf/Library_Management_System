package com.myresume.librarymanagementsystem.jointables.donatedbook.repository;

import com.myresume.librarymanagementsystem.jointables.donatedbook.entity.DonatedBook;
import com.myresume.librarymanagementsystem.jointables.donatedbook.entity.DonatedBookId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonatedBookRepository extends JpaRepository<DonatedBook, DonatedBookId> {
}
