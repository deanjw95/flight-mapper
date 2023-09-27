package com.aircraft.tracking.entity;

import com.aircraft.tracking.dto.AirlineRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "airline")
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

    public Airline(AirlineRequest.AirlineResponse response) {
        this.iataCode = response.getIataCode();
        this.name = response.getName();
        this.icaoCode = response.getIcaoCode();
    }
}
