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

    public BorrowedBook borrowBook(Integer memberId, Integer bookId) {

        Book book = bookRepository.findById(bookId).orElseThrow();
        Member member = memberRepository.findById(memberId).orElseThrow();

        BorrowedBook borrowedBook = new BorrowedBook(
                new BorrowedBookId(memberId, bookId), member, book, LocalDate.now()
        );

        return borrowedBookRepository.save(borrowedBook);
    }


    public void returnBook(BorrowedBookId borrowedBookId) {
        BorrowedBook borrowedBook = borrowedBookRepository.findById(borrowedBookId).orElseThrow();

        borrowedBook.getMember().getBorrowedBooks().remove(borrowedBook);
        borrowedBook.getBook().getBorrowedBooks().remove(borrowedBook);

        borrowedBookRepository.delete(borrowedBook);
    }
}
