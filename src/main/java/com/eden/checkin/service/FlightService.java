package com.eden.checkin.service;

import com.eden.checkin.modules.Flight;
import com.eden.checkin.modules.Luggage;
import com.eden.checkin.modules.Passenger;
import com.eden.checkin.error.CanGetSeatException;
import com.eden.checkin.error.LuggageNumberException;
import com.eden.checkin.error.LuggageTotalWeightException;
import com.eden.checkin.error.LuggageWeightPerOneException;
import com.eden.checkin.repo.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightRepository repo;

    public Flight addFlight(Flight flight){
        return repo.save(flight);
    }
    public Flight updateFlight(Flight flight){
        return repo.saveAndFlush(flight);
    }
    public void deleteFlight(Flight flight){
        repo.delete(flight);
    }
    public Flight getOneFlight(int id){
        return repo.getOne(id);
    }
    public List<Flight> getAllFlight(){
        return repo.findAll();
    }

    public Flight bookFlight(int flightID,Passenger passenger){
        Flight flight=repo.getOne(flightID);
        if(flight.getPlane().getSeats()>flight.getPassengers().size()){
            flight.getPassengers().add(passenger);
        }
        return  repo.saveAndFlush(flight);
    }

    public boolean isLuggageAllowedWeightPerOne(Flight flight, List<Luggage> luggage) {
        boolean allowed=true;
        for (int i = 0; i < luggage.size(); i++) {
            if(luggage.get(i).getWeight()> flight.getMaxLuggageWeight()) {
                allowed = false;

            }
        }

        return allowed;
    }
    public boolean isLuggageAllowedNum(Flight flight, List<Luggage> luggage)  {
        boolean allowed=true;
        if(flight.getMaxNumLuggage()<luggage.size()){
            allowed=false;

        }
        return allowed;
    }
    public boolean isLuggageAllowedTotalWeight(Flight flight, List<Luggage> luggage) {
        double passenger_weight = 0;
        boolean allowed=false;
        for (int i = 0; i < luggage.size(); i++) {
            passenger_weight += luggage.get(i).getWeight();
        }
        if (flight.getPlane().getMaxWeight() > flight.getCurrentWeight() + passenger_weight) {

            allowed= true;

        }
       return allowed;

    }
    public void increaseCurrentWeight(Flight flight,List<Luggage> luggage){
        double passenger_weight = 0;
        for (int i = 0; i < luggage.size(); i++) {
            passenger_weight += luggage.get(i).getWeight();
        }
        flight.setCurrentWeight(flight.getCurrentWeight()+passenger_weight);
        repo.saveAndFlush(flight);
    }
    public void increaseCurrentSeat(Flight flight){
        flight.setCurrentVacantSeat(flight.getCurrentVacantSeat()+1);
        repo.saveAndFlush(flight);
    }
    public boolean canGetASeat(Flight flight) {
        boolean allowed=false;
        if (flight.getPlane().getSeats() > flight.getCurrentVacantSeat()+1) {

            allowed= true;

        }
        return allowed;


    }

}
