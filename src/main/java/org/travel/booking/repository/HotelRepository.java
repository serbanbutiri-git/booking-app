package org.travel.booking.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.travel.booking.model.City;
import org.travel.booking.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByCity(City city);
}
