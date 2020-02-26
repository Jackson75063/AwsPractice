package ua.jackson.awsPractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.jackson.awsPractice.entity.Abiturient;
import ua.jackson.awsPractice.entity.Faculty;
import ua.jackson.awsPractice.entity.Subject;
import ua.jackson.awsPractice.repository.AbitRepos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AbiturientService {

    @Autowired
    private AbitRepos abitRepos;


    public Abiturient abitWithMaxAvgMark(){
        List<Abiturient> all = abitRepos.findAll();

        return all.stream()
                .max(Comparator.comparing(Abiturient::getAvgDiplomaMark))
                .orElseThrow(() -> new RuntimeException("No abiturient found exception"));
    }

    public void getAllAbitsFromOneFaculty(){}

    //sort by (NAME, SURNAME, )
    public List<Abiturient> getAllAbits(){

        return abitRepos.findAll();
    }


    public void abitWithGraterZNOMark(){
        List<Abiturient> all = abitRepos.findAll();

    };

    public List<Abiturient> abitWithGreaterMark(Subject subject, String facultName){

        facultName = "string";
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

        List<Double> collect1 = abitRepos.findAll().stream().map(Abiturient::getAvgDiplomaMark).collect(Collectors.toList());
        collect1.forEach(System.out::println);

        System.out.println(collect1.size());

        String finalFacultName = facultName;
        List<Abiturient> collect2 = new ArrayList<>();
        List<Abiturient> all = abitRepos.findAll();

        List<String> collect = all.stream().flatMap(x -> x.getFaculties().stream().map(Faculty::getFacultyName)).collect(Collectors.toList());

        collect.forEach(System.out::println);

        collect2.forEach(System.out::println);

        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");


        return collect2;


    }

    public void generatePDFReport(){}
}
