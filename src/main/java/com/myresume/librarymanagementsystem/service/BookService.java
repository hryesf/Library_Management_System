package com.myresume.librarymanagementsystem.service;

import com.myresume.librarymanagementsystem.dto.BookConverter;
import com.myresume.librarymanagementsystem.dto.BookDTO;
import com.myresume.librarymanagementsystem.entity.Book;
import com.myresume.librarymanagementsystem.repository.BookRepository;
import com.myresume.librarymanagementsystem.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookConverter bookConverter;
    public BookService(BookRepository bookRepository, BookConverter bookConverter) {
        this.bookRepository = bookRepository;
        this.bookConverter = bookConverter;
    }

    public List<BookDTO> getBooks() {
        return bookConverter.BookDTOList(bookRepository.findAll());
    }

    public BookDTO getBookById(Long id) {
        return bookConverter.toDto(bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Member with id " + id + " not Found")));
    }

    public BookDTO saveBook(Book book){
        return bookConverter.toDto(bookRepository.save(book));
    }
    

}
