package com.myresume.librarymanagementsystem.jointables.borrowedbook.service;

import com.myresume.librarymanagementsystem.entity.Book;
import com.myresume.librarymanagementsystem.repository.BookRepository;
import com.myresume.librarymanagementsystem.jointables.borrowedbook.entity.BorrowedBook;
import com.myresume.librarymanagementsystem.jointables.borrowedbook.entity.BorrowedBookId;
import com.myresume.librarymanagementsystem.jointables.borrowedbook.repository.BorrowedBookRepository;
import com.myresume.librarymanagementsystem.entity.Member;
import com.myresume.librarymanagementsystem.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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

    public BorrowedBook borrowBook(Long memberId, Long bookId) {

        Book book = bookRepository.findById(bookId).orElseThrow();
        Member member = memberRepository.findById(memberId).orElseThrow();

        BorrowedBook borrowedBook = new BorrowedBook(
                new BorrowedBookId(memberId, bookId), member, book, LocalDate.now()
        );

        return borrowedBookRepository.save(borrowedBook);
    }


    public void returnBook(BorrowedBookId borrowedBookId) {
        BorrowedBook borrowedBook = borrowedBookRepository.findById(borrowedBookId).orElseThrow();

        borrowedBook.getMember().getBorrowedBookList().remove(borrowedBook);
        borrowedBook.getBook().getBorrowedBookList().remove(borrowedBook);

        borrowedBookRepository.delete(borrowedBook);
    }
}
