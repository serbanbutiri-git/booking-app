package org.travel.booking.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.travel.booking.model.Flight;
import org.travel.booking.service.FlightService;

@RestController
@RequestMapping("/api/flights")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class FlightController {

    @Autowired
    private final FlightService flightService;

    @GetMapping
    public List<Flight> getFlights() {
        return flightService.getAllFlights();
    }

    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        final Flight saved = flightService.saveFlight(flight);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}

