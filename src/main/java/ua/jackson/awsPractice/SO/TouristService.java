package ua.jackson.awsPractice.SO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class TouristService {

    @Autowired
    TouristRepo touristRepo;

    Predicate<Integer> lesserthan ;


    public Depart editTourist(long id) {
        return touristRepo.getOne(id);
    }

    // Calling Predicate method
    void print() {
        lesserthan = i -> (i < 18);
        System.out.println(lesserthan.test(10));
    }

}
