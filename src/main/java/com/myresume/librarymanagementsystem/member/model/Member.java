package com.myresume.librarymanagementsystem.member.model;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class Member {

    @Id
    private int MEM_ID;
    private final String MEMB_NAME;
    private final String MEMB_LASTNAME;
    private final String MEMB_NATIONALCODE;
    private int MEMB_GENDER;
    private Date MEMB_BOD;
    private String MEMB_EMAIL;
    private String MEMB_MOBILE;
    private String MEMB_TEL;
    private String MEMB_ADDRESS;
    private Date MEMB_REGISTERED_DATE;
    private String MEMB_DESCRIPTION;
    private int MEMB_STATUS_ID;
    private int MEM_EDUCATION_LEVEL_ID;


}
