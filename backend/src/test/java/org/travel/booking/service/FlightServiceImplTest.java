package org.travel.booking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.travel.booking.model.Flight;
import org.travel.booking.repository.FlightRepository;
import org.travel.booking.service.impl.FlightServiceImpl;

@ExtendWith(MockitoExtension.class)
class FlightServiceImplTest {

    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private FlightServiceImpl flightService;

    @Test
    void shouldReturnFlightsFromRepository() {
        Flight flight = new Flight();
        flight.setId(1L);

        when(flightRepository.findAll()).thenReturn(List.of(flight));

        List<Flight> result = flightService.getAllFlights();

        assertEquals(1, result.size());
        verify(flightRepository).findAll();
    }
}

