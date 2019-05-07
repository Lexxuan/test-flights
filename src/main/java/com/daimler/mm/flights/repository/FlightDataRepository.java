package com.daimler.mm.flights.repository;

import com.daimler.mm.flights.domain.FlightData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightDataRepository extends JpaRepository<FlightData, String> {

    List<FlightData> findAll();

    FlightData findByFlightNumber(String flightNumber);
}
