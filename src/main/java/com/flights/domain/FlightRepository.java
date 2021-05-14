package com.flights.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository extends Repository<Flight, Long> {
    List<Flight> findAll();

    Flight findFlightByFlightNumberAndDepartureDateContaining(
            @Param("flight_number") Integer flightNumber,
            @Param("departure_date") String date
    );

    @Query(value = "SELECT * FROM flights AS f WHERE (f.departure_airport_IATA_code = ?1 OR f.arrival_airport_IATA_code = ?1) AND f.departure_date LIKE ?2%", nativeQuery = true)
    List<Flight> findFlights(String codeIATA, String date);
}
