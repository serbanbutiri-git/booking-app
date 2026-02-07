package org.travel.booking.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.travel.booking.model.City;
import org.travel.booking.model.Flight;
import org.travel.booking.service.FlightService;

@WebMvcTest(FlightController.class)
class FlightControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlightService flightService;

    @Test
    void shouldReturnAllFlights() throws Exception {
        Flight flight = new Flight();
        flight.setId(1L);

        City nyc = new City();
        nyc.setName("New York");
        nyc.setCode("NYC");

        City par = new City();
        par.setName("Paris");
        par.setCode("PAR");

        flight.setOrigin(nyc);
        flight.setDestination(par);

        when(flightService.getAllFlights()).thenReturn(List.of(flight));

        mockMvc.perform(get("/api/flights"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].origin.code").value("NYC"))
                .andExpect(jsonPath("$[0].destination.code").value("PAR"));
    }
}

