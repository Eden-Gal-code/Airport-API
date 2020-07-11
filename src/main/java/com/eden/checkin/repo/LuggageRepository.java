package com.eden.checkin.repo;

import com.eden.checkin.beans.Luggage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LuggageRepository extends JpaRepository<Luggage,Integer> {
}
