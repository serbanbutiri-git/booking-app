package org.travel.booking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.travel.booking.model.Bookable;
import org.travel.booking.model.Booking;
import org.travel.booking.repository.BookableRepository;
import org.travel.booking.repository.BookingRepository;
import org.travel.booking.repository.UserRepository;
import org.travel.booking.service.impl.BookingServiceImpl;
import org.travel.booking.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
class BookingServiceImplTest {

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private BookableRepository bookableRepository;

    @Mock
    private UserServiceImpl userService;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Test
    void shouldCreateBookingForUserAndBookable() {
        Bookable bookable = new Bookable() {
        }; // anonymous since Bookable is abstract
        bookable.setId(10L);

        when(bookableRepository.findById(10L)).thenReturn(Optional.of(bookable));

        bookingService.createBooking(1L, 10L);

        verify(bookingRepository).save(org.mockito.ArgumentMatchers.any(Booking.class));
    }

    @Test
    void shouldThrowWhenBookableNotFound() {
        when(bookableRepository.findById(88L)).thenReturn(Optional.empty());

        try {
            bookingService.createBooking(1L, 88L);
        } catch (RuntimeException ex) {
            assertEquals("Bookable not found", ex.getMessage());
        }
    }
}