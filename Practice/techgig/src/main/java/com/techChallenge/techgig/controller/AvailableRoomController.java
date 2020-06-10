package com.techChallenge.techgig.controller;


import com.techChallenge.techgig.beans.IGenericVo;
import com.techChallenge.techgig.contants.ResponseMessage;
import com.techChallenge.techgig.handler.AvailableRoomHandler;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller to get List of all available Rooms
 */
@RestController
@CrossOrigin("*")
@EnableAutoConfiguration
public class AvailableRoomController {

    @Autowired
    AvailableRoomHandler availableRoomHandler;


    /**
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/availableRooms")
    public ResponseEntity availableRoomsController() {
        try {

            List<IGenericVo> allAvailableRooms = availableRoomHandler.getAllAvailableRooms();

            if (allAvailableRooms == null || allAvailableRooms.isEmpty()) {
                return ResponseEntity.ok(ResponseMessage.NO_ROOMS_AVAILABLE);
            }
            return new ResponseEntity<List<IGenericVo>>(allAvailableRooms, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(ResponseMessage.TRY_AFTER_SOMETIME_SERVER_ERROR, HttpStatus.EXPECTATION_FAILED);
        }


    }
}
