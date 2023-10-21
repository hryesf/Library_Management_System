package com.myresume.librarymanagementsystem.jointables.borrowedbook.controller;

import com.myresume.librarymanagementsystem.jointables.borrowedbook.entity.BorrowedBook;
import com.myresume.librarymanagementsystem.jointables.borrowedbook.entity.BorrowedBookId;
import com.myresume.librarymanagementsystem.jointables.borrowedbook.service.BorrowedBookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/borrowed-books")
public class BorrowedBookController {
    private final BorrowedBookService borrowedBookService;

    public BorrowedBookController(BorrowedBookService borrowedBookService) {
        this.borrowedBookService = borrowedBookService;
    }

    @GetMapping
    public List<BorrowedBook> getAllBorrowedBooks() {
        return borrowedBookService.getAllBorrowedBooks();
    }

    @PostMapping("/{member_id}/{book_id}")
    public BorrowedBook borrowBook(@PathVariable Integer member_id , @PathVariable Integer book_id) {
        return borrowedBookService.borrowBook(member_id, book_id);
    }

    @DeleteMapping("/{id}")
    public void returnBook(@PathVariable BorrowedBookId id) {
        borrowedBookService.returnBook(id);
    }
}
