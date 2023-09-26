package com.aircraft.tracking;

import com.aircraft.tracking.entity.Airline;
import com.aircraft.tracking.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, String> {

}
