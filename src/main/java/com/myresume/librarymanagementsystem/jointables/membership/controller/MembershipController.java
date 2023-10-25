package com.myresume.librarymanagementsystem.jointables.membership.controller;

import com.myresume.librarymanagementsystem.jointables.membership.entity.Membership;
import com.myresume.librarymanagementsystem.jointables.membership.entity.MembershipId;
import com.myresume.librarymanagementsystem.jointables.membership.service.MembershipService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/memberships")
public class MembershipController {
    private final MembershipService membershipService;

    public MembershipController(MembershipService membershipService) {
        this.membershipService = membershipService;
    }


    @GetMapping
    public String getAllMemberships() {
        return membershipService.getAllMemberships().toString();
    }

    @PostMapping("/{member_id}/{library_id}")
    public String startMembership(@PathVariable Long member_id , @PathVariable Long library_id) {
        Membership membership = membershipService.startMembership(member_id, library_id);
        return membership.toString();
    }

    @DeleteMapping("/{id}")
    public void endMembership(@PathVariable MembershipId id) {
        membershipService.endMembership(id);
    }
}
