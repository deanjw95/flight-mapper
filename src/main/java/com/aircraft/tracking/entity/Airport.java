package com.aircraft.tracking.entity;


import com.aircraft.tracking.dto.AirlineRequest;
import com.aircraft.tracking.dto.AirportRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "airport")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "iata_code")
    private String iataCode;

    @Column(name = "name")
    private String name;

    @Column(name = "icao_code")
    private String icaoCode;

    @Column(name = "lat")
    private double lat;

    @Column(name = "lng")
    private double lng;

    @Column(name = "country_code")
    private String countryCode;

    public Airport(AirportRequest.AirportResponse response) {
        this.iataCode = response.getIataCode();
        this.name = response.getName();
        this.icaoCode = response.getIcaoCode();
        this.lat = response.getLat();
        this.lng = response.getLng();
        this.countryCode = response.getCountryCode();
    }
}