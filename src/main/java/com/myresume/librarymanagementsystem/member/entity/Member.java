package com.myresume.librarymanagementsystem.member.entity;

import com.myresume.librarymanagementsystem.employee.entity.Employee;
import com.myresume.librarymanagementsystem.gender.entity.Gender;
import com.myresume.librarymanagementsystem.jointables.borrowedbook.entity.BorrowedBook;
import com.myresume.librarymanagementsystem.jointables.membership.entity.Membership;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Member")
@Table
public class Member {

    @Id
    @SequenceGenerator(name = "member_id_sequence", sequenceName = "member_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_id_sequence")
    private Integer mem_id;

    @NotBlank(message = "Name must be not empty!")
    @Column(columnDefinition = "varchar(20) default 'unknown'")
    private String mem_name;

    @NotBlank(message = "Last name must be not empty!")
    @Column(columnDefinition = "varchar(50) default 'unknown'", nullable = false)
    private String mem_lastName;

    @NaturalId
    @NotBlank(message = "National Code must be not empty!")
    @Digits(integer = 10, fraction = 0, message = "Member National Code must be a number with at most 10 digits")
    @Column(columnDefinition = "varchar(20)", unique = true, nullable = false)
    private String mem_nationalCode;

    @ManyToOne
    @JoinColumn(name = "mem_gender_id", referencedColumnName = "gender_id",
            foreignKey = @ForeignKey( name = "member_gender_id_fk"))
    private Gender mem_gender_id;

    @Past(message = "the input date for Birth Date is not valid! it should belong to past!")
    private Date mem_bod;

    @Email(message = "the input Email is not valid!")
    @Column(columnDefinition = "varchar(50)", unique = true)
    private String mem_email;

    @Digits(integer = 12, fraction = 0, message = "The phone nu,ber is not correct!")
    private String mem_mobile;

    @Digits(integer = 1, fraction = 0, message = "Please just enter one number 1/0")
    private Integer mem_isActive;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "mem_registrar_id", referencedColumnName = "emp_id",
            foreignKey = @ForeignKey( name = "member_employee_id_fk"))
    private Employee employee;


    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Membership> membershipList = new HashSet<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BorrowedBook> borrowedBookList = new HashSet<>();

    public Member(String mem_name, String mem_lastName, String mem_nationalCode, Gender mem_gender_id, String mem_email, Integer mem_isActive) {
        this.mem_name = mem_name;
        this.mem_lastName = mem_lastName;
        this.mem_nationalCode = mem_nationalCode;
        this.mem_gender_id = mem_gender_id;
        this.mem_email = mem_email;
        this.mem_isActive = mem_isActive;
    }

    @Override
    public String toString() {
        return "Member{" +
                "mem_id=" + mem_id +
                ", mem_name='" + mem_name + '\'' +
                ", mem_lastName='" + mem_lastName + '\'' +
                ", mem_nationalCode='" + mem_nationalCode + '\'' +
                ", mem_gender_id=" + mem_gender_id +
                ", mem_bod=" + mem_bod +
                ", mem_email='" + mem_email + '\'' +
                ", mem_mobile='" + mem_mobile + '\'' +
                ", mem_isActive=" + mem_isActive +
                ", employee=" + employee +
                ", membershipList=" + membershipList +
                //", borrowedBookList=" + borrowedBookList +
                ", borrowedBookList=" + (borrowedBookList != null ? borrowedBookList.size() : 0) +
                '}';
    }

    /*private String MEM_TEL;
    private String MEM_ADDRESS;
    private Date MEM_REGISTERED_DATE;
    private String MEM_DESCRIPTION;
    private Integer MEM_STATUS_ID;
    private Integer MEM_EDUCATION_LEVEL_ID;*/
}
