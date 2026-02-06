package org.travel.booking.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.travel.booking.model.City;
import org.travel.booking.model.Flight;
import org.travel.booking.repository.FlightRepository;
import org.travel.booking.service.CityService;
import org.travel.booking.service.FlightService;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final CityService cityService;

    @Override
    public List<Flight> searchFlights(String from, String to) {
        City origin = cityService.getByCode(from);
        City destination = cityService.getByCode(to);

        return flightRepository.findByOriginAndDestination(origin, destination);
    }
}
