package com.myresume.librarymanagementsystem.jointables.memberbook;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MemberBookId implements Serializable {

    @Column(name = "membook_member_id")
    private Integer memberId;

    @Column(name = "membook_book_id")
    private Integer bookId;
}
