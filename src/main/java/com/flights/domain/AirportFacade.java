package com.flights.domain;

import com.flights.dto.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
public class AirportFacade {
    private final FlightRepository flightRepository;
    private final BaggageRepository baggageRepository;
    private final CargoRepository cargoRepository;
    private final FlightBaggageRepository flightBaggageRepository;
    private final FlightCargoRepository flightCargoRepository;

    public AirportFacade(FlightRepository flightRepository, BaggageRepository baggageRepository, CargoRepository cargoRepository, FlightBaggageRepository flightBaggageRepository, FlightCargoRepository flightCargoRepository) {
        this.flightRepository = flightRepository;
        this.baggageRepository = baggageRepository;
        this.cargoRepository = cargoRepository;
        this.flightBaggageRepository = flightBaggageRepository;
        this.flightCargoRepository = flightCargoRepository;
    }

    public List<FlightDto> getFlights(){
        return flightRepository
                .findAll()
                .stream()
                .map(Flight::dto)
                .collect(Collectors.toList());
    }

    public List<BaggageDto> getBaggies(){
        return baggageRepository
                .findAll()
                .stream()
                .map(Baggage::dto)
                .collect(Collectors.toList());
    }

    public List<BaggageDto> getCargos(){
        return cargoRepository
                .findAll()
                .stream()
                .map(Cargo::dto)
                .collect(Collectors.toList());
    }

    public List<FlightBaggageDto> getFlightBaggies(Long flightId){
        return flightBaggageRepository
                .findFlightBaggageByFlightId(flightId)
                .stream()
                .map(FlightBaggage::dto)
                .collect(Collectors.toList());
    }

    public List<FlightCargoDto> getFlightCargos(Long flightId){
        return flightCargoRepository
                .findFlightCargoByFlightId(flightId)
                .stream()
                .map(FlightCargo::dto)
                .collect(Collectors.toList());
    }

    public DepartArrivalDto getDeparturesArrivalsFlightsPieces(String codeIATA, String date){
        List<FlightDto> flights = flightRepository.findFlights(codeIATA,date)
                .stream()
                .map(Flight::dto)
                .collect(Collectors.toList());

        List<FlightDto> flightsDeparting = flights
                .stream()
                .filter(flightDto -> flightDto.getDepartureAirportIATACode().equals(codeIATA))
                .collect(Collectors.toList());

        List<FlightDto> flightsArriving = flights
                .stream()
                .filter(flightDto -> flightDto.getArrivalAirportIATACode().equals(codeIATA))
                .collect(Collectors.toList());

        Integer piecesDeparting = sumPiecesFromFlights(flightsDeparting);
        Integer piecesArriving = sumPiecesFromFlights(flightsArriving);

        return DepartArrivalDto.builder()
                .flightsDeparting(flightsDeparting.size())
                .flightsArriving(flightsArriving.size())
                .piecesDeparting(piecesDeparting)
                .piecesArriving(piecesArriving)
                .build();
    }

    private Integer sumPiecesFromFlights(List<FlightDto> flights){
        Integer pieces = 0;
        for (FlightDto flightDto:flights
        ) {
            List<FlightBaggageDto> flightBaggies = flightBaggageRepository.findFlightBaggageByFlightId(flightDto.getFlightId())
                    .stream()
                    .map(FlightBaggage::dto)
                    .collect(Collectors.toList());
            for (FlightBaggageDto flightBaggage:flightBaggies
            ) {
                BaggageDto baggageDto = baggageRepository.findBaggageById(flightBaggage.getBaggageId()).dto();
                pieces += baggageDto.getPieces();
            }
        }

        return pieces;
    }
}
