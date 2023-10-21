package com.myresume.librarymanagementsystem.jointables.borrowedbook.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.myresume.librarymanagementsystem.book.entity.Book;
import com.myresume.librarymanagementsystem.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class BorrowedBook {

    @EmbeddedId
    private BorrowedBookId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("memberId")
    @JoinColumn(name = "borrowedBook_member_id",
            foreignKey = @ForeignKey( name = "borrowedBook_member_id_fk"))
    @JsonIgnoreProperties("borrowedBooks")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("bookId")
    @JoinColumn(name = "borrowedBook_book_id",
            foreignKey = @ForeignKey( name = "borrowedBook_book_id_fk"))
    @JsonIgnoreProperties("borrowedBooks")
    private Book book;

    private LocalDate borrowedBook_borrowDate;

    public BorrowedBook(Member member, Book book, LocalDate borrowedBook_borrowDate) {
        this.id = new BorrowedBookId(member.getMem_id(), book.getBook_id());
        this.member = member;
        this.book = book;
        this.borrowedBook_borrowDate = borrowedBook_borrowDate;
    }

    @Override
    public String toString() {
        return "BorrowedBook{" +
                "id=" + id +
                ", member=" + member.getMem_name() +
                ", book=" + book.getBook_title() +
                ", borrowedBook_borrowDate=" + borrowedBook_borrowDate +
                '}';
    }
}
