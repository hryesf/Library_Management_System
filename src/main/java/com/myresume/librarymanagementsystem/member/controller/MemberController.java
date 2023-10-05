package com.myresume.librarymanagementsystem.member.controller;

import com.myresume.librarymanagementsystem.member.model.Member;
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
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping(path = "/{mem_id}")
    public Member getMember(@PathVariable("mem_id") int id) {
        return memberService.getMember(id);
    }

    @PostMapping
    public String saveMember(@Valid @RequestBody Member newMember){
        System.out.println("Post Request ran ...");
        return memberService.saveMember(newMember).toString() + "\nSaved in database";
    }

    @DeleteMapping(path = "/{mem_id}")
    public String deleteMemberById(@PathVariable("mem_id") int mem_id){
        return memberService.deleteMemberById(mem_id);
    }

}
