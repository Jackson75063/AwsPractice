package ua.jackson.awsPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.jackson.awsPractice.entity.Specialization;
import ua.jackson.awsPractice.repository.SpecRepo;

import java.util.List;

@RestController
@CrossOrigin("*")
public class SpecController {

    @Autowired
    private SpecRepo specRepo;

    @PostMapping("/addSpec")
    public String addedSpec(@RequestBody Specialization specialization){
        this.specRepo.save(specialization);

        return specialization.toString();
    }
    @GetMapping("/allSpec")
    public List<Specialization> al22l(){
        return specRepo.findAll();
    }

}
