package ua.jackson.awsPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.jackson.awsPractice.dto.AbitDTO;
import ua.jackson.awsPractice.dto.AllFacultiesDto;
import ua.jackson.awsPractice.entity.Abiturient;
import ua.jackson.awsPractice.entity.Faculty;
import ua.jackson.awsPractice.entity.Specialization;
import ua.jackson.awsPractice.entity.Subject;
import ua.jackson.awsPractice.models.ZNOOneSubject;
import ua.jackson.awsPractice.payload.request.SetFacultyRequest;
import ua.jackson.awsPractice.repository.AbitRepos;
import ua.jackson.awsPractice.repository.FacultyRepo;
import ua.jackson.awsPractice.service.AbiturientService;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class FacultyController {

    @Autowired
    private FacultyRepo facultyRepo;

    /* @Autowired
     private FacultyService facultyService;
 */
    @Autowired
    private AbitRepos abitRepos;

    @Autowired
    private AbiturientService abiturientService;




    @PutMapping("/setFaculty/{id}")
    public void updateAbit(@PathVariable Long id, @RequestBody Faculty faculties){

        Faculty faculty = new Faculty(
                faculties.getFacultyIdl(),
                faculties.getFacultyName(),
                faculties.getAbiturients(),
                faculties.getSpecializations()
        );


        System.out.println("FAC " +faculty);
        List<Specialization> specializations = faculty.getSpecializations();
        Specialization specialization = specializations.get(specializations.size() - 1);

        Abiturient one = abitRepos.getOne(id);

        System.out.println(one);

        if (!one.getFaculties().contains(faculty)){
            one.getFaculties().add(faculties);
        }

        if(!one.getSpecializations().contains(specialization)) {
            one.getSpecializations().add(specialization);
        }

        one.setRequestCounter(one.getRequestCounter()-1);

        abitRepos.save(one);
    }

    private List<Specialization> getSpecializations(@RequestBody Faculty faculties) {
        return faculties.getSpecializations();
    }

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
        List<Faculty> allFaculty = facultyRepo.findAll();
        AbitDTO abiturient = abiturientService.getAbitById(id);
        Set<ZNOOneSubject> subjs = abiturient.getSubjs();
        List<Subject> collect = subjs.stream().map(ZNOOneSubject::getSubject).collect(Collectors.toList());
        for (Faculty faculty : allFaculty) {
            List<Specialization>   specializationList = new ArrayList<>();
            List<Specialization> specializations = faculty.getSpecializations();
            ArrayList<Specialization> specs = new ArrayList<>(specializations);

            Faculty faculty1 = new Faculty();
            faculty1.setFacultyIdl(faculty.getFacultyIdl());
            faculty1.setFacultyName(faculty.getFacultyName());

            for (Specialization spec : specs) {
                if (spec.getNeedSubjects().containsAll(collect) /*&& spec.getNeedSubjects().size()>0*/ ) {
                    specializationList.add(spec);
                }
            }
            faculty1.setSpecializations(specializationList);

            if(faculty1.getSpecializations().size()>0) {
                canPass.add(faculty1);
            }
        }

        return canPass;
    }

/*
    public void  checkAbit(Faculty faculty, Abiturient abiturient){
        abiturient.getSpecializations()
    }
*/


    private List<Specialization> getAllSpecByFaculty(Faculty faculty){
        List<Specialization> specializations = faculty.getSpecializations();


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
