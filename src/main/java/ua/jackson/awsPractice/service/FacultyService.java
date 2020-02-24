package ua.jackson.awsPractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.jackson.awsPractice.entity.Faculty;
import ua.jackson.awsPractice.repository.FacultyRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepo facultyRepo;

    public List<String> allFacultiesNameList(){
        return facultyRepo.findAll()
                .stream()
                .map(Faculty::getFacultyName)
                .collect(Collectors.toList());
    }
}
