package com.aircraft.tracking;

import com.aircraft.tracking.dto.Airlines;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlinesRepository extends JpaRepository<Airlines, String> {

}
