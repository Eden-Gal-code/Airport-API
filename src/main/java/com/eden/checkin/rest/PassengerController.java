package com.eden.checkin.rest;

import com.eden.checkin.beans.Flight;
import com.eden.checkin.beans.Luggage;
import com.eden.checkin.beans.Passenger;
import com.eden.checkin.error.CanGetSeatException;
import com.eden.checkin.error.LuggageNumberException;
import com.eden.checkin.error.LuggageTotalWeightException;
import com.eden.checkin.error.LuggageWeightPerOneException;
import com.eden.checkin.service.FlightService;
import com.eden.checkin.service.LuggageService;
import com.eden.checkin.service.PassengerService;
import com.eden.checkin.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("passenger")
public class PassengerController {

    @Autowired
    private PlaneService planeService;

    @Autowired
    private LuggageService luggageService;

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private FlightService flightService;


    @PutMapping("book-flight")
    public ResponseEntity<?> bookFlight(@RequestParam int flightID, @RequestBody Passenger passenger){
       passenger=  passengerService.addPassenger(passenger);
        Flight flight= flightService.bookFlight(flightID,passenger);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("check-in")
    public ResponseEntity<?>  checkIn(@RequestParam int flightID, @RequestParam int passengerID, @RequestBody List<Luggage> luggage) throws LuggageNumberException, LuggageTotalWeightException,LuggageWeightPerOneException, CanGetSeatException {

        Flight flight= flightService.getOneFlight(flightID);
        Passenger passenger=passengerService.getOnePassenger(passengerID);

        if(flightService.isLuggageAllowedTotalWeight(flight,luggage)&&flightService.canGetASeat(flight)&&
                flightService.isLuggageAllowedWeightPerOne(flight,luggage) && flightService.isLuggageAllowedNum(flight,luggage)){
            flightService.increaseCurrentWeight(flight,luggage);
            flightService.increaseCurrentSeat(flight);
            luggage.forEach(luggage1 -> luggageService.addLuggage(luggage1));
            passenger.setLuggage(luggage);


            passengerService.updatePassenger(passenger);
            return new ResponseEntity<Passenger>(passengerService.checkIn(passenger,flight),HttpStatus.OK);

        }
        return new ResponseEntity<String>("Problem with it",HttpStatus.BAD_REQUEST);
    }

}
