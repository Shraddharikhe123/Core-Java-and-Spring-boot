package com.techChallenge.techgig.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techChallenge.techgig.beans.BookingDetail;
import com.techChallenge.techgig.beans.IGenericVo;
import com.techChallenge.techgig.beans.RoomDetail;
import com.techChallenge.techgig.contants.ResponseMessage;
import com.techChallenge.techgig.dao.DBQueries;
import com.techChallenge.techgig.dao.KeyValue;
import com.techChallenge.techgig.service.IService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Handle Booking of Meeting Rooms
 */
@Component
public class BookingHandler {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    IService iService;

    /**
     * @param bookingdata
     * @return
     */
    public ResponseEntity addBookingData(String bookingdata) {

        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(bookingdata);

            JSONObject jsonObject = jsonArray.getJSONObject(0);

            String roomDetail1 = DBQueries.GETROOMIDANDMEETINGROOMDETAIL.replace("#className#", "RoomDetail");

            List<KeyValue> conditions = new ArrayList<>();
            conditions.add(new KeyValue("roomName", jsonObject.get("roomName")));
            conditions.add(new KeyValue("building", jsonObject.get("building")));
            conditions.add(new KeyValue("floor", jsonObject.get("floor")));

            List<IGenericVo> dataQuery = iService.getDataQuery(roomDetail1, conditions);
            if (dataQuery == null || dataQuery.isEmpty()) {
                return new ResponseEntity(ResponseMessage.NO_ROOMS_AVAILABLE_WITH_ENTERED_INFORMATION, HttpStatus.UNPROCESSABLE_ENTITY);
            }
            RoomDetail roomDetail = (RoomDetail) dataQuery.get(0);
            String meetingRoomType = (String) jsonObject.get("meetingRoomType");
            if (!roomDetail.getMeetingRoomType().equals(meetingRoomType)) {
                return new ResponseEntity(ResponseMessage.NO_ROOMS_AVAILABLE_WITH_ENTERED_INFORMATION, HttpStatus.UNPROCESSABLE_ENTITY);

            }

            boolean b = roomAlreadyBooked(jsonArray,roomDetail);
            if(b) {
                UUID uuid = UUID.randomUUID();
                BookingDetail bookingDetail = objectMapper
                        .readValue(jsonArray.getJSONObject(0).toString(), BookingDetail.class);
                bookingDetail.setReferenceId(String.valueOf(uuid));
                bookingDetail.setStatus("BOOKED");
                bookingDetail.setRoomId(roomDetail);

                iService.saveData(bookingDetail);

                return new ResponseEntity<String>(ResponseMessage.ROOM_BOOKED_SUCCESSFULLY + uuid, HttpStatus.OK);
            }
            return new ResponseEntity<String>(ResponseMessage.ROOM_ALREADY_BOOKED_FOR_THIS_TIME, HttpStatus.UNPROCESSABLE_ENTITY);


        } catch (Exception e) {
            return new ResponseEntity(ResponseMessage.TRY_AFTER_SOMETIME_SERVER_ERROR, HttpStatus.EXPECTATION_FAILED);

        }
    }

    /**
     * @param jsonArray
     * @param roomId
     * @return
     * @throws Exception
     */
    private boolean roomAlreadyBooked(JSONArray jsonArray, RoomDetail roomId) throws Exception {
        BookingDetail bookingDetail = objectMapper.readValue(jsonArray.getJSONObject(0).toString(), BookingDetail.class);
        LocalDateTime bookedDateTimeTo = bookingDetail.getBookedDateTimeTo();
        LocalDateTime bookedDateTimeFrom = bookingDetail.getBookedDateTimeFrom();
        String alreadyBookedDetail = DBQueries.CHECKROOMISALREADYBOOKED.replace("#className#", "BookingDetail");
        List<KeyValue> conditions = new ArrayList<>();
         conditions.add(new KeyValue("bookedDateTimeTo",bookedDateTimeTo));
         conditions.add(new KeyValue("bookedDateTimeFrom",bookedDateTimeFrom));
         conditions.add(new KeyValue("roomId",roomId));
        List<IGenericVo> dataQuery = iService.getDataQuery(alreadyBookedDetail, conditions);
        if(dataQuery.size()>0){
            return false;
        }

        return true;

    }
}
