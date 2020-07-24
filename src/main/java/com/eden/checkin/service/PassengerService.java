package com.eden.checkin.service;

import com.eden.checkin.modules.Flight;
import com.eden.checkin.modules.Passenger;
import com.eden.checkin.repo.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepository repo;

    public Passenger addPassenger(Passenger passenger){
        return repo.save(passenger);
    }
    public Passenger updatePassenger(Passenger passenger){
        return repo.saveAndFlush(passenger);
    }
    public void deletePassenger(Passenger passenger){
        repo.delete(passenger);
    }
    public Passenger getOnePassenger(int id){
        return repo.getOne(id);
    }
    public List<Passenger> getAllPassengers(){
        return  repo.findAll();
    }
    public Passenger checkIn(Passenger passenger,Flight flight){
        passenger.setCheckedIn(true);
        passenger.setSeatNumber(flight.getCurrentVacantSeat());
       return repo.saveAndFlush(passenger);
    }

}
