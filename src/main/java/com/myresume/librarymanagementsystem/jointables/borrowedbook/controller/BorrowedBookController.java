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

    @PostMapping
    public BorrowedBook borrowBook(@RequestBody BorrowedBookId borrowedBookId) {
        return borrowedBookService.borrowBook(borrowedBookId);
    }

    @DeleteMapping("/{id}")
    public void returnBook(@PathVariable BorrowedBookId id) {
        borrowedBookService.returnBook(id);
    }
}
