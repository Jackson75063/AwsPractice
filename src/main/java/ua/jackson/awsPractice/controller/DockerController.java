package ua.jackson.awsPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.jackson.awsPractice.model.DockerTest;

@RestController
@CrossOrigin
public class DockerController {

    @Autowired
    DockerTest dockerTest;

    @GetMapping("/docker")
    public String info(){
        return dockerTest.toString();

    }
}
