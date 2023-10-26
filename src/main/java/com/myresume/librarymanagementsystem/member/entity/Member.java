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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Member")
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @NotBlank(message = "Name must be not empty!")
    @Column(name = "member_name",
            columnDefinition = "varchar(20) default 'unknown'")
    private String memberName;

    @NotBlank(message = "Last name must be not empty!")
    @Column(name = "member_last_name",
            columnDefinition = "varchar(50) default 'unknown'",
            nullable = false)
    private String memberLastName;

    @NaturalId
    @NotBlank(message = "National Code must be not empty!")
    @Digits(integer = 10,
            fraction = 0,
            message = "Member National Code must be a number with at most 10 digits")
    @Column(name = "member_national_code",
            columnDefinition = "varchar(10)",
            unique = true,
            nullable = false)
    private String memberNationalCode;

    @ManyToOne
    @JoinColumn(name = "member_gender_id",
            referencedColumnName = "gender_id",
            foreignKey = @ForeignKey( name = "member_gender_id_fk"))
    private Gender memberGenderId;

    @Past(message = "the input date for Birth Date is not valid! it should belong to past!")
    @Column(name = "member_bod")
    private Date memberBOD;

    @Email(message = "the input Email is not valid!")
    @Column(name = "member_email",
            columnDefinition = "varchar(50)",
            unique = true)
    private String memberEmail;

    @Digits(integer = 12,
            fraction = 0,
            message = "The phone nu,ber is not correct!")
    @Column(name = "member_mobile",
            columnDefinition = "varchar(20)")
    private String memberMobile;

    @Digits(integer = 1,
            fraction = 0,
            message = "Please just enter one number 1/0")
    @Column(name = "member_is_active",
            columnDefinition = "varchar(20)")
    private Integer memberIsActive;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "member_registrar_id",
            referencedColumnName = "employee_id",
            foreignKey = @ForeignKey( name = "member_employee_id_fk"))
    private Employee employee;

    @OneToMany(mappedBy = "member",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<BorrowedBook> borrowedBookList = new HashSet<>();

    @OneToMany(mappedBy = "member",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Membership> membershipList = new HashSet<>();

    public Member(String memberName,
                  String memberLastName,
                  String memberNationalCode,
                  Gender memberGenderId,
                  String memberEmail,
                  Integer memberIsActive) {
        this.memberName = memberName;
        this.memberLastName = memberLastName;
        this.memberNationalCode = memberNationalCode;
        this.memberGenderId = memberGenderId;
        this.memberEmail = memberEmail;
        this.memberIsActive = memberIsActive;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", memberLastName='" + memberLastName + '\'' +
                ", memberNationalCode='" + memberNationalCode + '\'' +
                ", memberGender=" + memberGenderId.getGenderName() +
                ", memberBOD=" + memberBOD +
                ", memberEmail='" + memberEmail + '\'' +
                ", memberMobile='" + memberMobile + '\'' +
                ", memberIsActive=" + memberIsActive +
                ", employee=" + employee.getEmployeeName() +
                ", borrowedBookList=" + borrowedBookList.toString() +
                ", membershipList=" + membershipList.toString() +
                '}';
    }

    /*private String memberTel;
    private String memberAddress;
    private Date memberRegisteredDate;
    private String memberDescription;
    private Integer memberStatusId;
    private Integer memberEducationLevelId;*/
}
