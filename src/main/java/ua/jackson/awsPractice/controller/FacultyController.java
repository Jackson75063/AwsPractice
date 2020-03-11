package ua.jackson.awsPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.jackson.awsPractice.dto.AllFacultiesDto;
import ua.jackson.awsPractice.entity.Faculty;
import ua.jackson.awsPractice.repository.FacultyRepo;
import ua.jackson.awsPractice.service.FacultyService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
public class FacultyController {

    @Autowired
    private FacultyRepo facultyRepo;

    @Autowired
    private FacultyService facultyService;

    @GetMapping("/allFa")
    List<Faculty> faculties(){
        return facultyRepo.findAll();
    }

    @PostMapping("/addFaculties")
    public String add(@RequestBody Faculty faculty){
        facultyRepo.save(faculty);
        return faculty.toString();
    }

    @GetMapping("/qwe")
    public AllFacultiesDto allFacultiesDto(){

        AllFacultiesDto facultyDto = new AllFacultiesDto();
        Set<Faculty> abiturients = new HashSet<>(facultyRepo.findAll());
        facultyDto.setFaculties(abiturients);

        return facultyDto;
    }

    @GetMapping("/allFaName")
    public List<String> name(){
        return this.facultyService.allFacultiesNameList();
    }

}
