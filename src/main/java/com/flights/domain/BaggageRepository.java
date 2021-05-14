package com.flights.domain;

import org.hibernate.mapping.Bag;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface BaggageRepository extends Repository<Baggage, Long> {
    List<Baggage> findAll();
    Baggage findBaggageById(Long baggageId);
}
