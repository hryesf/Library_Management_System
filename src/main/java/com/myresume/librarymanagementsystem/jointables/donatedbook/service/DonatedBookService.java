package com.myresume.librarymanagementsystem.jointables.donatedbook.service;

import com.myresume.librarymanagementsystem.entity.Book;
import com.myresume.librarymanagementsystem.repository.BookRepository;
import com.myresume.librarymanagementsystem.jointables.donatedbook.entity.DonatedBook;
import com.myresume.librarymanagementsystem.jointables.donatedbook.entity.DonatedBookId;
import com.myresume.librarymanagementsystem.jointables.donatedbook.repository.DonatedBookRepository;
import com.myresume.librarymanagementsystem.entity.Library;
import com.myresume.librarymanagementsystem.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DonatedBookService {
    private final DonatedBookRepository donatedBookRepository;
    private final BookRepository bookRepository;
    private final LibraryRepository libraryRepository;

    public DonatedBookService(DonatedBookRepository donatedBookRepository,
                              BookRepository bookRepository,
                              LibraryRepository libraryRepository) {
        this.donatedBookRepository = donatedBookRepository;
        this.bookRepository = bookRepository;
        this.libraryRepository = libraryRepository;
    }

    public List<DonatedBook> getAllDonatedBooks() {
        return donatedBookRepository.findAll();
    }

    public DonatedBook donateBook(Long libraryId, Long bookId) {

        Book book = bookRepository.findById(bookId).orElseThrow();
        Library library = libraryRepository.findById(libraryId).orElseThrow();

        DonatedBook donatedBook = new DonatedBook(
                new DonatedBookId(bookId, libraryId), book, library, LocalDate.now());

        return donatedBookRepository.save(donatedBook);
    }

}
