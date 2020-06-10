package com.techChallenge.techgig.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.techChallenge.techgig.contants.DbTables;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = DbTables.MEETINGROOMTYPE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeetingRoomType {
    @Id
    @JsonProperty
    public int mRTypeId;

    @JsonProperty
    public String type;

    @OneToMany(mappedBy="meetingRoomType")
    public Set<RoomDetail> roomDetail;


    public int getMRTypeId() {
        return mRTypeId;
    }

    public Set<RoomDetail> getRoomDetail() {
        return roomDetail;
    }

    public void setRoomDetail(Set<RoomDetail> roomDetail) {
        this.roomDetail = roomDetail;
    }




    public void setMRTypeId(int MRTypeId) {
        this.mRTypeId = MRTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
