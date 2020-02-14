package ua.jackson.awsPractice.SO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.jackson.awsPractice.SO.*;
import ua.jackson.awsPractice.entity.Guest;
import ua.jackson.awsPractice.repository.GuestRepo;

import java.util.List;


@RestController
@CrossOrigin
public class GreetingController {

    @Autowired
    GuestRepo guestRepo;

    @Autowired
    TouristService touristService;

    @Autowired
    TouristRepo touristRepo;

    @Autowired
    FlightRepo flightRepo;

    @GetMapping("/edit/{id}")
    public Tourist editTourist(@PathVariable Long id){
        return this.touristRepo.getOne(id);
    }

    @GetMapping("/edit2/{id}")
    public Flight editTourist2(@PathVariable Long id){
        return this.flightRepo.getOne(id);
    }




    @PostMapping("/test2")
    public String name22(@RequestBody Boolean flag){
        if(flag)
            return "true";
        return "false";
    }

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