package org.travel.booking.service;

import java.util.List;
import org.travel.booking.model.Hotel;

public interface HotelService {

    List<Hotel> searchHotels(String cityCode);
}
