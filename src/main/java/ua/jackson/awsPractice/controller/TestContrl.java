package ua.jackson.awsPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.jackson.awsPractice.dto.AllFacultiesDto;
import ua.jackson.awsPractice.dto.FacultyDto;
import ua.jackson.awsPractice.entity.Abiturient;
import ua.jackson.awsPractice.entity.Faculty;
import ua.jackson.awsPractice.entity.Specialization;
import ua.jackson.awsPractice.entity.Subject;
import ua.jackson.awsPractice.entity.garbage.TestEnt;
import ua.jackson.awsPractice.entity.garbage.TestEnt2;
import ua.jackson.awsPractice.repository.AbitRepos;
import ua.jackson.awsPractice.repository.FacultyRepo;
import ua.jackson.awsPractice.repository.SpecRepo;
import ua.jackson.awsPractice.service.AbiturientService;
import ua.jackson.awsPractice.service.FacultyService;
import ua.jackson.awsPractice.service.SpecializationService;

import java.util.*;

@RestController
public class TestContrl {


    @Autowired
    private TestEnt2 testEnt2;

    @Autowired
    private AbitRepos abitRepos;

    @Autowired
    private SpecRepo specRepo;

    @Autowired
    private FacultyRepo facultyRepo;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private SpecializationService specializationService;

    @Autowired
    private AbiturientService abitS;

    @GetMapping("/test")
    private String yeah(){

        TestEnt testEnt = new TestEnt();
        testEnt.setId(3L);

        List<Subject> subjects = Arrays.asList(Subject.UKR_MOVA, Subject.PHISIC);
        Set<Subject> subjects1 = new HashSet<>(subjects);
        testEnt.setSubject(subjects1);

        testEnt2.save(testEnt);

        testEnt.setId(4L);

        subjects = Arrays.asList(Subject.CHEMESTRY, Subject.UKR_MOVA,Subject.HISTORY,Subject.CHEMESTRY);
        subjects1 = new HashSet<>(subjects);
        testEnt.setSubject(subjects1);

        testEnt2.save(testEnt);

        return testEnt.toString();
    }

    @GetMapping("/alls")
    public List<TestEnt> all(){
        List<TestEnt> all = testEnt2.findAll();

        List<Subject> english = new ArrayList<>();
        all.stream().map(TestEnt::getSubject)
                .forEach(subject -> subject.stream()
//                        .filter(subject1 -> subject1.equals(Subject.ENGLISH))
                        .filter(subject1 -> subject1.equals("ENGLISH"))
                        .forEach(english::add));
        System.out.println(english.size());
        english.forEach(System.out::println);
        return  all;
    }

    @PostMapping("/addAbit")
    public String addedAbitur(@RequestBody Abiturient abiturient){
        this.abitRepos.save(abiturient);

        return abiturient.toString();
    }

    @GetMapping("/allAb")
    public List<Abiturient> allAbitsFullInfo(){
        return abitRepos.findAll();
    }



    @PostMapping("/addSpec")
    public String addedSpec(@RequestBody Specialization specialization){
        this.specRepo.save(specialization);

        return specialization.toString();
    }
    @GetMapping("/allSpecs")
    public List<Specialization> al22l(){
        return specRepo.findAll();
    }

    @GetMapping("/allFa")
    List<Faculty> faculties(){
        return facultyRepo.findAll();
    }

    @PostMapping("/addFaculties")
    public String add(@RequestBody Faculty faculty){
        facultyRepo.save(faculty);
        return faculty.toString();
    }

 /*   @GetMapping("/tt")
    public List<Abiturient> alla(){
        return abitRepos.findTopByAvgDiplomaMark();
    }*/


    @GetMapping("/max")
    public Abiturient maxAVG() {
        return abitS.abitWithMaxAvgMark();
    }

    @GetMapping("/allAA")
    public List<Abiturient> allADD(){
        return abitS.getAllAbits();
    }

    @GetMapping("/zxc")
    public Map<Specialization, Long> addxzcasd(){
        return specializationService.mostPopularSpecialization();
    }

    @GetMapping("/asd")
    public FacultyDto allAbitsList(){

        FacultyDto facultyDto = new FacultyDto();
        Set<Abiturient>  abiturients = new HashSet<>(abitRepos.findAll());
        facultyDto.setAbiturients(abiturients);

        return facultyDto;
    }

    @GetMapping("/qwe")
    public AllFacultiesDto allFacultiesDto(){

        AllFacultiesDto facultyDto = new AllFacultiesDto();
        Set<Faculty>  abiturients = new HashSet<>(facultyRepo.findAll());
        facultyDto.setFaculties(abiturients);

        return facultyDto;
    }



}

