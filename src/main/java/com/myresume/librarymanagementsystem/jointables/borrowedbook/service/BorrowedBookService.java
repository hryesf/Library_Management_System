package com.myresume.librarymanagementsystem.jointables.borrowedbook.service;

import com.myresume.librarymanagementsystem.book.entity.Book;
import com.myresume.librarymanagementsystem.book.repository.BookRepository;
import com.myresume.librarymanagementsystem.jointables.borrowedbook.entity.BorrowedBook;
import com.myresume.librarymanagementsystem.jointables.borrowedbook.entity.BorrowedBookId;
import com.myresume.librarymanagementsystem.jointables.borrowedbook.repository.BorrowedBookRepository;
import com.myresume.librarymanagementsystem.member.entity.Member;
import com.myresume.librarymanagementsystem.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowedBookService {
    private final BorrowedBookRepository borrowedBookRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    public BorrowedBookService(BorrowedBookRepository borrowedBookRepository, BookRepository bookRepository, MemberRepository memberRepository) {
        this.borrowedBookRepository = borrowedBookRepository;
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }

    public List<BorrowedBook> getAllBorrowedBooks() {
        return borrowedBookRepository.findAll();
    }

    public BorrowedBook borrowBook(BorrowedBookId borrowedBookId) {

        Integer bookId = borrowedBookId.getBookId();
        Integer memberId = borrowedBookId.getMemberId();
        Book book = bookRepository.findById(bookId).orElseThrow();
        Member member = memberRepository.findById(memberId).orElseThrow();

        // Check if the borrowed book already exists
        Optional<BorrowedBook> existingBorrowedBook = borrowedBookRepository.findById(borrowedBookId);

        if (existingBorrowedBook.isPresent()) {
            throw new IllegalStateException("The book \"" + book + "\" is already taken by \"" + member + "\"");
        } else {
            // Create a new borrowed book
            BorrowedBook borrowedBook = new BorrowedBook(member, book, LocalDate.now());
            member.getBorrowedBookList().add(borrowedBook);
            book.getBorrowedBookList().add(borrowedBook); // stackoverflow error !

            return borrowedBookRepository.save(borrowedBook);
        }
    }

    public void returnBook(BorrowedBookId borrowedBookId) {
        BorrowedBook borrowedBook = borrowedBookRepository.findById(borrowedBookId).orElseThrow();

        borrowedBook.getMember().getBorrowedBookList().remove(borrowedBook);
        borrowedBook.getBook().getBorrowedBookList().remove(borrowedBook);

        borrowedBookRepository.delete(borrowedBook);
    }
}
