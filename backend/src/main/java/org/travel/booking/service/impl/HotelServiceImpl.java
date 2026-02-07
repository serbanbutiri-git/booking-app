package org.travel.booking.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
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
    @Cacheable("hotels")
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    @CacheEvict(value = "hotels", allEntries = true)
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }
}
