package com.myresume.librarymanagementsystem.repository;

import com.myresume.librarymanagementsystem.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("SELECT m FROM Member m WHERE m.memberNationalCode = :nationalCode")
    Optional<Member> findByNationalCode(@Param("nationalCode") String nationalCode);

    @Transactional
    @Modifying
    @Query("DELETE FROM Member m WHERE m.memberNationalCode = :nationalCode")
    void deleteByNationalCode(@Param("nationalCode") String nationalCode);
}
