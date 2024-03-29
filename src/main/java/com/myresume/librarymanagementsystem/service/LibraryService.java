package com.myresume.librarymanagementsystem.service;

import com.myresume.librarymanagementsystem.exception.NotFoundException;
import com.myresume.librarymanagementsystem.repository.LibraryRepository;
import com.myresume.librarymanagementsystem.entity.Library;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final LibraryConverter libraryConverter;

    public LibraryService(LibraryRepository libraryRepository, LibraryConverter libraryConverter) {
        this.libraryRepository = libraryRepository;
        this.libraryConverter = libraryConverter;
    }

    public List<LibraryDTO> getLibraries() {
        return libraryConverter.libraryDTOList(libraryRepository.findAll());
    }

    public LibraryDTO getLibraryById(Long id) {
        return libraryConverter.toDto(libraryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Member with id " + id + " not Found")));
    }

    public LibraryDTO saveLibrary(Library library){
        return libraryConverter.toDto(libraryRepository.save(library));
    }

    public String deleteLibraryById(Long id){
        libraryRepository.deleteById(id);
        return "Library with code id = " + id + " removed!";
    }

}
