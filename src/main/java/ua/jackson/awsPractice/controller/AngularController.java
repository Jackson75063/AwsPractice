package ua.jackson.awsPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.jackson.awsPractice.entity.Student;
import ua.jackson.awsPractice.repository.StudentRepo;

import javax.xml.ws.soap.Addressing;

@RestController
@CrossOrigin("*")
public class AngularController {
    @Autowired
    StudentRepo studentRepo;

    @GetMapping("/ang")
    @CrossOrigin("*")
    public Test catched(){

//        Test test1 = new Test(test.getName(),test.getSurname());
//
//        System.out.println(test);
//
//        System.out.println(test.getName());
//        System.out.println(test);

        Test test  = new Test("privet","privet2");

        return test;
    }

    @PostMapping("/ang")
    @CrossOrigin("*")
    public Test catched2(@RequestBody Test test){


//        Test test  = new Test("privet","privet2");
        System.out.print("POST ");
        System.out.println(test);

        return test;
    }


    @PostMapping("/addStud")
    public Student addStudent(@RequestBody Student student){
        System.out.println(student);

     studentRepo.save(student);
     return student;
    }
}
