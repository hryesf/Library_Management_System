package com.myresume.librarymanagementsystem.jointables.borrowedbook.entity;

import com.myresume.librarymanagementsystem.entity.Book;
import com.myresume.librarymanagementsystem.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "BorrowedBook")
@Table(name = "borrowed_book")
public class BorrowedBook {

    @EmbeddedId
    private BorrowedBookId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("memberId")
    @JoinColumn(name = "member_id",
            foreignKey = @ForeignKey( name = "borrowed_book_member_id_fk"))
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("bookId")
    @JoinColumn(name = "book_id",
            foreignKey = @ForeignKey( name = "borrowed_book_book_id_fk"))
    private Book book;

    private LocalDate borrowDate;

    @Override
    public String toString() {
        return "BorrowedBook{" +
                "id=" + id +
                ", member=" + member.getMemberName() +
                ", book=" + book.getBookTitle() +
                ", borrowDate=" + borrowDate +
                '}';
    }
}
