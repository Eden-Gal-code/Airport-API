package com.eden.checkin.beans;

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
    private String full_name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Luggage> luggage;
    private boolean checked_in;
    private int seat_number;
}
