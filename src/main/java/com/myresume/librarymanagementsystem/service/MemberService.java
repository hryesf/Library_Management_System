package com.myresume.librarymanagementsystem.service;

import com.myresume.librarymanagementsystem.exception.NotFoundException;
import com.myresume.librarymanagementsystem.entity.Member;
import com.myresume.librarymanagementsystem.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberConverter memberConverter;

    public MemberService(MemberRepository memberRepository, MemberConverter memberConverter) {
        this.memberRepository = memberRepository;
        this.memberConverter = memberConverter;
    }

    public MemberDTO saveMember(Member member) {
        memberRepository.save(member);
        return memberConverter.toDto(member);
    }

    public List<MemberDTO> getAllMembers(){
        return memberConverter.MemberDTOList(memberRepository.findAll());
    }

    public MemberDTO getMember(Long id) {
        return memberConverter.toDto(memberRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Member with id " + id + " not Found")));
    }

    public Member getMemberByNationalCode(String nationalCode) {
        return memberRepository.findByNationalCode(nationalCode)
                .orElseThrow(() -> new NotFoundException("Member with National Code " + nationalCode + " not Found"));
    }

    public String deleteMemberById(Long id){
        memberRepository.deleteById(id);
        return "Member with code " + id + " removed from membership";
    }

    public String deleteMemberByNationalCode(String nationalCode){
        memberRepository.deleteByNationalCode(nationalCode);
        return "Member with National Code " + nationalCode + " removed from membership";
    }

    public void registrationNewMember(Member member){
        
        String nationalCode = member.getMemberNationalCode();
        Optional<Member> memberOptional = memberRepository.findByNationalCode(nationalCode);
        if (memberOptional.isPresent()){
            if (memberOptional.get().getMemberLastName().equals(member.getMemberLastName())){
                return;
            }
            throw new IllegalStateException("National Code [" + nationalCode + "] is taken");
        }
        memberRepository.save(member);
    }


}
