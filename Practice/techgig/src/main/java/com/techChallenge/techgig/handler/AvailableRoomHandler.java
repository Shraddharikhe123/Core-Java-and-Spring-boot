package com.techChallenge.techgig.handler;

import com.techChallenge.techgig.beans.IGenericVo;
import com.techChallenge.techgig.dao.DBQueries;
import com.techChallenge.techgig.dao.KeyValue;
import com.techChallenge.techgig.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Handler to get Available rooms
 */
@Component
public class AvailableRoomHandler {

    @Autowired
    IService iService;

    /**
     * @return
     * @throws Exception
     */
    public List<IGenericVo> getAllAvailableRooms() throws Exception {

        String getallavailableroomsQuery = DBQueries.GETALLAVAILABLEROOMS.replace("#className#", "RoomDetail");
        List<KeyValue> conditions = new ArrayList<>();
        List<IGenericVo> availableRoomList = iService.getDataQuery(getallavailableroomsQuery, conditions);
        return availableRoomList;


    }
}
