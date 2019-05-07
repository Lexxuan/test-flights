package com.daimler.mm.flights.service;

import com.daimler.mm.flights.domain.FlightData;
import com.daimler.mm.flights.exception.FlightDataValidException;
import com.daimler.mm.flights.exception.FlightNotFoundException;
import com.daimler.mm.flights.repository.FlightDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class FlightsService {

    private final List<String> aircraftType = Arrays.asList("DHC-8-400", "Boeing B737", "Airbus A340");

    @Qualifier("flightDataRepository")
    private final FlightDataRepository flightDataRepository;

    @Autowired
    public FlightsService(FlightDataRepository flightDataRepository) {
        this.flightDataRepository = flightDataRepository;
    }

    public List<FlightData> getFlights() {
        return flightDataRepository.findAll();
    }

    public String createOrUpdateFlights(FlightData flightData) {

        if (!aircraftType.contains(flightData.getAircraft())) {
            throw new FlightDataValidException("No such type of aircrafts.");
        }

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            format.parse(flightData.getDate());
        } catch (ParseException e) {
            throw new FlightDataValidException("Not valid date format for ISO_8601 (e.g.: 2019-05-01T00:00:00Z).");
        }

        log.info("Updating flightNumber: {}", flightData.getFlightNumber());
        flightDataRepository.save(flightData);
        return ("Location: /v1/flights/" + flightData.getFlightNumber());
    }

    public FlightData findByFlightNumber(String flightNumber) {
        if (!StringUtils.isEmpty(flightNumber)) {
            FlightData flightData = flightDataRepository.findByFlightNumber(flightNumber);
            if (flightData == null) {
                log.info("No flight with flightNumber: {} found", flightNumber);
                throw new FlightNotFoundException("Flight not found.");
            }
            return flightData;
        } else {
            log.info("No valid arguments found for flight");
            throw new IllegalArgumentException("FlightNumber is null or empty - It must not be null or empty.");
        }
    }

    public void deleteFlightNumber(String flightNumber) {
        if (!StringUtils.isEmpty(flightNumber)) {
            FlightData flightData = flightDataRepository.findByFlightNumber(flightNumber);
            if (flightData == null) {
                log.info("No flight with flightNumber: {} found", flightNumber);
                throw new FlightNotFoundException("Flight: " + flightNumber + " not found.");
            }
            flightDataRepository.delete(flightNumber);
        }
    }
}
