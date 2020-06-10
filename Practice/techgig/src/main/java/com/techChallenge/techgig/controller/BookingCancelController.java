package com.techChallenge.techgig.controller;


import com.techChallenge.techgig.handler.BookingCancelHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@EnableAutoConfiguration
public class BookingCancelController {

    @Autowired
    BookingCancelHandler bookingCancelHandler;

    @PostMapping(value = "/bookingCancel/{referenceId}")
    public ResponseEntity<String> bookMeetingRoom(@PathVariable(name = "referenceId", required = true) String referenceId) throws Exception {
        ResponseEntity<String> responseEntity = bookingCancelHandler.cancelBooking(referenceId);
        return responseEntity;

    }
}
