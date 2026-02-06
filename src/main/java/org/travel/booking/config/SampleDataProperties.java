package org.travel.booking.config;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "sample-data")
@Getter
@Setter
public class SampleDataProperties {

    private List<CityData> cities;
    private List<FlightData> flights;
    private List<HotelData> hotels;

    @Getter
    @Setter
    public static class CityData {
        private String name;
        private String code;
    }

    @Getter
    @Setter
    public static class FlightData {
        private String origin;
        private String destination;
        private LocalDateTime departure;
        private LocalDateTime arrival;
        private BigDecimal price;
    }

    @Getter
    @Setter
    public static class HotelData {
        private String name;
        private String city;
        private BigDecimal pricePerNight;
    }
}
