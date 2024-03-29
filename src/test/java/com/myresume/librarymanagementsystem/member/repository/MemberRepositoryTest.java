package com.myresume.librarymanagementsystem.member.repository;

import com.myresume.librarymanagementsystem.entity.Gender;
import com.myresume.librarymanagementsystem.entity.Member;
import com.myresume.librarymanagementsystem.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest(properties = {"spring.jpa.properties.javax.persistence.validation.mode=none"})
class MemberRepositoryTest {

    @Autowired
    private MemberRepository underTest;

    @Test
    void itShouldSelectMemberByNationalCode() {
        // Given
        Member member = new Member("Ali",
                "Naji",
                "0062498125",
                new Gender("male"),
                "ali.naji@gmail.com",
                1);

        // When
        underTest.save(member);

        // Then
        Optional<Member> optionalMember = underTest.findByNationalCode("0062498125");
        assertThat(optionalMember)
                .isPresent()
                .hasValueSatisfying(c -> {
                    /*assertThat(c.getMem_name()).isEqualTo("Ali");
                    assertThat(c.getMem_lastName()).isEqualTo("Naji");
                    assertThat(c.getMem_nationalCode()).isEqualTo("0062498125");
                    assertThat(c.getMem_email()).isEqualTo("ali.naji@gmail.com");
                    assertThat(c.getMem_gender_id().getGender_name()).isEqualTo("male");
                    assertThat(c.getMem_isActive()).isEqualTo(1);*/
                    assertThat(c).isEqualTo(member);
                });
    }

    @Test
    void itNotShouldSelectMemberByNationalCodeWhenNationalCodeDoesNotExists() {
        // Given
        String nationalCode = "0062498125";

        // When
        Optional<Member> optionalMember = underTest.findByNationalCode(nationalCode);

        // Then
        assertThat(optionalMember).isNotPresent();
    }

     // for these tests named like "itShouldNotSaveMemberWhen...IsNull"
     // you should put the column in entity class nullable in @column annotation
    @Test
    void itShouldNotSaveMemberWhenLastNameIsNull() {
        // Given
        String nationalCode = "0062498125";
        Member member = new Member("Ali",
                null,
                nationalCode,
                new Gender("male"),
                "ali.naji@gmail.com",
                1);

        // When
        // Then
        assertThatThrownBy(() -> underTest.save(member))
                .hasMessageContaining(
                        "not-null property references a null or transient value : com.myresume.librarymanagementsystem.entity.Member.mem_lastName")
                .isInstanceOf(DataIntegrityViolationException.class);
    }

    @Test
    void itShouldNotSaveMemberWhenNationalCodeIsNull() {

        // Given
        Member member = new Member("Ali",
                "Naji",
                null,
                new Gender("male"),
                "ali.naji@gmail.com",
                1);

        // When
        // Then

        // for finding the correct exception
        // assertThat(underTest.save(member));
        assertThatThrownBy(() -> underTest.save(member))
                .hasMessageContaining(
                        "not-null property references a null or transient value : com.myresume.librarymanagementsystem.entity.Member.mem_nationalCode")
                .isInstanceOf(DataIntegrityViolationException.class);
    }
}