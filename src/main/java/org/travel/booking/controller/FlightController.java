package org.travel.booking.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.travel.booking.model.Flight;
import org.travel.booking.service.FlightService;

@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor
public class FlightController {

    @Autowired
    private final FlightService flightService;

    @GetMapping
    public List<Flight> searchFlights(@RequestParam String from,
                                      @RequestParam String to) {
        return flightService.searchFlights(from, to);
    }
}

