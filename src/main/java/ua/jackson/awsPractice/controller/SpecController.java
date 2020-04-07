package ua.jackson.awsPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.jackson.awsPractice.entity.Abiturient;
import ua.jackson.awsPractice.entity.Specialization;
import ua.jackson.awsPractice.entity.Subject;
import ua.jackson.awsPractice.maptest.ZNOOneSubject;
import ua.jackson.awsPractice.repository.AbitRepos;
import ua.jackson.awsPractice.repository.SpecRepo;
import ua.jackson.awsPractice.security.service.AbitDetailsServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class SpecController {

    @Autowired
    private SpecRepo specRepo;

    @Autowired
    AbitRepos abitRepos;

    @Autowired
    AbitDetailsServiceImpl abitDetailsService;

    @PostMapping(value = "/addSpec",
//            headers = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

//    @CrossOrigin("http://localhost:4200")
    public String addedSpec(@RequestBody Specialization specialization){

        this.specRepo.save(specialization);
        System.out.println(specialization);
        return specialization.toString();
    }


    //get all specializations for current abiturient
//    @PostMapping(value = "/addSpec",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("http://localhost:4200")
    @GetMapping(value = "/allSpec/{id}")
//    ,
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Specialization> allSpecById(@PathVariable Long id){

        System.out.println("allSpecById");

        List<Specialization> all = specRepo.findAll();

        List<Set<Subject>> collect1 = all.stream()
                .map(Specialization::getNeedSubjects)
                .collect(Collectors.toList());

        Abiturient one = this.abitRepos.getOne(id);

        Set<ZNOOneSubject> subjs = one.getSubjs();

        List<Specialization> collect = all.stream()
                .filter(x -> x.getNeedSubjects().containsAll(subjs))
                .collect(Collectors.toList());


//        List<Subject> collect = one.getSubjs().stream()
//                .filter(x -> x.get)
//                .collect(Collectors.toList());
//        if (collect1.containsAll(collect)){
//            System.out.println("AHUET");
//        } else {
//            System.out.println("PISOS");
//        }
        return collect;
    }

}
