package com.flights.domain;

import com.flights.dto.FlightBaggageDto;
import com.flights.dto.FlightCargoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "flight_cargo")
class FlightCargo {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "flight_id")
    private Long flightId;
    @Column(name = "cargo_id")
    private Long cargoId;

    FlightCargoDto dto() {
        return FlightCargoDto.builder()
                .id(this.id)
                .flightId(this.flightId)
                .cargoId(this.cargoId)
                .build();
    }
}
