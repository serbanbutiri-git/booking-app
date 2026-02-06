package org.travel.booking.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.travel.booking.model.City;
import org.travel.booking.model.Hotel;
import org.travel.booking.repository.HotelRepository;
import org.travel.booking.service.CityService;
import org.travel.booking.service.HotelService;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final CityService cityService;

    @Override
    public List<Hotel> searchHotels(String cityCode) {
        City city = cityService.getByCode(cityCode);
        return hotelRepository.findByCity(city);
    }
}
