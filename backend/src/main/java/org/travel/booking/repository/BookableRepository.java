package org.travel.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.travel.booking.model.Bookable;

public interface BookableRepository extends JpaRepository<Bookable, Long> {
}
