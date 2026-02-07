package org.travel.booking.service;

import java.util.List;
import org.travel.booking.model.Booking;

public interface BookingService {

    Booking createBooking(Long userId, Long referenceId);

    List<Booking> getBookingsForUser(Long userId);
}
