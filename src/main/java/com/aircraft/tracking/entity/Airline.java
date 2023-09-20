package com.aircraft.tracking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Airline {

    @Id
    private String iataCode;
    private String name;
    private String icaoCode;
}
