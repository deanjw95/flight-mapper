package com.aircraft.tracking.entity;


import com.aircraft.tracking.dto.CountryRequest;
import com.aircraft.tracking.dto.FleetRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "fleet")
public class Fleet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hex")
    private String hex;

    @Column(name = "airline_icao")
    private String airlineIcao;

    @Column(name = "airline_iata")
    private String airlineIata;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "icao")
    private String icao;

    @Column(name = "iata")
    private String iata;

    public Fleet(FleetRequest.FleetResponse response) {
        this.hex = response.getHex();
        this.airlineIcao = response.getAirlineIcao();
        this.airlineIata = response.getAirlineIata();
        this.manufacturer = response.getManufacturer();
        this.icao = response.getIcao();
        this.iata = response.getIata();
    }
}