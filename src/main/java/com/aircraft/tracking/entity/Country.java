package com.aircraft.tracking.entity;


import com.aircraft.tracking.dto.CityRequest;
import com.aircraft.tracking.dto.CountryRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "code3")
    private String code3;

    public Country(CountryRequest.CountryResponse response) {
        this.code = response.getCode();
        this.name = response.getName();
        this.code3 = response.getCode3();
    }
}