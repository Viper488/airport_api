package com.flights.dto;

import lombok.*;

@Builder(toBuilder = true)
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BaggageDto {
    Long id;
    Integer weight;
    String weightUnit;
    Integer pieces;
}
