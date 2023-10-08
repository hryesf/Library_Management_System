package com.myresume.librarymanagementsystem.member.entity;

import com.myresume.librarymanagementsystem.employee.entity.Employee;
import com.myresume.librarymanagementsystem.gender.entity.Gender;
import com.myresume.librarymanagementsystem.jointables.memberbook.MemberBook;
import com.myresume.librarymanagementsystem.jointables.memberlibrary.MemberLibrary;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

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
    @Column(columnDefinition = "varchar(50) default 'unknown'")
    private String mem_lastName;

    @NotBlank(message = "National Code must be not empty!")
    @Digits(integer = 10, fraction = 0, message = "Member National Code must be a number with at most 10 digits")
    @Column(columnDefinition = "varchar(20)", unique = true)
    private String mem_nationalCode;

    @ManyToOne
    @JoinColumn(name = "mem_gender_id", referencedColumnName = "gender_id")
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
    @JoinColumn(name = "mem_registrar_id", referencedColumnName = "emp_id")
    private Employee employee;


    @OneToMany(mappedBy = "member")
    private List<MemberLibrary> memberLibraryList;

    @OneToMany(mappedBy = "member")
    private List<MemberBook> memberBookList;

    /*private String MEM_TEL;
    private String MEM_ADDRESS;
    private Date MEM_REGISTERED_DATE;
    private String MEM_DESCRIPTION;
    private Integer MEM_STATUS_ID;
    private Integer MEM_EDUCATION_LEVEL_ID;*/
}
