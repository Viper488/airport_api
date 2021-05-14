package com.flights.domain;

import com.flights.dto.BaggageDto;
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
@Table(name = "cargo")
public class Cargo {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "weight")
    private Integer weight;
    @Column(name = "weight_unit")
    private String  weightUnit;
    @Column(name = "pieces")
    private Integer pieces;

    BaggageDto dto() {
        return BaggageDto.builder()
                .id(this.id)
                .weight(toBuilder().weight)
                .weightUnit(this.weightUnit)
                .pieces(this.pieces)
                .build();
    }
}
