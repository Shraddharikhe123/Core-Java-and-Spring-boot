package com.techChallenge.techgig.contants;

import org.springframework.http.HttpStatus;

public interface ResponseMessage {

    static final String DATA_NOT_FOUND = "Not Able To extract data";
    static  final String NO_ROOMS_AVAILABLE =" No Rooms Available";
    static final String TRY_AFTER_SOMETIME_SERVER_ERROR ="Try after sometime, Server error";
    static final String ROOM_BOOKED_SUCCESSFULLY = "Room Booked Successfully with Reference Id";
    static final String NO_ROOMS_AVAILABLE_WITH_ENTERED_INFORMATION = "No rooms with following requirement is available" ;
    static final String BOOKING_CANCELLED_SUCCESSFULLY = "Booking Cancelled Successfully";
    static final String ERROR_WHILE_CANCELLATION_TRY_AGAIN_LATER = "Error while cancellation try again later";
    static final String  ROOM_ALREADY_BOOKED = "Room Already Booked";
    String ROOM_ALREADY_BOOKED_FOR_THIS_TIME = "Room Already booked with following time";
}
