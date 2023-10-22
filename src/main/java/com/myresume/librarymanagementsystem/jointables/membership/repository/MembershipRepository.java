package com.myresume.librarymanagementsystem.jointables.membership.repository;

import com.myresume.librarymanagementsystem.jointables.membership.entity.Membership;
import com.myresume.librarymanagementsystem.jointables.membership.entity.MembershipId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<Membership, MembershipId> {
}
