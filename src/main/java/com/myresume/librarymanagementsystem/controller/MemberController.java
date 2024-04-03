package com.myresume.librarymanagementsystem.controller;

import com.myresume.librarymanagementsystem.entity.Member;
import com.myresume.librarymanagementsystem.dto.MemberConverter;
import com.myresume.librarymanagementsystem.dto.MemberDTO;
import com.myresume.librarymanagementsystem.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/members")
public class MemberController {

    private final MemberService memberService;
    private final MemberConverter memberConverter;

    public MemberController(MemberService memberService, MemberConverter memberConverter) {
        this.memberService = memberService;
        this.memberConverter = memberConverter;
    }

    @GetMapping
    List<MemberDTO> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping(path = "/{member_id}")
    String getMember(@PathVariable("member_id") Long id) {
        return memberService.getMember(id).toString();
    }

    @GetMapping(path = "/findByNationalCode")
    Member getMemberByNationalCode(@RequestParam String member_nationalCode) {
        return memberService.getMemberByNationalCode(member_nationalCode);
    }

    @PostMapping
    MemberDTO saveMember(@Valid @RequestBody Member newMember) {
        return memberService.saveMember(newMember);
/*        memberService.registrationNewMember(newMember);
        String employee_nationalCode = newMember.getEmployee().getEmployeeNationalCode();
        Long library_code = newMember.getEmployee().getEmployeeLibraryId().getLibraryId();
        return "the member with national code = " + newMember.getMemberNationalCode()
                + " by employee with national code = " + employee_nationalCode
                + " joined in library with code = " + library_code;*/
    }

    @DeleteMapping(path = "/{member_id}")
    String deleteMemberById(@PathVariable("member_id") Long member_id) {
        return memberService.deleteMemberById(member_id);
    }

    @DeleteMapping(path = "/deleteByNationalCode")
    String deleteMemberById(@RequestParam String member_nationalCode) {
        return memberService.deleteMemberByNationalCode(member_nationalCode);
    }

    @PutMapping(path = "/update/activeMode/{member_id}")
    Member updateActiveFlagById(@PathVariable("member_id") Long member_id, @RequestParam int member_isActive) {
        MemberDTO memberDTO = memberService.getMember(member_id);
        Member member = memberConverter.toEntity(memberDTO);
        member.setMemberIsActive(member_isActive);
        memberService.saveMember(member);
        return member;
    }

    @PutMapping(path = "/update/{member_id}")
    Member updateMemberById(@PathVariable("member_id") Long member_id, @RequestBody Member updatedMember) {
        MemberDTO memberDTO = memberService.getMember(member_id);
        Member member = memberConverter.toEntity(memberDTO);
        member.setMemberEmail(updatedMember.getMemberEmail());
        member.setMemberMobile(updatedMember.getMemberMobile());
        memberService.saveMember(member);
        return member;
    }


}
