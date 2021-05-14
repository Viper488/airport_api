package com.flights;

import com.flights.domain.AirportFacade;
import com.flights.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AirportController {


    private static final Logger LOGGER = LoggerFactory.getLogger(AirportController.class);

    private final AirportFacade airportFacade;

    public AirportController(AirportFacade airportFacade) {
        this.airportFacade = airportFacade;
    }

    @GetMapping("/api/flights/details/{number}/{date}/{unit}")
    FlightDetailsDto getFlightDetails(@PathVariable("number") Integer flightNumber, @PathVariable("date") String date, @PathVariable("unit") String weightUnit) {
        return airportFacade.getFlightDetails(flightNumber, date, weightUnit);
    }

    @GetMapping("/api/pieces/{iata}/{date}")
    AirportDetailsDto getPieces(@PathVariable("iata") String codeIATA, @PathVariable("date") String date) {
        return airportFacade.getDeparturesArrivalsFlightsPieces(codeIATA, date);
    }
}
