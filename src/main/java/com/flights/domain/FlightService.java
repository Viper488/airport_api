package com.flights.domain;

import com.flights.dto.*;

import java.util.List;
import java.util.stream.Collectors;

class FlightService{

    protected FlightDetailsDto sumWeightOfBaggageAndCargoOnFlight(List<FlightBaggage> flightBaggiesRepo, List<FlightCargo> flightCargosRepo, List<Baggage> baggiesRepo, List<Cargo> cargosRepo, String weightUnit){

        double weightBaggage = 0;
        double weightCargo = 0;

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

            weightBaggage += weightInUnit(baggage.get(0), weightUnit);
        }

        for (FlightCargoDto flightCargoDto:flightCargos
        ) {
            List<BaggageDto> cargo = cargos
                    .stream()
                    .filter(baggageDto -> baggageDto.getId().equals(flightCargoDto.getCargoId()))
                    .collect(Collectors.toList());

            weightCargo += weightInUnit(cargo.get(0), weightUnit);
        }

        return FlightDetailsDto.builder()
                .baggageWeight(roundToTwo.round(weightBaggage))
                .cargoWeight(roundToTwo.round(weightCargo))
                .totalWeight(roundToTwo.round(weightBaggage+weightCargo))
                .weightUnit(weightUnit)
                .build();
    }

    private double weightInUnit(BaggageDto weight, String unit){

        Converter lbToKgConverter = (weightDouble) -> weightDouble * 0.45359237;
        Converter kgToLbConverter = (weightDouble) -> weightDouble * 2.205;
        double weightInKg = weight.getWeightUnit().equals("kg") ? (double) weight.getWeight() : lbToKgConverter.convertWeightUnits(weight.getWeight());
        double weightInLb = weight.getWeightUnit().equals("kg") ? kgToLbConverter.convertWeightUnits(weight.getWeight()) : (double) weight.getWeight();

        return unit.equals("kg") ? weightInKg : weightInLb;
    }
}
