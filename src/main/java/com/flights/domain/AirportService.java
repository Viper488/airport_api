package com.flights.domain;

import com.flights.dto.AirportDetailsDto;
import com.flights.dto.BaggageDto;
import com.flights.dto.FlightBaggageDto;
import com.flights.dto.FlightDto;

import java.util.List;
import java.util.stream.Collectors;

class AirportService {
    protected AirportDetailsDto getDeparturesArrivalsPieces(String codeIATA, List<Flight> flightsRepo, List<FlightBaggage> flightBaggiesRepo, List<Baggage> baggiesRepo){

        List<FlightDto> flightsDeparting = flightsRepo
                .stream()
                .map(Flight::dto)
                .filter(flightDto -> flightDto.getDepartureAirportIATACode().equals(codeIATA))
                .collect(Collectors.toList());

        List<FlightDto> flightsArriving = flightsRepo
                .stream()
                .map(Flight::dto)
                .filter(flightDto -> flightDto.getArrivalAirportIATACode().equals(codeIATA))
                .collect(Collectors.toList());


        Integer piecesDeparting = sumPiecesFromFlight(flightsDeparting, flightBaggiesRepo, baggiesRepo);
        Integer piecesArriving = sumPiecesFromFlight(flightsArriving, flightBaggiesRepo, baggiesRepo);

        return AirportDetailsDto.builder()
                .flightsDeparting(flightsDeparting.size())
                .flightsArriving(flightsArriving.size())
                .piecesDeparting(piecesDeparting)
                .piecesArriving(piecesArriving)
                .build();
    }

    private Integer sumPiecesFromFlight(List<FlightDto> flights, List<FlightBaggage> flightBaggiesRepo, List<Baggage> baggiesRepo){
        Integer pieces = 0;

        for (FlightDto flightDto:flights
        ) {
            List<FlightBaggageDto> flightBaggies = flightBaggiesRepo
                    .stream()
                    .map(FlightBaggage::dto)
                    .filter(flightBaggageDto -> flightBaggageDto.getFlightId().equals(flightDto.getFlightId()))
                    .collect(Collectors.toList());

            for (FlightBaggageDto flightBaggageDto:flightBaggies
            ) {
                List<BaggageDto> baggies = baggiesRepo
                        .stream()
                        .map(Baggage::dto)
                        .filter(baggageDto -> baggageDto.getId().equals(flightBaggageDto.getBaggageId()))
                        .collect(Collectors.toList());

                pieces += baggies.get(0).getPieces();
            }
        }

        return pieces;
    }
}
