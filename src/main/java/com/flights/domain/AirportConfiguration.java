package com.flights.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AirportConfiguration {
    @Bean
    public AirportFacade airportFacade(FlightRepository flightRepository,
                                       BaggageRepository baggageRepository,
                                       CargoRepository cargoRepository,
                                       FlightBaggageRepository flightBaggageRepository,
                                       FlightCargoRepository flightCargoRepository) {
        return new AirportFacade(flightRepository, baggageRepository, cargoRepository, flightBaggageRepository, flightCargoRepository);
    }
}
