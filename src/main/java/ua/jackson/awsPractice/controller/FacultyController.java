package ua.jackson.awsPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.jackson.awsPractice.dto.AllFacultiesDto;
import ua.jackson.awsPractice.dto.FacultyDto;
import ua.jackson.awsPractice.entity.Abiturient;
import ua.jackson.awsPractice.entity.Faculty;
import ua.jackson.awsPractice.entity.Specialization;
import ua.jackson.awsPractice.entity.Subject;
import ua.jackson.awsPractice.maptest.ZNOOneSubject;
import ua.jackson.awsPractice.repository.AbitRepos;
import ua.jackson.awsPractice.repository.FacultyRepo;
import ua.jackson.awsPractice.service.FacultyService;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class FacultyController {

    @Autowired
    private FacultyRepo facultyRepo;

   /* @Autowired
    private FacultyService facultyService;
*/
    @Autowired
    private AbitRepos abitRepos;

   /* @GetMapping("/allFa")
    List<Faculty> faculties(){
        List<FacultyDto> facultsDTO = new ArrayList<>();

        List<Faculty> all = facultyRepo.findAll();

//
//        all.stream().map(faculty -> facultsDTO.add(new FacultyDto(faculty.getFacultyName(), )))

       *//*
        all.stream().map(faculty -> facultsDTO.add(new FacuDTO(
                faculty.getFacultyIdl(),
                faculty.getFacultyName(),
                new HashSet<SpecDTO>(new SpecDTO(faculty.getSpecializations()
                        .stream()
                .collect(Collectors.toList())
                )
        ))).collect(Collectors.toList());

*//*


        return facultyRepo.findAll();
    }*/

    @GetMapping("/allFa/{id}")
    List<Faculty> faculties2(@PathVariable Long id) {

        List<Faculty> canPass = new ArrayList<>();


        List<Faculty> all = facultyRepo.findAll();
        Abiturient one = this.abitRepos.getOne(id);
        Set<ZNOOneSubject> subjs = one.getSubjs();

        List<Subject> collect = subjs.stream().map(ZNOOneSubject::getSubject).collect(Collectors.toList());

        subjs.forEach(System.out::println);
        System.out.println(one);



        for (Faculty faculty : all) {
            Set<Specialization>   aa = new HashSet<>();

            Set<Specialization> specializations = faculty.getSpecializations();
            ArrayList<Specialization> specs = new ArrayList<>(specializations);

            Faculty faculty1 = new Faculty();
            faculty1.setFacultyIdl(faculty.getFacultyIdl());
            faculty1.setFacultyName(faculty.getFacultyName());

            System.out.println("INSIDE 1");

            for (Specialization spec : specs) {
                if (spec.getNeedSubjects().containsAll(collect) /*&& spec.getNeedSubjects().size()>0*/ ) {
                    aa.add(spec);
                }
            }
            faculty1.setSpecializations(aa);

            if(faculty1.getSpecializations().size()>0) {
                canPass.add(faculty1);
            }
        }

        return canPass;
    }


    private List<Specialization> getAllSpecByFaculty(Faculty faculty){
        Set<Specialization> specializations = faculty.getSpecializations();


        return new ArrayList<>(specializations) ;
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

   /* @GetMapping("/allFaName")
    public List<String> name(){




        return this.facultyService.allFacultiesNameList();
    }*/

}
