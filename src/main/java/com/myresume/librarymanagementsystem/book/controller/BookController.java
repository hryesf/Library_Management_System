package com.myresume.librarymanagementsystem.book.controller;

import com.myresume.librarymanagementsystem.book.entity.Book;
import com.myresume.librarymanagementsystem.book.service.BookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/books")
public class BookController {

    final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    List<Book> getLibraries() {
        return bookService.getBooks();
    }

    @GetMapping(path = "/{book_id}")
    Book getLibraryById(@PathVariable("book_id") int id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    Book saveBook(@Valid @RequestBody Book book) {
        return bookService.saveBook(book);
    }
}
