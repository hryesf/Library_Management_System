package com.myresume.librarymanagementsystem.controller;

import com.myresume.librarymanagementsystem.entity.Library;
import com.myresume.librarymanagementsystem.dto.LibraryDTO;
import com.myresume.librarymanagementsystem.service.LibraryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/libraries")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    List<LibraryDTO> getLibraries() {
        return libraryService.getLibraries();
    }

    @GetMapping(path = "/{library_id}")
    LibraryDTO getLibraryById(@PathVariable("library_id") Long id) {
        return libraryService.getLibraryById(id);
    }

    @PostMapping
    String saveLibrary(@Valid @RequestBody Library library) {
        return libraryService.saveLibrary(library).toString() + "\nSaved in database";
    }

    @DeleteMapping(path = "/{library_id}")
    String deleteLibraryById(@PathVariable("library_id") Long id){
        return libraryService.deleteLibraryById(id);
    }
}
