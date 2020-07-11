package com.eden.checkin.service;

import com.eden.checkin.beans.Luggage;
import com.eden.checkin.repo.LuggageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LuggageService {

    @Autowired
    private LuggageRepository repo;

    public Luggage addLuggage(Luggage luggage){
        return repo.save(luggage);
    }
    public Luggage updateLuggage(Luggage luggage){
        return repo.saveAndFlush(luggage);
    }
    public void deleteLuggage(Luggage luggage){
        repo.delete(luggage);
    }
    public Luggage getOneLuggage(int id){
        return repo.getOne(id);
    }
    public List<Luggage> getAllLuggage(){
        return  repo.findAll();
    }
}
