package com.myresume.librarymanagementsystem.controller;

import com.myresume.librarymanagementsystem.entity.Author;
import com.myresume.librarymanagementsystem.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/bookAuthors")
public class AuthorController {

    final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    List<Author> getAllBookAuthors() {
       return authorService.getAllBookAuthors();
    }

    @GetMapping(path = "/{book_author_id}")
    Author getBookAuthor(@PathVariable("book_author_id") Long id) {
        return authorService.getBookAuthor(id);
    }

    @PostMapping(path = "/singlePost")
    Author saveBookAuthor(@Valid @RequestBody Author author) {
        authorService.saveBookAuthor(author);
        return author;
    }

    @PostMapping(path = "/groupPost")
    public ResponseEntity<String> saveBookAuthors(@Valid @RequestBody List<Author> authors) {
        authorService.saveBookAuthors(authors);
        return ResponseEntity.ok("Entities saved successfully");
    }

    @DeleteMapping(path = "/{book_author_id}")
    String deleteMemberById(@PathVariable("book_author_id") Long id) {
        return authorService.deleteBookAuthorById(id);
    }

}
