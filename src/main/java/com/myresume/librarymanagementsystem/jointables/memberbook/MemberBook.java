package com.myresume.librarymanagementsystem.jointables.memberbook;

import com.myresume.librarymanagementsystem.book.entity.Book;
import com.myresume.librarymanagementsystem.member.entity.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class MemberBook {

    @EmbeddedId
    private MemberBookId id;

    @ManyToOne
    @MapsId("memberId")
    @JoinColumn(name = "membook_member_id")
    private Member member;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "membook_book_id")
    private Book book;

    private Date membook_borrowDate;
}
