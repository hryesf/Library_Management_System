package com.myresume.librarymanagementsystem.gender.service;

import com.myresume.librarymanagementsystem.gender.entity.Gender;
import com.myresume.librarymanagementsystem.gender.repository.GenderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderService {
    final GenderRepository genderRepository;

    public GenderService(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    public void saveGender(Gender gender) {
        genderRepository.save(gender);
    }
    public void saveGenders(List<Gender> genders) {
        genderRepository.saveAll(genders);
    }

    public List<Gender> getAllGenders(){
        return genderRepository.findAll();
    }


}
