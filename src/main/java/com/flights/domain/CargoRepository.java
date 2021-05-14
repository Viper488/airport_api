package com.flights.domain;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface CargoRepository extends Repository<Cargo, Long> {
    List<Cargo> findAll();
    Cargo findCargoById(Long cargoId);
}
