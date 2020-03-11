/*
package ua.jackson.awsPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.jackson.awsPractice.entity.Specialization;
import ua.jackson.awsPractice.entity.Subject;
import ua.jackson.awsPractice.service.SpecializationService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class TestContrl {

//    @Autowired
//    private TestEnt2 testEnt2;

    @Autowired
    private SpecializationService specializationService;

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



   @GetMapping("/tt")
    public List<Abiturient> alla(){
        return abitRepos.findTopByAvgDiplomaMark();
    }


    @GetMapping("/zxc")
    public Map<Specialization, Long> addxzcasd(){
        return specializationService.mostPopularSpecialization();
    }

}

*/
