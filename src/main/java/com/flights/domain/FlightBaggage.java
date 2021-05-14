package com.flights.domain;

import com.flights.dto.FlightBaggageDto;
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
@Table(name = "flight_baggage")
class FlightBaggage {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "flight_id")
    private Long flightId;
    @Column(name = "baggage_id")
    private Long baggageId;

    FlightBaggageDto dto() {
        return FlightBaggageDto.builder()
                .id(this.id)
                .flightId(this.flightId)
                .baggageId(this.baggageId)
                .build();
    }
}
