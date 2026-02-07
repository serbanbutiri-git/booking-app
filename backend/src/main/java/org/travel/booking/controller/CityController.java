package org.travel.booking.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.travel.booking.model.City;
import org.travel.booking.service.CityService;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class CityController {

    @Autowired
    private final CityService cityService;

    @GetMapping("/{cityCode}")
    public City getCity(@PathVariable String cityCode) {
        return cityService.getByCode(cityCode);
    }

    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }
}
