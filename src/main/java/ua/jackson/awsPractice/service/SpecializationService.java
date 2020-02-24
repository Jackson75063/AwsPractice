package ua.jackson.awsPractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.jackson.awsPractice.entity.Specialization;
import ua.jackson.awsPractice.repository.SpecRepo;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

@Service
public class SpecializationService {

    @Autowired
    private SpecRepo specRepo;

    public void add(){

    }

    public Stream<Object> allSpecFromOneFaculty(String facultyName){
        return specRepo.findAll().stream().map(e -> e.getSpecializationName().equals(facultyName));
    }

    public List<Specialization> allSpec(){
        return specRepo.findAll();
    }


    public Map<Specialization, Long> mostPopularSpecialization(){


        List<Specialization> all = specRepo.findAll();

        Map<Specialization, Long> collect = all.stream().collect(groupingBy(Function.identity(), counting()));

        collect.values().forEach(System.out::println);
        collect.keySet().forEach(System.out::println);


//        return specRepo.findAll().stream().map(e->).count();
        return collect;

    }

    public void allSpecializationCode(){}


}
