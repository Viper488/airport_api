package com.flights;

import com.flights.domain.AirportFacade;
import com.flights.dto.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AirportController {

    private final AirportFacade airportFacade;

    public AirportController(AirportFacade airportFacade) {
        this.airportFacade = airportFacade;
    }
    @GetMapping("/api/flights/all")
    List<FlightDto> getFlights() {
        return airportFacade.getFlights();
    }

    @GetMapping("/api/baggies/all")
    List<BaggageDto> getBaggies() {
        return airportFacade.getBaggies();
    }

    @GetMapping("/api/cargos/all")
    List<BaggageDto> getCargos() {
        return airportFacade.getCargos();
    }

    @GetMapping("/api/flight/baggies/{id}")
    List<FlightBaggageDto> getFlightBaggies(@PathVariable("id") Long flightId) {
        return airportFacade.getFlightBaggies(flightId);
    }

    @GetMapping("/api/flight/cargos/{id}")
    List<FlightCargoDto> getFlightCargos(@PathVariable("id") Long flightId) {
        return airportFacade.getFlightCargos(flightId);
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
