package com.eden.checkin.repo;

import com.eden.checkin.modules.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Integer> {

}
