package com.myresume.librarymanagementsystem.library.controller;

import com.myresume.librarymanagementsystem.library.entity.Library;
import com.myresume.librarymanagementsystem.library.service.LibraryService;
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
    List<Library> getLibraries() {
        return libraryService.getLibraries();
    }

    @GetMapping(path = "/{library_id}")
    Library getLibraryById(@PathVariable("library_id") Long id) {
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
