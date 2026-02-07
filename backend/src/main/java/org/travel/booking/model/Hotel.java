package org.travel.booking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Hotel extends Bookable {

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    private String name;
    private BigDecimal pricePerNight;
}
