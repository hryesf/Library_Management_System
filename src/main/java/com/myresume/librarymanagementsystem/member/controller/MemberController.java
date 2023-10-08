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

    @GetMapping(path = "/{mem_id}")
    Member getMember(@PathVariable("mem_id") int id) {
        return memberService.getMember(id);
    }

    @GetMapping(path = "/findByNationalCode")
    Member getMemberByNationalCode(@RequestParam String mem_nationalCode) {
        return memberService.getMemberByNationalCode(mem_nationalCode);
    }

    @PostMapping
    String saveMember(@Valid @RequestBody Member newMember) {
        memberService.saveMember(newMember);
        String employee_nationalCode = newMember.getEmployee().getEmp_nationalCode();
        int library_code = newMember.getEmployee().getEmp_library_id().getLibrary_id();
        return "the member with national code = " + newMember.getMem_nationalCode()
                + " by employee with national code = " + employee_nationalCode
                + " joined in library with code = " + library_code;
    }

    @DeleteMapping(path = "/{mem_id}")
    String deleteMemberById(@PathVariable("mem_id") int mem_id) {
        return memberService.deleteMemberById(mem_id);
    }

    @DeleteMapping(path = "/deleteByNationalCode")
    String deleteMemberById(@RequestParam String mem_nationalCode) {
        return memberService.deleteMemberByNationalCode(mem_nationalCode);
    }

    @PutMapping(path = "/update/activeMode/{mem_id}")
    Member updateActiveFlagById(@PathVariable("mem_id") int mem_id, @RequestParam int mem_isActive) {
        Member member = memberService.getMember(mem_id);
        member.setMem_isActive(mem_isActive);
        memberService.saveMember(member);
        return member;
    }

    @PutMapping(path = "/update/{mem_id}")
    Member updateMemberById(@PathVariable("mem_id") int mem_id, @RequestBody Member updatedMember) {
        Member member = memberService.getMember(mem_id);
        member.setMem_email(updatedMember.getMem_email());
        member.setMem_mobile(updatedMember.getMem_mobile());
        memberService.saveMember(member);
        return member;
    }


}
