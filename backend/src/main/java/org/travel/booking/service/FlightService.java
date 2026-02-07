package org.travel.booking.service;

import java.util.List;
import org.travel.booking.model.Flight;

public interface FlightService {

    List<Flight> getAllFlights();

    Flight saveFlight(Flight flight);
}
