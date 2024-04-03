package com.myresume.librarymanagementsystem.controller;

import com.myresume.librarymanagementsystem.entity.Book;
import com.myresume.librarymanagementsystem.dto.BookDTO;
import com.myresume.librarymanagementsystem.service.BookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/books")
public class BookController {

    final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    String getLibraries() {
        return bookService.getBooks().toString();
    }

    @GetMapping(path = "/{book_id}")
    String getLibraryById(@PathVariable("book_id") Long id) {
        return bookService.getBookById(id).toString();
    }

    @PostMapping
    BookDTO saveBook(@Valid @RequestBody Book book) {
        return bookService.saveBook(book);
    }
}
