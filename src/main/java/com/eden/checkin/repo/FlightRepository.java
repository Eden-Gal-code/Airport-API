package com.eden.checkin.repo;

import com.eden.checkin.modules.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository  extends JpaRepository<Flight,Integer> {
}
