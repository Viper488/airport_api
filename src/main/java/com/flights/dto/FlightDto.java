package com.flights.dto;

import lombok.*;

@Builder(toBuilder = true)
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {
    Long flightId;
    Integer flightNumber;
    String departureAirportIATACode;
    String arrivalAirportIATACode;
    String departureDate;
}
