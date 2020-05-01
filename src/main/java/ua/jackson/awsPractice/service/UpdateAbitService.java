package ua.jackson.awsPractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.jackson.awsPractice.entity.Abiturient;
import ua.jackson.awsPractice.payload.request.UpdateAbitRequest;
import ua.jackson.awsPractice.repository.AbitRepos;

@Service
public class UpdateAbitService {

    @Autowired
    AbitRepos abitRepos;

    public void updateAbbit(UpdateAbitRequest updateAbitRequest){
        Abiturient one = abitRepos.getOne(updateAbitRequest.getIdAbitCode());
        one.setSubjs(updateAbitRequest.getSubjs());
        abitRepos.save(one);
    }
}
