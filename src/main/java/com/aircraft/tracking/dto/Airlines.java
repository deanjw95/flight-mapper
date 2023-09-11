package com.aircraft.tracking.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Airlines {


    @Id
    private String iataCode;
    private String name;
    private String iataPrefix;
    private String iataAccounting;
    private String icaoCode;
    private String callsign;
    private String countryCode;
    private String iosaRegistered;
    private String isScheduled;
    private String isPassenger;
    private String isCargo;
    private String isInternational;
    private String totalAircrafts;
    private String averageFleetAge;
    private String accidentsLast5y;
    private String crashesLast5y;
    private String website;
    private String facebook;
    private String twitter;
    private String instagram;
    private String linkedin;
    private String slug;

}
