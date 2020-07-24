package com.eden.checkin.controllers;

import com.eden.checkin.dto.PassengerDTO;
import com.eden.checkin.modules.Flight;
import com.eden.checkin.modules.Luggage;
import com.eden.checkin.modules.Passenger;
import com.eden.checkin.service.*;
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

    @Autowired
    private AirportService airportService;


    @PutMapping("book-flight")
    public ResponseEntity<?> bookFlight(@RequestParam int flightID, @RequestBody Passenger passenger){
       passenger=  passengerService.addPassenger(passenger);
        Flight flight= flightService.bookFlight(flightID,passenger);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("check-in")
    public ResponseEntity<?>  checkIn(@RequestParam int flightID, @RequestParam int passengerID, @RequestBody List<Luggage> luggage) {

        return new ResponseEntity<PassengerDTO>(airportService.checkIn(flightID,passengerID,luggage),HttpStatus.OK);
    }

}
