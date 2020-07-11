package com.eden.checkin.repo;

import com.eden.checkin.beans.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneRepository extends JpaRepository<Plane,Integer> {
}
