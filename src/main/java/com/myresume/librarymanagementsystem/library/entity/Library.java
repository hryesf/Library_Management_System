package com.myresume.librarymanagementsystem.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.myresume.librarymanagementsystem.jointables.donatedbook.entity.DonatedBook;
import com.myresume.librarymanagementsystem.jointables.membership.entity.Membership;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Library")
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JsonIgnoreProperties("library")
    private Set<Membership> membershipList = new HashSet<>();

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("library")
    private Set<DonatedBook> donatedBooks = new HashSet<>();

    @Override
    public String toString() {
        return "Library{" +
                "library_id=" + library_id +
                ", library_name='" + library_name + '\'' +
                ", library_address='" + library_address + '\'' +
                ", library_region='" + library_region + '\'' +
                ", library_tel='" + library_tel + '\'' +
                ", membershipList=" + membershipList.toString() +
                ", donatedBooks=" + donatedBooks.toString() +
                '}';
    }
}
