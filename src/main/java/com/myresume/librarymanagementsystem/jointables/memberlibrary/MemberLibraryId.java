package com.myresume.librarymanagementsystem.jointables.memberlibrary;

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
public class MemberLibraryId implements Serializable {

    @Column(name = "memlib_member_id")
    private Integer memberId;

    @Column(name = "memlib_library_id")
    private Integer libraryId;
}
