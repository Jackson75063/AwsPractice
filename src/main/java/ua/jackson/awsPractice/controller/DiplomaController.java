/*
package ua.jackson.awsPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.jackson.awsPractice.SO.Abiturient;
import ua.jackson.awsPractice.SO.Depart;
import ua.jackson.awsPractice.repository.AbitRepo;
import ua.jackson.awsPractice.repository.DepartRepo;

import java.util.List;

@RestController
public class DiplomaController {
    @Autowired
    AbitRepo abitRepo;

    @Autowired
    DepartRepo departRepo;


    @GetMapping("/allD")
    public List<Abiturient> allAbits(){
        return  abitRepo.findAll();
    }

    @GetMapping("/allA")
    public List<Depart> allDepa(){
        return  departRepo.findAll();
    }

}

*/
