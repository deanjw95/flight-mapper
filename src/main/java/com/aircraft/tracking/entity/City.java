package com.aircraft.tracking.entity;


import com.aircraft.tracking.dto.AirportRequest;
import com.aircraft.tracking.dto.CityRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_code")
    private String cityCode;

    @Column(name = "name")
    private String name;

    @Column(name = "lat")
    private double lat;

    @Column(name = "lng")
    private double lng;

    @Column(name = "country_code")
    private String countryCode;

    public City(CityRequest.CityResponse response) {
        this.cityCode = response.getCityCode();
        this.name = response.getName();
        this.lat = response.getLat();
        this.lng = response.getLng();
        this.countryCode = response.getCountryCode();
    }
}