package com.myresume.librarymanagementsystem.bookcategory.controller;

import com.myresume.librarymanagementsystem.bookcategory.entity.BookCategory;
import com.myresume.librarymanagementsystem.bookcategory.service.BookCategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/bookCategories")
public class BookCategoryController {

    final BookCategoryService bookCategoryService;

    public BookCategoryController(BookCategoryService bookCategoryService) {
        this.bookCategoryService = bookCategoryService;
    }

    @GetMapping
    List<BookCategory> getAllBookCategories() {
        return bookCategoryService.getAllBookCategories();
    }

    @GetMapping(path = "/{bocat_id}")
    BookCategory getBookCategory(@PathVariable("bocat_id") int id) {
        return bookCategoryService.getBookCategory(id);
    }

    @PostMapping(path = "/singlePost")
    BookCategory saveBookCategory(@Valid @RequestBody BookCategory bookCategory) {
        bookCategoryService.saveBookCategory(bookCategory);
        return bookCategory;
    }

    @PostMapping(path = "/groupPost")
    public ResponseEntity<String> saveBookCategories(@Valid @RequestBody List<BookCategory> bookCategories) {
        bookCategoryService.saveBookCategories(bookCategories);
        return ResponseEntity.ok("Entities saved successfully");
    }

    @DeleteMapping(path = "/{bocat_id}")
    String deleteMemberById(@PathVariable("bocat_id") int id) {
        return bookCategoryService.deleteBookCategoryById(id);
    }

}
