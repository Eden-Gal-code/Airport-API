package com.eden.checkin.modules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    @Id
    @GeneratedValue
    private int id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Passenger> passengers;
    @OneToOne(cascade = CascadeType.MERGE)
    private Plane plane;
    private String departure;
    private String destination;
    private double maxLuggageWeight;
    private double maxNumLuggage;
    private double currentWeight;
    private int currentVacantSeat;
}
