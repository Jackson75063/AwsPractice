package ua.jackson.awsPractice.SO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TouristService {

    @Autowired
    TouristRepo touristRepo;


    public Tourist editTourist(long id) {
    return touristRepo.getOne(id);
    }
}
