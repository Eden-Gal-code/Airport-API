package com.eden.checkin.service;

import com.eden.checkin.dto.PassengerDTO;
import com.eden.checkin.modules.Flight;
import com.eden.checkin.modules.Luggage;
import com.eden.checkin.modules.Passenger;
import com.eden.checkin.repo.FlightRepository;
import com.eden.checkin.repo.LuggageRepository;
import com.eden.checkin.repo.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirportService {

    @Autowired
    private FlightService flightService;
    @Autowired
    private LuggageService luggageService;
    @Autowired
    private PassengerService passengerService;

    public PassengerDTO checkIn(int flightID, int passengerID, List<Luggage> luggage){
        Flight flight= flightService.getOneFlight(flightID);
        Passenger passenger=passengerService.getOnePassenger(passengerID);
        List<String> messages= new ArrayList<>();
        if(isAllClear(flight,luggage)){
            flightService.increaseCurrentSeat(flight);
            flightService.increaseCurrentWeight(flight ,luggage);
            luggageService.addLuggageList(luggage);
            passenger.setLuggage(luggage);
            passengerService.updatePassenger(passenger);
            messages.add("Success");
            passengerService.checkIn(passenger,flight);
        }
        else{
            messages=buildErrorMessages(flight,luggage);
        }
        PassengerDTO passengerDTO=new PassengerDTO(passenger,messages);
        System.out.println(passengerDTO);
        return passengerDTO;


    }
    public boolean isAllClear(Flight flight, List<Luggage> luggage){
        if(flightService.isLuggageAllowedTotalWeight(flight,luggage)&&flightService.canGetASeat(flight)&&
                flightService.isLuggageAllowedWeightPerOne(flight,luggage) && flightService.isLuggageAllowedNum(flight,luggage)){
            return true;
        }
        return false;
    }
    public List<String> buildErrorMessages(Flight flight,List<Luggage> luggage){
        List<String> messages=new ArrayList<>();
        if(!flightService.isLuggageAllowedNum(flight,luggage)){
            messages.add(" Too many suitcases ");
        }
        if(!flightService.isLuggageAllowedTotalWeight(flight,luggage)){
            messages.add(" luggage weighs too much ");
        }
        if(!flightService.isLuggageAllowedWeightPerOne(flight,luggage)){
            messages.add(" suitcase max weight exceeded ");
        }
        if(!flightService.canGetASeat(flight)){
            messages.add(" No seat available ");
        }
        return messages;
    }




}
