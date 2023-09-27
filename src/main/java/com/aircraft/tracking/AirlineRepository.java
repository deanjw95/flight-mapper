package com.aircraft.tracking;

import com.aircraft.tracking.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<Airline, String> {

}
