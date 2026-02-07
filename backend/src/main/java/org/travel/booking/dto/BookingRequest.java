package org.travel.booking.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequest {

    private Long userId;
    private Long bookableId;
}
