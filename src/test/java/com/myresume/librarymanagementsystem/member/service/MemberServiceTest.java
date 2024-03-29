package com.myresume.librarymanagementsystem.member.service;

import com.myresume.librarymanagementsystem.entity.Gender;
import com.myresume.librarymanagementsystem.entity.Member;
import com.myresume.librarymanagementsystem.repository.MemberRepository;
import com.myresume.librarymanagementsystem.service.MemberService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;

class MemberServiceTest {

    private final MemberRepository memberRepository = mock(MemberRepository.class);
    private MemberService underTest;

    @Captor
    private ArgumentCaptor<Member> memberArgumentCaptor;

    /*@BeforeEach
    void setUp() {
        underTest = new MemberService(memberRepository);
    }*/

    @Test
    void itShouldSaveNewMember() {
        // Given a national code
        String nationalCode = "0062490000";
        Member member = new Member("shima",
                "sadeghi",
                nationalCode,
                new Gender("female"),
                "shima.sadeghi@gmail.com",
                1);
        // When
        underTest.registrationNewMember(member);
        memberArgumentCaptor = ArgumentCaptor.forClass(Member.class);

        // ... No member with national code passed
        given(memberRepository.findByNationalCode(nationalCode)).willReturn(Optional.empty());

        // Then
        then(memberRepository).should().save(memberArgumentCaptor.capture());
        Member memberArgumentCaptorValue = memberArgumentCaptor.getValue();
        assertThat(memberArgumentCaptorValue).isEqualTo(member);
    }

    @Test
    void itShouldNotSaveNewMemberWhenCustomerExists() {
        // Given a national code
        String nationalCode = "0062490000";
        Member member = new Member("shima",
                "sadeghi",
                nationalCode,
                new Gender("female"),
                "shima.sadeghi@gmail.com",
                1);

        // ... An existing Member is returned
        given(memberRepository.findByNationalCode(nationalCode)).willReturn(Optional.of(member));

        // When
        underTest.registrationNewMember(member);

        // Then

        // - way 1
        then(memberRepository).should(never()).save(any());

        // - way 2
        /*then(memberRepository).should().findByNationalCode(nationalCode);
        then(memberRepository).shouldHaveNoInteractions();*/

    }

    @Test
    void itShouldThrownExceptionWhenNationalCodeIsTaken() {
        // Given a national code
        String nationalCode = "0062490000";

        Member member = new Member("shima",
                "sadeghi",
                nationalCode,
                new Gender("female"),
                "shima.sadeghi@gmail.com",
                1);

        Member member2 = new Member("sara",
                "pooya",
                nationalCode,
                new Gender("female"),
                "sara.pooya@gmail.com",
                1);

        given(memberRepository.findByNationalCode(nationalCode)).willReturn(Optional.of(member2));

        // When
        // Then
        assertThatThrownBy(() -> underTest.registrationNewMember(member))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("National Code [" + nationalCode + "] is taken");
        // Finally
        then(memberRepository).should(never()).save(any(Member.class));


    }
}