package com.aircraft.tracking;

import com.aircraft.tracking.entity.Airline;
import com.aircraft.tracking.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, String> {

}
