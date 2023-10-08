package com.myresume.librarymanagementsystem.jointables.memberlibrary;

import com.myresume.librarymanagementsystem.library.entity.Library;
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
public class MemberLibrary {

    @EmbeddedId
    private MemberLibraryId id;

    @ManyToOne
    @MapsId("memberId")
    @JoinColumn(name = "memlib_member_id",
            foreignKey = @ForeignKey( name = "member_library_member_id_fk"))
    private Member member;

    @ManyToOne
    @MapsId("libraryId")
    @JoinColumn(name = "memlib_library_id",
            foreignKey = @ForeignKey( name = "member_library_library_id_fk"))
    private Library library;

    private Date memlib_signUpDate;
}
