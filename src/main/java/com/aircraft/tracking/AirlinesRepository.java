package com.aircraft.tracking;

import com.aircraft.tracking.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlinesRepository extends JpaRepository<Airline, String> {

}
