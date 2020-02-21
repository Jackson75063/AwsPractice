/*
package ua.jackson.awsPractice.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import ua.jackson.awsPractice.SO.GreetingController;
import ua.jackson.awsPractice.entity.Guest;
import ua.jackson.awsPractice.repository.GuestRepo;

import java.util.List;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
class GreetingControllerTest {

//    @Mock
//    protected MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    GreetingController greetingController;

    @Autowired
    GuestRepo guestRepo;

    @Test
    void getGuestById() {
        Guest guest = new Guest(1L,"G1","S1");

        assertEquals(greetingController.getGuestById(1L),guest);
    }

    @Test
    void gellAll() {
        List<Guest> guests = greetingController.gellAll();
        assertNotNull(guests);
        assertEquals(guests.size(),2);
    }

    @Test
    void saveGuest() throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        Guest guest = new Guest(1L,"G1","S1");
        ResponseEntity<Guest> forEntity = restTemplate.getForEntity("http://localhost:8081/getOne/1", Guest.class);

    }

    @Test
    void delGuest() {
    }
}*/
