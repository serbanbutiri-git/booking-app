package org.travel.booking.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.travel.booking.model.City;
import org.travel.booking.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByOriginAndDestination(City origin, City destination);
}
