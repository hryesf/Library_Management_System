package com.myresume.librarymanagementsystem.member.service;

import com.myresume.librarymanagementsystem.exception.NotFoundException;
import com.myresume.librarymanagementsystem.member.entity.Member;
import com.myresume.librarymanagementsystem.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void saveMember(Member member) {
        memberRepository.save(member);
    }

    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    public Member getMember(int id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Member with id " + id + " not Found"));
    }

    public Member getMemberByNationalCode(String nationalCode) {
        return memberRepository.findByNationalCode(nationalCode)
                .orElseThrow(() -> new NotFoundException("Member with National Code " + nationalCode + " not Found"));
    }

    public String deleteMemberById(int id){
        memberRepository.deleteById(id);
        return "Member with code " + id + " removed from membership";
    }

    public String deleteMemberByNationalCode(String nationalCode){
        memberRepository.deleteByNationalCode(nationalCode);
        return "Member with National Code " + nationalCode + " removed from membership";
    }

}
