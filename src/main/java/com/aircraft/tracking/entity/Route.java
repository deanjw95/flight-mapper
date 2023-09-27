package com.aircraft.tracking.entity;


import com.aircraft.tracking.dto.CityRequest;
import com.aircraft.tracking.dto.RouteRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "city")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "airline_icao")
    private String airlineIcao;
    @Column(name = "airline_iata")
    private String airlineIata;
    @Column(name = "flight_icao")
    private String flightIcao;
    @Column(name = "flight_iata")
    private String flightIata;
    @Column(name = "flight_number")
    private String flightNumber;

    public Route(RouteRequest.RouteResponse response) {
        this.airlineIcao = response.getAirlineIcao();
        this.airlineIata = response.getAirlineIata();
        this.flightIcao = response.getFlightIcao();
        this.flightIata = response.getFlightIata();
        this.flightNumber = response.getFlightNumber();
    }
}