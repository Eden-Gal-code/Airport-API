package com.eden.checkin.service;

import com.eden.checkin.beans.Flight;
import com.eden.checkin.beans.Luggage;
import com.eden.checkin.beans.Passenger;
import com.eden.checkin.beans.Plane;
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

    public boolean isLuggageAllowedWeightPerOne(Flight flight, List<Luggage> luggage)throws LuggageWeightPerOneException {
        boolean allowed=true;
        for (int i = 0; i < luggage.size(); i++) {
            if(luggage.get(i).getWeight()> flight.getMax_luggage_weight()) {
                allowed = false;
                throw new LuggageWeightPerOneException();
            }
        }

        return allowed;
    }
    public boolean isLuggageAllowedNum(Flight flight, List<Luggage> luggage) throws LuggageNumberException {
        boolean allowed=true;
        if(flight.getMax_num_luggage()<luggage.size()){
            allowed=false;
            throw new LuggageNumberException();
        }
        return allowed;
    }
    public boolean isLuggageAllowedTotalWeight(Flight flight, List<Luggage> luggage) throws LuggageTotalWeightException {
        double passenger_weight = 0;
        for (int i = 0; i < luggage.size(); i++) {
            passenger_weight += luggage.get(i).getWeight();
        }
        if (flight.getPlane().getMax_weight() > flight.getCurrent_weight() + passenger_weight) {

            return true;

        }
        throw new LuggageTotalWeightException();

    }
    public void increaseCurrentWeight(Flight flight,List<Luggage> luggage){
        double passenger_weight = 0;
        for (int i = 0; i < luggage.size(); i++) {
            passenger_weight += luggage.get(i).getWeight();
        }
        flight.setCurrent_weight(flight.getCurrent_weight()+passenger_weight);
        repo.saveAndFlush(flight);
    }
    public void increaseCurrentSeat(Flight flight){
        flight.setCurrent_vacant_seat(flight.getCurrent_vacant_seat()+1);
        repo.saveAndFlush(flight);
    }
    public boolean canGetASeat(Flight flight) throws CanGetSeatException {

        if (flight.getPlane().getSeats() > flight.getCurrent_vacant_seat()+1) {

            return true;

        }
        throw new CanGetSeatException();


    }

}
