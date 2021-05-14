package com.flights;

import com.flights.domain.AirportFacade;
import com.flights.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
class AirportController {


    private static final Logger LOGGER = LoggerFactory.getLogger(AirportController.class);

    private final AirportFacade airportFacade;

    public AirportController(AirportFacade airportFacade) {
        this.airportFacade = airportFacade;
    }

    @CrossOrigin
    @GetMapping("/api/flights/details")
    FlightDetailsDto getFlightDetails(@RequestParam("number") Integer flightNumber, @RequestParam("date") String date, @RequestParam("unit") String weightUnit) {
        return airportFacade.getFlightDetails(flightNumber, date, weightUnit);
    }

    @CrossOrigin
    @GetMapping("/api/airport/details")
    AirportDetailsDto getPieces(@RequestParam("iata") String codeIATA, @RequestParam("date") String date) {
        return airportFacade.getDeparturesArrivalsFlightsPieces(codeIATA, date);
    }
}
