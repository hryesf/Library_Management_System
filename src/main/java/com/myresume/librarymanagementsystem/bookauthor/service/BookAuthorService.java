package com.myresume.librarymanagementsystem.bookauthor.service;

import com.myresume.librarymanagementsystem.bookauthor.entity.BookAuthor;
import com.myresume.librarymanagementsystem.bookauthor.repository.BookAuthorRepository;
import com.myresume.librarymanagementsystem.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookAuthorService {

    final BookAuthorRepository bookAuthorRepository;

    public BookAuthorService(BookAuthorRepository bookAuthorRepository) {
        this.bookAuthorRepository = bookAuthorRepository;
    }

    public void saveBookAuthor(BookAuthor bookAuthor) {
        bookAuthorRepository.save(bookAuthor);
    }

    public void saveBookAuthors(List<BookAuthor> genders) {
        bookAuthorRepository.saveAll(genders);
    }

    public List<BookAuthor> getAllBookAuthors() {
        return bookAuthorRepository.findAll();
    }

    public BookAuthor getBookAuthor(int id) {
        return bookAuthorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Member with id " + id + " not Found"));
    }

    public String deleteBookAuthorById(int id){
        bookAuthorRepository.deleteById(id);
        return "Book Author with code " + id + " removed from list";
    }
}
