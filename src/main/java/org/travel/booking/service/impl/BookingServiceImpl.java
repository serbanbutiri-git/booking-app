package org.travel.booking.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.travel.booking.model.Bookable;
import org.travel.booking.model.Booking;
import org.travel.booking.model.User;
import org.travel.booking.repository.BookableRepository;
import org.travel.booking.repository.BookingRepository;
import org.travel.booking.service.BookingService;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookableRepository bookableRepository;
    private final UserServiceImpl userService;

    @Override
    public Booking createBooking(Long userId, Long bookableId, Integer travelerCount, String tripPurpose) {
        User user = userService.getUserById(userId);

        Bookable bookable = bookableRepository.findById(bookableId)
                .orElseThrow(() -> new RuntimeException("Bookable not found"));

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setBookable(bookable);
        booking.setTravelerCount(travelerCount);
        booking.setTripPurpose(tripPurpose);
        booking.setBookingDate(LocalDateTime.now());

        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookingsForUser(String email) {
        User user = userService.getUserByEmail(email);
        return bookingRepository.findByUser(user);
    }
}
