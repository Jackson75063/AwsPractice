package ua.jackson.awsPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.jackson.awsPractice.entity.Guest;
import ua.jackson.awsPractice.repository.GuestRepo;

import java.util.List;

@RestController
public class GreetingController {

    @Autowired(required = false)
    GuestRepo guestRepo;


    @GetMapping("/getOne/{id}")
    public Guest getGuestById(@PathVariable Long id){
        Guest one = guestRepo.getOne(id);
        Guest guest = new Guest(one.getId(),one.getName(),one.getSurname());
        return guest;
    }

    @GetMapping("/getAll")
    public List<Guest> gellAll(){
        return guestRepo.findAll();
    }

    @GetMapping("/save")
    public Guest saveGuest(@RequestBody Guest guest){
        return guestRepo.save(guest);
    }

    @GetMapping("/del/{id}")
    public void delGuest(@PathVariable Long id){
        guestRepo.deleteById(id);
    }




//    @MessageMapping("/hello")
//    @SendTo("/topic/greetings")
//    public Greeting greeting(HelloMessage message) throws Exception {
//        Thread.sleep(1000); // simulated delay
//        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
//    }

}