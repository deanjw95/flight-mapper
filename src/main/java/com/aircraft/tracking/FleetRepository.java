package com.aircraft.tracking;

import com.aircraft.tracking.entity.Country;
import com.aircraft.tracking.entity.Fleet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FleetRepository extends JpaRepository<Fleet, String> {

}
