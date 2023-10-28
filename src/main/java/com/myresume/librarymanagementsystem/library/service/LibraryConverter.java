package com.myresume.librarymanagementsystem.library.service;

import com.myresume.librarymanagementsystem.library.entity.Library;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LibraryConverter {
    public LibraryDTO toDto(Library Library) {
        LibraryDTO dto = new LibraryDTO();
        dto.setLibraryName(Library.getLibraryName());
        dto.setLibraryAddress(Library.getLibraryAddress());
        dto.setLibraryRegion(Library.getLibraryRegion());
        dto.setLibraryTel(Library.getLibraryTel());

        return dto;
    }

    public List<LibraryDTO> libraryDTOList(List<Library> libraryList){
        return libraryList.stream().map(this::toDto).collect(Collectors.toList());
    }

    /*public Library toEntity(LibraryDTO dto) {
        Library Library = new Library();
        Library.setLibraryName(dto.getLibraryName());
        Library.setLibraryAddress(dto.getLibraryAddress());
        Library.setLibraryRegion(dto.getLibraryRegion());
        Library.setLibraryTel(dto.getLibraryTel());

        return Library;
    }*/
}
