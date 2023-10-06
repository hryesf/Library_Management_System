package com.myresume.librarymanagementsystem.member.repository;

import com.myresume.librarymanagementsystem.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    @Query("SELECT m FROM Member m WHERE m.mem_nationalCode = :nationalCode")
    Optional<Member> findByNationalCode(@Param("nationalCode") String nationalCode);
}
