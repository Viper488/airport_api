package com.flights.dto;

import lombok.*;

@Builder(toBuilder = true)
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class DepartArrivalDto {
    Integer flightsDeparting;
    Integer flightsArriving;
    Integer piecesDeparting;
    Integer piecesArriving;
}
