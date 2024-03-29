package com.myresume.librarymanagementsystem.service;

import com.myresume.librarymanagementsystem.entity.Category;
import com.myresume.librarymanagementsystem.repository.CategoryRepository;
import com.myresume.librarymanagementsystem.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void saveBookCategory(Category category) {
        categoryRepository.save(category);
    }

    public void saveBookCategories(List<Category> genders) {
        categoryRepository.saveAll(genders);
    }

    public List<Category> getAllBookCategories() {
        return categoryRepository.findAll();
    }

    public Category getBookCategory(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Member with id " + id + " not Found"));
    }

    public String deleteBookCategoryById(Long id) {
        categoryRepository.deleteById(id);
        return "Book Category with code " + id + " removed from list";
    }
}
