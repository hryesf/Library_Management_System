package com.myresume.librarymanagementsystem.jointables.membership.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Entity
@Table
public class Membership {

    @EmbeddedId
    private MembershipId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("memberId")
    @JoinColumn(name = "memlib_member_id",
            foreignKey = @ForeignKey( name = "member_library_member_id_fk"))
    @JsonIgnoreProperties("membershipList")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("libraryId")
    @JoinColumn(name = "memlib_library_id",
            foreignKey = @ForeignKey( name = "member_library_library_id_fk"))
    @JsonIgnoreProperties("membershipList")
    private Library library;

    private LocalDate memlib_signUpDate;

    public Membership(Member member, Library library, LocalDate memlib_signUpDate) {
        this.id = new MembershipId(member.getMem_id(), library.getLibrary_id());
        this.member = member;
        this.library = library;
        this.memlib_signUpDate = memlib_signUpDate;
    }

    @Override
    public String toString() {
        return "Membership{" +
                "id=" + id +
                ", member=" + member.getMem_name() +
                ", library=" + library.getLibrary_name() +
                ", memlib_signUpDate=" + memlib_signUpDate +
                '}';
    }
}
