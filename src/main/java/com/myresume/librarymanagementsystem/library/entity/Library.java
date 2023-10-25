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
@Table(name = "library")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "library_id")
    private Long libraryId ;

    @NaturalId
    @NotBlank(message = "Library Name must be not empty!")
    @Column(name = "library_name",
            columnDefinition = "varchar(20)")
    private String libraryName;

    @NotBlank(message = "Library Address must be not empty!")
    @Column(name = "library_address",
            columnDefinition = "varchar(200)")
    private String libraryAddress;

    @NotBlank(message = "Region of library  must be not empty!")
    @Column(name = "library_region",
            columnDefinition = "varchar(20)")
    private String libraryRegion;

    @NotBlank(message = "Phone Number must be not empty!")
    @Digits(integer = 12,
            fraction = 0,
            message = "Please Enter a valid telephone number")
    @Column(name = "library_tel",
            columnDefinition = "varchar(20)")
    private String libraryTel;

    @OneToMany(mappedBy = "library",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("library")
    private Set<Membership> membershipList = new HashSet<>();

    @OneToMany(mappedBy = "library",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("library")
    private Set<DonatedBook> donatedBookList = new HashSet<>();

    @Override
    public String toString() {
        return "Library{" +
                "Id=" + libraryId +
                ", Name='" + libraryName + '\'' +
                ", Address='" + libraryAddress + '\'' +
                ", Region='" + libraryRegion + '\'' +
                ", Tel='" + libraryTel + '\'' +
                ", membershipList=" + membershipList.toString() +
                ", donatedBookList=" + donatedBookList.toString() +
                '}';
    }
}
