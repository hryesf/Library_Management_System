package com.myresume.librarymanagementsystem.member.controller;

import com.myresume.librarymanagementsystem.member.entity.Member;
import com.myresume.librarymanagementsystem.member.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/members")
public class MemberController {

    final MemberService memberService;
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping(path = "/{member_id}")
    Member getMember(@PathVariable("member_id") Long id) {
        return memberService.getMember(id);
    }

    @GetMapping(path = "/findByNationalCode")
    Member getMemberByNationalCode(@RequestParam String member_nationalCode) {
        return memberService.getMemberByNationalCode(member_nationalCode);
    }

    @PostMapping
    String saveMember(@Valid @RequestBody Member newMember) {
//        memberService.saveMember(newMember);
        memberService.registrationNewMember(newMember);
        String employee_nationalCode = newMember.getEmployee().getEmployeeNationalCode();
        Long library_code = newMember.getEmployee().getEmployeeLibraryId().getLibraryId();
        return "the member with national code = " + newMember.getMemberNationalCode()
                + " by employee with national code = " + employee_nationalCode
                + " joined in library with code = " + library_code;
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
        Member member = memberService.getMember(member_id);
        member.setMemberIsActive(member_isActive);
        memberService.saveMember(member);
        return member;
    }

    @PutMapping(path = "/update/{member_id}")
    Member updateMemberById(@PathVariable("member_id") Long member_id, @RequestBody Member updatedMember) {
        Member member = memberService.getMember(member_id);
        member.setMemberEmail(updatedMember.getMemberEmail());
        member.setMemberMobile(updatedMember.getMemberMobile());
        memberService.saveMember(member);
        return member;
    }


}
