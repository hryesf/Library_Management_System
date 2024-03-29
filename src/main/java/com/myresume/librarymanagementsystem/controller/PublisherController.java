package com.myresume.librarymanagementsystem.controller;

import com.myresume.librarymanagementsystem.entity.Publisher;
import com.myresume.librarymanagementsystem.service.PublisherService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/bookPublishers")
public class PublisherController {

    final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    List<Publisher> getAllBookPublishers() {
        return publisherService.getAllBookPublishers();
    }

    @GetMapping(path = "/{book_publisher_id}")
    Publisher getBookPublisher(@PathVariable("book_publisher_id") Long id) {
        return publisherService.getBookPublisher(id);
    }

    @PostMapping(path = "/singlePost")
    Publisher saveBookPublisher(@Valid @RequestBody Publisher publisher) {
        publisherService.saveBookPublisher(publisher);
        return publisher;
    }

    @PostMapping(path = "/groupPost")
    public ResponseEntity<String> saveBookPublishers(@Valid @RequestBody List<Publisher> publishers) {
        publisherService.saveBookPublishers(publishers);
        return ResponseEntity.ok("Entities saved successfully");
    }

    @DeleteMapping(path = "/{book_publisher_id}")
    String deleteMemberById(@PathVariable("book_publisher_id") Long id) {
        return publisherService.deleteBookPublisherById(id);
    }

}
