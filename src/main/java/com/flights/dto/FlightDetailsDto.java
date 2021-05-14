package com.flights.dto;

import lombok.*;

@Builder(toBuilder = true)
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class FlightDetailsDto {
    Double cargoWeight;
    Double baggageWeight;
    Double totalWeight;
    String weightUnit;
}
