package ua.jackson.awsPractice.maptest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapTestController {

    @Autowired
    MapTestIface mapTestIface;

    @PostMapping(value = "/addTest")
    @CrossOrigin("*")
    public void  addSubj(@RequestBody MapTest mapTest){
        System.out.println(mapTest);
        System.out.println("TRIGGERED");
//        this.mapTestIface.save(mapTest);
    }

}
