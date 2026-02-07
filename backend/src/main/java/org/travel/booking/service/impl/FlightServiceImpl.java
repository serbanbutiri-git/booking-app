package org.travel.booking.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.travel.booking.model.Flight;
import org.travel.booking.repository.FlightRepository;
import org.travel.booking.service.FlightService;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    @Override
    @Cacheable("flights")
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    @CacheEvict(value = "flights", allEntries = true)
    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }
}
