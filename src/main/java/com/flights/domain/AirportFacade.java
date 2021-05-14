package com.flights.domain;

import com.flights.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class AirportFacade {


    private static final Logger LOGGER = LoggerFactory.getLogger(AirportFacade.class);

    private final FlightRepository flightRepository;
    private final BaggageRepository baggageRepository;
    private final CargoRepository cargoRepository;
    private final FlightBaggageRepository flightBaggageRepository;
    private final FlightCargoRepository flightCargoRepository;
    private final AirportService airportService;
    private final FlightService flightService;

    public AirportFacade(FlightRepository flightRepository, BaggageRepository baggageRepository, CargoRepository cargoRepository, FlightBaggageRepository flightBaggageRepository, FlightCargoRepository flightCargoRepository, AirportService airportService, FlightService flightService) {
        this.flightRepository = flightRepository;
        this.baggageRepository = baggageRepository;
        this.cargoRepository = cargoRepository;
        this.flightBaggageRepository = flightBaggageRepository;
        this.flightCargoRepository = flightCargoRepository;
        this.airportService = airportService;
        this.flightService = flightService;
    }

    public AirportDetailsDto getDeparturesArrivalsFlightsPieces(String codeIATA, String date){
        List<Flight> flights = flightRepository.findFlights(codeIATA,date);
        List<FlightBaggage> flightBaggies = flightBaggageRepository.findAll();
        List<Baggage> baggies = baggageRepository.findAll();

        return airportService.getDeparturesArrivalsPieces(codeIATA, flights, flightBaggies, baggies);
    }

    public FlightDetailsDto getFlightDetails(Integer flightNumber, String date, String weightUnit){

        try {
            FlightDto flightDto = flightRepository.findFlightByFlightNumberAndDepartureDateContaining(flightNumber, date).dto();
            List<FlightBaggage> flightBaggies = flightBaggageRepository.findFlightBaggageByFlightId(flightDto.getFlightId());
            List<FlightCargo> flightCargos = flightCargoRepository.findFlightCargoByFlightId(flightDto.getFlightId());
            List<Baggage> baggies = baggageRepository.findAll();
            List<Cargo> cargos = cargoRepository.findAll();

            LOGGER.info(flightDto.toString());

            return flightService.sumWeightOfBaggageAndCargoOnFlight(flightBaggies, flightCargos, baggies, cargos, weightUnit);
        }
        catch (NullPointerException nullPointerException) {

            LOGGER.info("NULL");
            return FlightDetailsDto.builder().build();
        }
    }
}
