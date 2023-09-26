package com.aircraft.tracking.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "iata_code")
    private String iataCode;
    @Column(name = "name")
    private String name;
    @Column(name = "icao_code")
    private String icaoCode;
}
