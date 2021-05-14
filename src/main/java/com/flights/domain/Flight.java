package com.flights.domain;

import com.flights.dto.FlightDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "flights")
class Flight {
    @Id
    @Column(name = "flight_id")
    private Long flightId;
    @Column(name = "flight_number")
    private Integer flightNumber;
    @Column(name = "departure_airport_IATA_code")
    private String departureAirportIATACode;
    @Column(name = "arrival_airport_IATA_code")
    private String arrivalAirportIATACode;
    @Column(name = "departure_date")
    private String departureDate;

    FlightDto dto(){
        return FlightDto.builder()
                .flightId(this.flightId)
                .flightNumber(this.flightNumber)
                .departureAirportIATACode(this.departureAirportIATACode)
                .arrivalAirportIATACode(this.arrivalAirportIATACode)
                .departureDate(this.departureDate)
                .build();
    }
}
