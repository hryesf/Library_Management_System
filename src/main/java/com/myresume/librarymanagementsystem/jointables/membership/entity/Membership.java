package com.myresume.librarymanagementsystem.jointables.membership.entity;

import com.myresume.librarymanagementsystem.library.entity.Library;
import com.myresume.librarymanagementsystem.member.entity.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Membership")
@Table(name = "membership")
public class Membership {

    @EmbeddedId
    private MembershipId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("memberId")
    @JoinColumn(name = "member_id",
            foreignKey = @ForeignKey( name = "membership_member_id_fk"))
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("libraryId")
    @JoinColumn(name = "library_id",
            foreignKey = @ForeignKey( name = "membership_library_id_fk"))
    private Library library;

    private LocalDate signUpDate;

    @Override
    public String toString() {
        return "Membership{" +
                "id=" + id +
                ", member=" + member.getMemberName() +
                ", library=" + library.getLibraryName() +
                ", signUpDate=" + signUpDate +
                '}';
    }
}
