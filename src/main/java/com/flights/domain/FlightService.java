package com.flights.domain;

import com.flights.dto.*;

import java.util.List;
import java.util.stream.Collectors;

class FlightService{

    protected FlightDetailsDto sumWeightOfBaggageAndCargoOnFlight(List<FlightBaggage> flightBaggiesRepo, List<FlightCargo> flightCargosRepo, List<Baggage> baggiesRepo, List<Cargo> cargosRepo, String weightUnit){

        double weightBaggage = 0;
        double weightCargo = 0;

        Converter lbToKgConverter = (weight) -> weight * 0.4359237;
        Converter kgToLbConverter = (weight) -> weight * 2.205;
        Round roundToTwo = (digit) -> Math.round(digit * 100.0) / 100.0;

        List<FlightBaggageDto> flightBaggies = flightBaggiesRepo
                .stream()
                .map(FlightBaggage::dto)
                .collect(Collectors.toList());

        List<FlightCargoDto> flightCargos = flightCargosRepo
                .stream()
                .map(FlightCargo::dto)
                .collect(Collectors.toList());

        List<BaggageDto> baggies = baggiesRepo
                .stream()
                .map(Baggage::dto)
                .collect(Collectors.toList());

        List<BaggageDto> cargos = cargosRepo
                .stream()
                .map(Cargo::dto)
                .collect(Collectors.toList());

        for (FlightBaggageDto flightBaggageDto:flightBaggies
        ) {
            List<BaggageDto> baggage = baggies
                    .stream()
                    .filter(baggageDto -> baggageDto.getId().equals(flightBaggageDto.getBaggageId()))
                    .collect(Collectors.toList());

            double weightInKg = baggage.get(0).getWeightUnit().equals("kg") ? (double) baggage.get(0).getWeight() : lbToKgConverter.convertWeightUnits(baggage.get(0).getWeight());
            double weightInLb = baggage.get(0).getWeightUnit().equals("kg") ? kgToLbConverter.convertWeightUnits(baggage.get(0).getWeight()) : (double) baggage.get(0).getWeight();

            weightBaggage += weightUnit.equals("kg") ? weightInKg : weightInLb;
        }

        for (FlightCargoDto flightCargoDto:flightCargos
        ) {
            List<BaggageDto> cargo = cargos
                    .stream()
                    .filter(baggageDto -> baggageDto.getId().equals(flightCargoDto.getCargoId()))
                    .collect(Collectors.toList());

            double weightInKg = cargo.get(0).getWeightUnit().equals("kg") ? (double) cargo.get(0).getWeight() : lbToKgConverter.convertWeightUnits(cargo.get(0).getWeight());
            double weightInLb = cargo.get(0).getWeightUnit().equals("kg") ? kgToLbConverter.convertWeightUnits(cargo.get(0).getWeight()) : (double) cargo.get(0).getWeight();

            weightCargo += weightUnit.equals("kg") ? weightInKg : weightInLb;
        }

        return FlightDetailsDto.builder()
                .baggageWeight(roundToTwo.round(weightBaggage))
                .cargoWeight(roundToTwo.round(weightCargo))
                .totalWeight(roundToTwo.round(weightBaggage+weightCargo))
                .weightUnit(weightUnit)
                .build();
    }
}
