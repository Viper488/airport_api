package com.flights;

import com.flights.domain.AirportFacade;
import com.flights.dto.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AirportController {

    private final AirportFacade airportFacade;

    public AirportController(AirportFacade airportFacade) {
        this.airportFacade = airportFacade;
    }

    @GetMapping("/api/flights/details/{number}/{date}")
    FlightDetailsDto getFlightDetails(@PathVariable("number") Integer flightNumber, @PathVariable("date") String date) {
        return airportFacade.getFlightDetails(flightNumber, date);
    }

    @GetMapping("/api/pieces/{iata}/{date}")
    DepartArrivalDto getPieces(@PathVariable("iata") String codeIATA, @PathVariable("date") String date) {
        return airportFacade.getDeparturesArrivalsFlightsPieces(codeIATA, date);
    }
}
