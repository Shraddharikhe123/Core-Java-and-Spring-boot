package com.techChallenge.techgig.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.techChallenge.techgig.contants.DbTables;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = DbTables.BOOKING_DETAIL)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingDetail implements IGenericVo {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @JsonProperty
   public int bId;

   @JsonProperty
    public String bookingName;

   @ManyToOne
   @JoinColumn(name = "roomId", nullable = false)
    private RoomDetail roomId;

  @JsonProperty
    public String referenceId;

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

   public RoomDetail getRoomId() {
        return roomId;
    }

    public void setRoomId(RoomDetail roomId) {
        this.roomId = roomId;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public LocalDateTime getBookedDateTimeTo() {
        return bookedDateTimeTo;
    }

    public void setBookedDateTimeTo(LocalDateTime bookedDateTimeTo) {
        this.bookedDateTimeTo = bookedDateTimeTo;
    }

    public LocalDateTime getBookedDateTimeFrom() {
        return bookedDateTimeFrom;
    }

    public void setBookedDateTimeFrom(LocalDateTime bookedDateTimeFrom) {
        this.bookedDateTimeFrom = bookedDateTimeFrom;
    }

    @JsonProperty
    public String status;

   @JsonProperty("bookedDateTimeTo")
    public LocalDateTime bookedDateTimeTo;

   @JsonProperty("bookedDateTimeFrom")
   public LocalDateTime bookedDateTimeFrom;



}
