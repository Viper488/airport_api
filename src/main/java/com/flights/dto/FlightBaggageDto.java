package com.flights.dto;

import lombok.*;

@Builder(toBuilder = true)
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class FlightBaggageDto {
    Long id;
    Long flightId;
    Long baggageId;
}
