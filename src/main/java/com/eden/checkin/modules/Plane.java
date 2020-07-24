package com.eden.checkin.modules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plane {
    @Id
    @GeneratedValue
    private int id;
    private int seats;
    private double maxWeight;


}
