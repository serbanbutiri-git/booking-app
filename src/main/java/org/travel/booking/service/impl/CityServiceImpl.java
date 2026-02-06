package org.travel.booking.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.travel.booking.model.City;
import org.travel.booking.repository.CityRepository;
import org.travel.booking.service.CityService;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public City getByCode(String code) {
        return cityRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("City not found: " + code));
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }
}
