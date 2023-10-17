package com.myresume.librarymanagementsystem.library.entity;

import com.myresume.librarymanagementsystem.jointables.donatedbook.entity.DonatedBook;
import com.myresume.librarymanagementsystem.jointables.membership.entity.Membership;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Library")
@Table
public class Library {

    @Id
    @SequenceGenerator(name = "library_id_seq", sequenceName = "library_id_seq", allocationSize = 1, initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "library_id_seq")
    private Integer library_id ;

    @NaturalId
    @NotBlank(message = "Library Name must be not empty!")
    private String library_name;

    @NotBlank(message = "Library Address must be not empty!")
    private String library_address;

    @NotBlank(message = "Region of library  must be not empty!")
    private String library_region;

    @NotBlank(message = "Phone Number must be not empty!")
    @Digits(integer = 12, fraction = 0, message = "Please Enter a valid telephone number")
    private String library_tel;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Membership> membershipList = new HashSet<>();

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DonatedBook> donatedBookList = new HashSet<>();
}
