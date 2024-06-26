package com.myresume.librarymanagementsystem.dto;

import com.myresume.librarymanagementsystem.entity.Member;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemberConverter {

    public MemberDTO toDto(Member member) {
        MemberDTO dto = new MemberDTO();
        dto.setMemberName(member.getMemberName());
        dto.setMemberLastName(member.getMemberLastName());
        dto.setMemberNationalCode(member.getMemberNationalCode());
        dto.setMemberEmail(member.getMemberEmail());

        return dto;
    }

    public List<MemberDTO> MemberDTOList (List<Member> memberList){
        return memberList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Member toEntity(MemberDTO dto) {
        Member member = new Member();
        member.setMemberName(dto.getMemberName());
        member.setMemberLastName(dto.getMemberLastName());
        member.setMemberNationalCode(dto.getMemberNationalCode());
        member.setMemberEmail(dto.getMemberEmail());

        return member;
    }

}
