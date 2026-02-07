package org.travel.booking.service;

import java.util.List;
import org.travel.booking.model.City;

public interface CityService {
    City getByCode(String code);

    List<City> getAllCities();
}
