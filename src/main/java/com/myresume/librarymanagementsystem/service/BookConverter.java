package com.myresume.librarymanagementsystem.service;

import com.myresume.librarymanagementsystem.entity.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookConverter {

    public BookDTO toDto(Book book) {
        BookDTO dto = new BookDTO();
        dto.setBookTitle(book.getBookTitle());
        dto.setBookEdition(book.getBookEdition());
        dto.setBookIsBorrowed(book.getBookIsBorrowed());
        dto.setAuthorName(book.getAuthor().getAuthorName() + " "+ book.getAuthor().getAuthorLastName());
        dto.setCategoryName(book.getCategory().getCategoryName());
        dto.setPublisherName(book.getPublisher().getPublisherName());

        return dto;
    }

    public List<BookDTO> BookDTOList (List<Book> bookList){
        return bookList.stream().map(this::toDto).collect(Collectors.toList());
    }

    /*public Book toEntity(BookDTO dto) {
        Book book = new Book();
        book.setBookTitle(dto.getBookTitle());
        book.setBookEdition(dto.getBookEdition());
        book.setBookIsBorrowed(dto.getBookIsBorrowed());

        Author author = new Author();
        author.setAuthorName(dto.getAuthorName());
        book.setAuthor(author);

        Category category = new Category();
        category.setCategoryName(dto.getCategoryName());
        book.setCategory(category);

        Publisher publisher = new Publisher();
        publisher.setPublisherName(dto.getPublisherName());
        book.setPublisher(publisher);

        return book;


    }*/
}
