package com.flights.dto;

import lombok.*;

@Builder(toBuilder = true)
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AirportDetails {
    Integer flightsDeparting;
    Integer flightsArriving;
    Integer piecesDeparting;
    Integer piecesArriving;
}
