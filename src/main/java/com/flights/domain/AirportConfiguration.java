package com.flights.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AirportConfiguration {
    @Bean
    AirportFacade airportFacade(FlightRepository flightRepository,
                                       BaggageRepository baggageRepository,
                                       CargoRepository cargoRepository,
                                       FlightBaggageRepository flightBaggageRepository,
                                       FlightCargoRepository flightCargoRepository) {

        AirportService airportService = new AirportService();
        FlightService flightService = new FlightService();
        return new AirportFacade(
                flightRepository,
                baggageRepository,
                cargoRepository,
                flightBaggageRepository,
                flightCargoRepository,
                airportService,
                flightService);
    }
}
