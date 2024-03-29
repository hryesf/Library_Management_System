package com.myresume.librarymanagementsystem.jointables.membership.service;

import com.myresume.librarymanagementsystem.jointables.membership.entity.Membership;
import com.myresume.librarymanagementsystem.jointables.membership.entity.MembershipId;
import com.myresume.librarymanagementsystem.jointables.membership.repository.MembershipRepository;
import com.myresume.librarymanagementsystem.entity.Library;
import com.myresume.librarymanagementsystem.repository.LibraryRepository;
import com.myresume.librarymanagementsystem.entity.Member;
import com.myresume.librarymanagementsystem.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MembershipService {

    private final MembershipRepository membershipRepository;
    private final LibraryRepository libraryRepository;
    private final MemberRepository memberRepository;

    public MembershipService(MembershipRepository membershipRepository, LibraryRepository libraryRepository, MemberRepository memberRepository) {
        this.membershipRepository = membershipRepository;
        this.libraryRepository = libraryRepository;
        this.memberRepository = memberRepository;
    }

    public List<Membership> getAllMemberships() {
        return membershipRepository.findAll();
    }

    public Membership startMembership(Long memberId, Long libraryId) {

        Library library = libraryRepository.findById(libraryId).orElseThrow();
        Member member = memberRepository.findById(memberId).orElseThrow();

        Membership membership = new Membership(
                new MembershipId(memberId, libraryId), member, library, LocalDate.now());

        return membershipRepository.save(membership);
    }

    public void endMembership(MembershipId membershipId) {
        Membership membership = membershipRepository.findById(membershipId).orElseThrow();

        membership.getMember().getMembershipList().remove(membership);
        membership.getLibrary().getMembershipList().remove(membership);

        membershipRepository.delete(membership);
    }

}
