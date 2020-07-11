package com.eden.checkin.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plane {
    @Id
    @GeneratedValue
    private int id;
    private int seats;
    private double max_weight;


}
