package org.travel.booking.service;

import java.util.List;
import org.travel.booking.model.Hotel;

public interface HotelService {

    List<Hotel> getAllHotels();

    Hotel saveHotel(Hotel hotel);
}
