package com.techChallenge.techgig.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.techChallenge.techgig.contants.DbTables;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = DbTables.ROOM_DETAIL)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomDetail implements IGenericVo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    public int roomId;

    @JsonProperty
    public String roomName;

    public RoomDetail(int roomId, String building, int floor) {
        this.roomId = roomId;
        this.building = building;
        this.floor = floor;

    }

    public RoomDetail() {
    }

    @JsonProperty
    public String building;

    @JsonProperty
    public int floor;

    @ManyToOne
    @JoinColumn(name = "mRTypeId", nullable = false)
    private MeetingRoomType meetingRoomType;

    @OneToMany(mappedBy="roomId")
    @Transient
    public Set<BookingDetail> bookingDetails;


    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getMeetingRoomType() {
        return meetingRoomType.type;
    }

    public void setMeetingRoomType(MeetingRoomType meetingRoomType) {
        this.meetingRoomType.type = meetingRoomType.type;
    }
}

