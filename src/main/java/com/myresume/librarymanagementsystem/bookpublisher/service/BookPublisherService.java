package com.myresume.librarymanagementsystem.bookpublisher.service;

import com.myresume.librarymanagementsystem.bookpublisher.entity.BookPublisher;
import com.myresume.librarymanagementsystem.bookpublisher.repository.BookPublisherRepository;
import com.myresume.librarymanagementsystem.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookPublisherService {

    final BookPublisherRepository bookPublisherRepository;

    public BookPublisherService(BookPublisherRepository bookPublisherRepository) {
        this.bookPublisherRepository = bookPublisherRepository;
    }

    public void saveBookPublisher(BookPublisher bookPublisher) {
        bookPublisherRepository.save(bookPublisher);
    }

    public void saveBookPublishers(List<BookPublisher> bookPublishers) {
        bookPublisherRepository.saveAll(bookPublishers);
    }

    public List<BookPublisher> getAllBookPublishers() {
        return bookPublisherRepository.findAll();
    }

    public BookPublisher getBookPublisher(int id) {
        return bookPublisherRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Member with id " + id + " not Found"));
    }

    public String deleteBookPublisherById(int id){
        bookPublisherRepository.deleteById(id);
        return "Book Publisher with code " + id + " removed from list";
    }
}
