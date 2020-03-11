package ua.jackson.awsPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.jackson.awsPractice.entity.Specialization;
import ua.jackson.awsPractice.repository.SpecRepo;

import java.util.List;

@RestController
public class SpecController {

    @Autowired
    private SpecRepo specRepo;

    @PostMapping(value = "/addSpec",
//            headers = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("http://localhost:4200")
    public String addedSpec(@RequestBody Specialization specialization){
        this.specRepo.save(specialization);
        System.out.println(specialization);
        return specialization.toString();
    }
    @GetMapping("/allSpec")
    @CrossOrigin("http://localhost:4200")
    public List<Specialization> al22l(){
        return specRepo.findAll();
    }

}
