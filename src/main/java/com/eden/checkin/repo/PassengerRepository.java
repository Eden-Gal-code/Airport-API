package com.eden.checkin.repo;

import com.eden.checkin.beans.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Integer> {

}
