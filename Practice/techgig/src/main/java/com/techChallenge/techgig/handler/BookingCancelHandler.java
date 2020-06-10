package com.techChallenge.techgig.handler;

import com.techChallenge.techgig.contants.ResponseMessage;
import com.techChallenge.techgig.dao.DBQueries;
import com.techChallenge.techgig.dao.KeyValue;
import com.techChallenge.techgig.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookingCancelHandler {

    @Autowired
    IService iService;

    public ResponseEntity<String> cancelBooking(String referenceId) {
        try {
            String bookingDetailWithReferenceID = DBQueries.DELETEBOOKEDROOMDETAILSWITHREFERNCEID.replace("#className#", "BookingDetail");
            List<KeyValue> conditions = new ArrayList<>();
            conditions.add(new KeyValue("referenceId", referenceId));

            iService.deleteBooking(bookingDetailWithReferenceID, conditions);

        return new ResponseEntity<String>(ResponseMessage.BOOKING_CANCELLED_SUCCESSFULLY, HttpStatus.OK);
    } catch (Exception e) {
            return new ResponseEntity<String>(ResponseMessage.ERROR_WHILE_CANCELLATION_TRY_AGAIN_LATER, HttpStatus.EXPECTATION_FAILED);
        }


    }
}
