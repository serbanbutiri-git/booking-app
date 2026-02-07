package org.travel.booking.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.travel.booking.config.SampleDataProperties;
import org.travel.booking.model.City;
import org.travel.booking.model.Flight;
import org.travel.booking.model.Hotel;
import org.travel.booking.repository.CityRepository;
import org.travel.booking.repository.FlightRepository;
import org.travel.booking.repository.HotelRepository;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CityRepository cityRepository;
    private final FlightRepository flightRepository;
    private final HotelRepository hotelRepository;
    private final SampleDataProperties sampleDataProperties;

    @Override
    public void run(String... args) {
        //clearData();
        loadCities();
        loadFlights();
        loadHotels();
    }

    private void clearData() {
        hotelRepository.deleteAll();
        flightRepository.deleteAll();
        cityRepository.deleteAll();
    }

    private void loadCities() {
        if (cityRepository.count() == 0) {
            for (SampleDataProperties.CityData f : sampleDataProperties.getCities()) {
                City city = new City();
                city.setName(f.getName());
                city.setCode(f.getCode());
                cityRepository.save(city);
            }
            System.out.println("Sample cities loaded from properties");
        }
    }

    private void loadFlights() {
        if (flightRepository.count() == 0) {
            for (SampleDataProperties.FlightData f : sampleDataProperties.getFlights()) {
                Flight flight = new Flight();
                flight.setOrigin(cityRepository.findByCode(f.getOrigin()).get());
                flight.setDestination(cityRepository.findByCode(f.getDestination()).get());
                flight.setDepartureTime(f.getDeparture());
                flight.setArrivalTime(f.getArrival());
                flight.setPrice(f.getPrice());
                flightRepository.save(flight);
            }
            System.out.println("Sample flights loaded from properties");
        }
    }

    private void loadHotels() {
        if (hotelRepository.count() == 0) {
            for (SampleDataProperties.HotelData h : sampleDataProperties.getHotels()) {
                Hotel hotel = new Hotel();
                hotel.setName(h.getName());
                hotel.setCity(cityRepository.findByCode(h.getCity()).get());
                hotel.setPricePerNight(h.getPricePerNight());
                hotelRepository.save(hotel);
            }
            System.out.println("Sample hotels loaded from properties");
        }
    }
}
