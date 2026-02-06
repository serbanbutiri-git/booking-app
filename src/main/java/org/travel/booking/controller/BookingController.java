package org.travel.booking.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.travel.booking.dto.BookingRequest;
import org.travel.booking.model.Booking;
import org.travel.booking.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    @Autowired
    private final BookingService bookingService;

    @PostMapping
    public Booking createBooking(@RequestBody BookingRequest bookingRequest) {
        return bookingService.createBooking(bookingRequest.getUserId(),
                bookingRequest.getBookableId(),
                bookingRequest.getTravelerCount(),
                bookingRequest.getTripPurpose());
    }

    @GetMapping
    public List<Booking> getBookings(@RequestParam String email) {
        return bookingService.getBookingsForUser(email);
    }
}
