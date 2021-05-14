package com.flights.domain;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface FlightBaggageRepository extends Repository<FlightBaggage, Long> {

    List<FlightBaggage> findFlightBaggageByFlightId(Long flightId);
}
