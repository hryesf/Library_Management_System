package com.myresume.librarymanagementsystem.bookcategory.service;

import com.myresume.librarymanagementsystem.bookcategory.entity.BookCategory;
import com.myresume.librarymanagementsystem.bookcategory.repository.BookCategoryRepository;
import com.myresume.librarymanagementsystem.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCategoryService {

    final BookCategoryRepository bookCategoryRepository;

    public BookCategoryService(BookCategoryRepository bookCategoryRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
    }

    public void saveBookCategory(BookCategory bookCategory) {
        bookCategoryRepository.save(bookCategory);
    }

    public void saveBookCategories(List<BookCategory> genders) {
        bookCategoryRepository.saveAll(genders);
    }

    public List<BookCategory> getAllBookCategories() {
        return bookCategoryRepository.findAll();
    }

    public BookCategory getBookCategory(int id) {
        return bookCategoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Member with id " + id + " not Found"));
    }

    public String deleteBookCategoryById(int id) {
        bookCategoryRepository.deleteById(id);
        return "Book Category with code " + id + " removed from list";
    }
}
