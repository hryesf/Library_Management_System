package com.myresume.librarymanagementsystem.gender.entity.controller;

import com.myresume.librarymanagementsystem.gender.entity.Gender;
import com.myresume.librarymanagementsystem.gender.service.GenderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/genders")
public class GenderController {

    final GenderService genderService;

    public GenderController(GenderService genderService) {
        this.genderService = genderService;
    }

    @GetMapping
    List<Gender> getAllGenders() {
        return genderService.getAllGenders();
    }

    /*@PostMapping
    String saveGender(@Valid @RequestBody Gender gender) {
        genderService.saveGender(gender);
        return "Entity saved successfully";
    }*/

    @PostMapping
    public ResponseEntity<String> saveGenders(@Valid @RequestBody List<Gender> genders) {
        genderService.saveGenders(genders);
        return ResponseEntity.ok("Entities saved successfully");
    }
}
