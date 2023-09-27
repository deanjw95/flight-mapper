package com.aircraft.tracking;

import com.aircraft.tracking.entity.City;
import com.aircraft.tracking.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, String> {

}
