package com.eden.checkin.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Luggage {
    @Id
    @GeneratedValue
    private int id;
    private double weight;

//    @ManyToOne(cascade = CascadeType.REMOVE)
//    private Passenger owner;
}
