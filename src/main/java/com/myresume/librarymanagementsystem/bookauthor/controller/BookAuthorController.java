package com.myresume.librarymanagementsystem.bookauthor.controller;

import com.myresume.librarymanagementsystem.bookauthor.entity.BookAuthor;
import com.myresume.librarymanagementsystem.bookauthor.service.BookAuthorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/bookAuthors")
public class BookAuthorController {

    final BookAuthorService bookAuthorService;

    public BookAuthorController(BookAuthorService bookAuthorService) {
        this.bookAuthorService = bookAuthorService;
    }

    @GetMapping
    List<BookAuthor> getAllBookAuthors() {
       return bookAuthorService.getAllBookAuthors();
    }

    @GetMapping(path = "/{boauth_id}")
    BookAuthor getBookAuthor(@PathVariable("boauth_id") int id) {
        return bookAuthorService.getBookAuthor(id);
    }

    @PostMapping(path = "/singlePost")
    BookAuthor saveBookAuthor(@Valid @RequestBody BookAuthor bookAuthor) {
        bookAuthorService.saveBookAuthor(bookAuthor);
        return bookAuthor;
    }

    @PostMapping(path = "/groupPost")
    public ResponseEntity<String> saveBookAuthors(@Valid @RequestBody List<BookAuthor> bookAuthors) {
        bookAuthorService.saveBookAuthors(bookAuthors);
        return ResponseEntity.ok("Entities saved successfully");
    }

    @DeleteMapping(path = "/{boauth_id}")
    String deleteMemberById(@PathVariable("boauth_id") int id) {
        return bookAuthorService.deleteBookAuthorById(id);
    }

}
