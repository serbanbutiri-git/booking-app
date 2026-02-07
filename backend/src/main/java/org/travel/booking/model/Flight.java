package org.travel.booking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Flight extends Bookable {

    @ManyToOne
    @JoinColumn(name = "origin_id")
    private City origin;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private City destination;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    private BigDecimal price;
}
