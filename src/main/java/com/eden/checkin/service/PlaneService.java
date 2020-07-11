package com.eden.checkin.service;

import com.eden.checkin.beans.Passenger;
import com.eden.checkin.beans.Plane;
import com.eden.checkin.repo.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneService {
    @Autowired
    private PlaneRepository repo;

    public Plane addPlane(Plane plane) {
        return repo.save(plane);
    }

    public Plane updatePlane(Plane plane) {
        return repo.saveAndFlush(plane);
    }

    public void deletePlane(Plane plane) {
        repo.delete(plane);
    }

    public Plane getOnePlane(int id) {
        return repo.getOne(id);
    }

    public List<Plane> getAllPlanes() {
        return repo.findAll();
    }




}

