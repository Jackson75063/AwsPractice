package ua.jackson.awsPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.jackson.awsPractice.dto.FacultyDto;
import ua.jackson.awsPractice.entity.Abiturient;
import ua.jackson.awsPractice.entity.Faculty;
import ua.jackson.awsPractice.entity.Specialization;
import ua.jackson.awsPractice.entity.Subject;
import ua.jackson.awsPractice.repository.AbitRepos;
import ua.jackson.awsPractice.repository.FacultyRepo;
import ua.jackson.awsPractice.repository.SpecRepo;
import ua.jackson.awsPractice.service.AbiturientService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

@CrossOrigin("*")
@RestController

public class AbitController {

    @Autowired
    FacultyRepo facultyRepo;

    @Autowired
    SpecRepo specRepo;

    @Autowired
    private AbitRepos abitRepos;

    @Autowired
    private AbiturientService abitS;


    @GetMapping(value = "/allAA")
    public List<Abiturient> allADD(){
        return abitS.getAllAbits();
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping(value = "/addAbit", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addedAbitur(@RequestBody Abiturient abiturient){
//        this.abitRepos.save(abiturient);
        System.out.println(abiturient);
        return abiturient.toString();
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping(value = "/allAb")
    public List<Abiturient> allAbitsFullInfo(){
        return abitRepos.findAll();
    }

    @GetMapping("/max")
    public Abiturient maxAVG() {
        return abitS.abitWithMaxAvgMark();
    }

    @DeleteMapping("/del/{id}")
    public void deleteById(@PathVariable Long id){
        Abiturient one = abitRepos.getOne(id);

        one.setFaculties(null);

//        List<Faculty> faculties = one.getFaculties();
//        faculties.forEach(e -> e.getSpecializations().forEach(q-> q.se specRepo.delete(q)));
//        faculties.forEach(faculty -> facultyRepo.delete(faculty));

        abitRepos.delete(one);

    }


//    @GetMapping(value = "/asd", produces = MediaType.APPLICATION_JSON_VALUE, consumes =  MediaType.APPLICATION_JSON_VALUE)
//    public FacultyDto allAbitsList(){

//        FacultyDto facultyDto = new FacultyDto();
//        Set<Abiturient> abiturients = new HashSet<>(abitRepos.findAll());
//        facultyDto.setAbiturients(abiturients);
//
//        return facultyDto;
//    }

    @GetMapping(value = "/max/{subject}", produces = MediaType.APPLICATION_JSON_VALUE, consumes =  MediaType.APPLICATION_JSON_VALUE)
    public List<Abiturient> maxBySubject(@PathVariable Subject subject){
        return  abitS.abitWithGreaterMark(subject,"");
    }

}
