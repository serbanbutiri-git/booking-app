package org.travel.booking.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.travel.booking.model.Booking;
import org.travel.booking.model.User;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUser(User user);
}
