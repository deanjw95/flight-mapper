package com.aircraft.tracking;

import com.aircraft.tracking.entity.City;
import com.aircraft.tracking.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {

}
