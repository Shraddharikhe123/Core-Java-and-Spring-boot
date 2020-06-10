package com.techChallenge.techgig.controller;


import com.techChallenge.techgig.handler.BookingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@EnableAutoConfiguration
public class BookingController {

    @Autowired
    BookingHandler bookingHandler;

    @PostMapping(value = "/booking",consumes = "application/json")
    public ResponseEntity bookMeetingRoom(@RequestBody String bookingdata)  throws Exception {

        ResponseEntity responseEntity = bookingHandler.addBookingData(bookingdata);
        return responseEntity;




    }

}
