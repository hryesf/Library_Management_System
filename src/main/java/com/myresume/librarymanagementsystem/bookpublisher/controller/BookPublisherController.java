package com.myresume.librarymanagementsystem.bookpublisher.controller;

import com.myresume.librarymanagementsystem.bookpublisher.entity.BookPublisher;
import com.myresume.librarymanagementsystem.bookpublisher.service.BookPublisherService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/bookPublishers")
public class BookPublisherController {

    final BookPublisherService bookPublisherService;

    public BookPublisherController(BookPublisherService bookPublisherService) {
        this.bookPublisherService = bookPublisherService;
    }

    @GetMapping
    List<BookPublisher> getAllBookPublishers() {
        return bookPublisherService.getAllBookPublishers();
    }

    @GetMapping(path = "/{bopub_id}")
    BookPublisher getBookPublisher(@PathVariable("bopub_id") int id) {
        return bookPublisherService.getBookPublisher(id);
    }

    @PostMapping(path = "/singlePost")
    BookPublisher saveBookPublisher(@Valid @RequestBody BookPublisher bookPublisher) {
        bookPublisherService.saveBookPublisher(bookPublisher);
        return bookPublisher;
    }

    @PostMapping(path = "/groupPost")
    public ResponseEntity<String> saveBookPublishers(@Valid @RequestBody List<BookPublisher> bookPublishers) {
        bookPublisherService.saveBookPublishers(bookPublishers);
        return ResponseEntity.ok("Entities saved successfully");
    }

    @DeleteMapping(path = "/{bopub_id}")
    String deleteMemberById(@PathVariable("bopub_id") int id) {
        return bookPublisherService.deleteBookPublisherById(id);
    }

}
