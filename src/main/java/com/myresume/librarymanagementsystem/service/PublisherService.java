package com.myresume.librarymanagementsystem.service;

import com.myresume.librarymanagementsystem.entity.Publisher;
import com.myresume.librarymanagementsystem.repository.PublisherRepository;
import com.myresume.librarymanagementsystem.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PublisherService {

    final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public void saveBookPublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public void saveBookPublishers(List<Publisher> publishers) {
        publisherRepository.saveAll(publishers);
    }

    public List<Publisher> getAllBookPublishers() {
        return publisherRepository.findAll();
    }

    public Publisher getBookPublisher(Long id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Member with id " + id + " not Found"));
    }

    public String deleteBookPublisherById(Long id){
        publisherRepository.deleteById(id);
        return "Book Publisher with code " + id + " removed from list";
    }
}
