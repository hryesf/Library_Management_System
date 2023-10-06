package com.myresume.librarymanagementsystem.library.service;

import com.myresume.librarymanagementsystem.exception.NotFoundException;
import com.myresume.librarymanagementsystem.library.repository.LibraryRepository;
import com.myresume.librarymanagementsystem.library.entity.Library;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public List<Library> getLibraries() {
        return libraryRepository.findAll();
    }

    public Library getLibraryById(int id) {
        return libraryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Member with id " + id + " not Found"));
    }

    public Library saveLibrary(Library library){
        return libraryRepository.save(library);
    }

    public String deleteLibraryById(int id){
        libraryRepository.deleteById(id);
        return "Library with code id = " + id + " removed!";
    }

}
