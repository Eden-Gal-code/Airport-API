package com.eden.checkin.dto;

import com.eden.checkin.modules.Luggage;
import com.eden.checkin.modules.Passenger;
import lombok.Data;
import lombok.ToString;


import java.util.ArrayList;
import java.util.List;
@Data
@ToString
public class PassengerDTO {
    private List<String> messages=new ArrayList<>();
    private String fullName;
    private boolean checkedIn;
    private int seatNumber;


    public PassengerDTO(Passenger passenger,List<String>messages){
        this.fullName=passenger.getFullName();
        this.checkedIn=passenger.isCheckedIn();
        this.seatNumber=passenger.getSeatNumber();
        this.messages=messages;
    }

}
