package com.myresume.librarymanagementsystem.jointables.membership.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MembershipId implements Serializable {

    private Long memberId;
    private Long libraryId;
}
