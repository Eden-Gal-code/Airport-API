package com.eden.checkin.beans;

import jdk.jfr.Enabled;
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
    private double max_luggage_weight;
    private double max_num_luggage;
    private double current_weight;
    private int current_vacant_seat;
}
