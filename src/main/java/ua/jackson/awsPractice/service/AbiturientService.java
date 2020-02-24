package ua.jackson.awsPractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.jackson.awsPractice.entity.Abiturient;
import ua.jackson.awsPractice.entity.Subject;
import ua.jackson.awsPractice.repository.AbitRepos;
import ua.jackson.awsPractice.repository.FacultyRepo;

import java.util.Comparator;
import java.util.List;

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


    public void abitWithGraterZNOMark(){};

    public void abitWithGreaterMark(Subject subject){}


    public void generatePDFReport(){}
}
