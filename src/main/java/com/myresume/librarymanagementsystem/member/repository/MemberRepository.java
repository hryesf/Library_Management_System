package com.myresume.librarymanagementsystem.member.repository;

import com.myresume.librarymanagementsystem.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
}
