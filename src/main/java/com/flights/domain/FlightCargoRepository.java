package com.flights.domain;

import org.springframework.data.repository.Repository;

import java.util.List;

interface FlightCargoRepository extends Repository<FlightCargo, Long> {

    List<FlightCargo> findAll();
    List<FlightCargo> findFlightCargoByFlightId(Long flightId);
}
