package com.myresume.librarymanagementsystem.controller;

import com.myresume.librarymanagementsystem.entity.Category;
import com.myresume.librarymanagementsystem.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/bookCategories")
public class CategoryController {

    final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    List<Category> getAllBookCategories() {
        return categoryService.getAllBookCategories();
    }

    @GetMapping(path = "/{book_category_id}")
    Category getBookCategory(@PathVariable("book_category_id") Long id) {
        return categoryService.getBookCategory(id);
    }

    @PostMapping(path = "/singlePost")
    Category saveBookCategory(@Valid @RequestBody Category category) {
        categoryService.saveBookCategory(category);
        return category;
    }

    @PostMapping(path = "/groupPost")
    public ResponseEntity<String> saveBookCategories(@Valid @RequestBody List<Category> bookCategories) {
        categoryService.saveBookCategories(bookCategories);
        return ResponseEntity.ok("Entities saved successfully");
    }

    @DeleteMapping(path = "/{book_category_id}")
    String deleteMemberById(@PathVariable("book_category_id") Long id) {
        return categoryService.deleteBookCategoryById(id);
    }

}
