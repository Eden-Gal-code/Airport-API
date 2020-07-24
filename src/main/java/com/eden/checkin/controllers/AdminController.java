package com.eden.checkin.controllers;

import com.eden.checkin.modules.Flight;
import com.eden.checkin.modules.Plane;
import com.eden.checkin.service.FlightService;
import com.eden.checkin.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private PlaneService planeService;

    @Autowired
    private FlightService flightService;

    @PostMapping("add-plane")
    public ResponseEntity<?>  addPlane(@RequestBody  Plane plane){
        return new ResponseEntity<Plane>(planeService.addPlane(plane), HttpStatus.OK);
    }
    @GetMapping("get-all-planes")
    public ResponseEntity<?> getAllPlanes(){
        return new ResponseEntity<List<Plane>>(planeService.getAllPlanes(),HttpStatus.OK);
    }

    @GetMapping("get-flight")
    public ResponseEntity<?>  getFlight(@RequestParam int id){
        return new ResponseEntity<Flight>(flightService.getOneFlight(id),HttpStatus.OK);
    }
    @PutMapping("update-flight")
    public ResponseEntity<?> updateFlight(@RequestBody Flight flight){
        return new ResponseEntity<Flight>(flightService.updateFlight(flight),HttpStatus.OK);
    }
    @PostMapping("add-new-flight")
    public ResponseEntity<?> addNewFlight(@RequestBody Flight flight,@RequestParam int planeID){
        Plane plane=planeService.getOnePlane(planeID);
        flight.setPlane(plane);
        return new ResponseEntity<Flight>(flightService.addFlight(flight),HttpStatus.OK);
    }
    @GetMapping("get-all-flights")
    public ResponseEntity<?> getAllFlights(){
        return new ResponseEntity<List<Flight>>(flightService.getAllFlight(),HttpStatus.OK);
    }
}
