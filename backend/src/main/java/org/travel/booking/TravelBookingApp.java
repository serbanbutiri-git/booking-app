package org.travel.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TravelBookingApp {

    public static void main(String[] args) {
        SpringApplication.run(TravelBookingApp.class, args);
    }

}
