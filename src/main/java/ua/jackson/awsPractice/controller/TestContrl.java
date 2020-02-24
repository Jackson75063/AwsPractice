package ua.jackson.awsPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.jackson.awsPractice.entity.Abiturient;
import ua.jackson.awsPractice.entity.Faculty;
import ua.jackson.awsPractice.entity.Specialization;
import ua.jackson.awsPractice.entity.Subject;
import ua.jackson.awsPractice.entity.garbage.TestEnt;
import ua.jackson.awsPractice.entity.garbage.TestEnt2;
import ua.jackson.awsPractice.repository.AbitRepos;
import ua.jackson.awsPractice.repository.FacultyRepo;
import ua.jackson.awsPractice.repository.SpecRepo;

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
    public List<Abiturient> allAbits(){
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
}
