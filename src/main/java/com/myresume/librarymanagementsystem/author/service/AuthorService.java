package com.myresume.librarymanagementsystem.author.service;

import com.myresume.librarymanagementsystem.author.entity.Author;
import com.myresume.librarymanagementsystem.author.repository.AuthorRepository;
import com.myresume.librarymanagementsystem.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void saveBookAuthor(Author author) {
        authorRepository.save(author);
    }

    public void saveBookAuthors(List<Author> genders) {
        authorRepository.saveAll(genders);
    }

    public List<Author> getAllBookAuthors() {
        return authorRepository.findAll();
    }

    public Author getBookAuthor(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Member with id " + id + " not Found"));
    }

    public String deleteBookAuthorById(Long id){
        authorRepository.deleteById(id);
        return "Book Author with code " + id + " removed from list";
    }
}
