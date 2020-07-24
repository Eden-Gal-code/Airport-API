package com.eden.checkin.repo;

import com.eden.checkin.modules.Luggage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LuggageRepository extends JpaRepository<Luggage,Integer> {
}
