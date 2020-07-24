package com.eden.checkin.modules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {
    @Id
    @GeneratedValue
    private int id;
    private String fullName;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Luggage> luggage;
    private boolean checkedIn;
    private int seatNumber;
}
