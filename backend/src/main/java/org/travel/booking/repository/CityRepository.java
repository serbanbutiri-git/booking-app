package org.travel.booking.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.travel.booking.model.City;

public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findByCode(String code);
}