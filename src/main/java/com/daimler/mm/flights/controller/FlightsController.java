package com.daimler.mm.flights.controller;

import com.daimler.mm.flights.domain.FlightData;
import com.daimler.mm.flights.exception.FlightNotFoundException;
import com.daimler.mm.flights.service.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FlightsController {

    private FlightsService flightsService;

    private CounterService counterService;

    @Autowired
    public FlightsController(FlightsService flightsService, CounterService counterService) {
        this.flightsService = flightsService;
        this.counterService = counterService;
    }

    @GetMapping("/flights")
    public List<FlightData> getFlightsInfo() {
        counterService.increment("meter.getFlightsInfo");
        return flightsService.getFlights();
    }

    @GetMapping("/flights/{fight_number}")
    public FlightData getFlightInfo(@PathVariable("fight_number") String flightNumber) {
        counterService.increment("meter.getFlight");
        return flightsService.findByFlightNumber(flightNumber);
    }

    @DeleteMapping("/flights/{fight_number}")
    public void deleteFlight(@PathVariable("fight_number") String flightNumber) {
        counterService.increment("meter.deleteFlight");
        flightsService.deleteFlightNumber(flightNumber);
    }

    @PutMapping("/flight")
    public String createOrUpdateFlight(@Valid @RequestBody FlightData flightDataBody) {
        counterService.increment("meter.createOrUpdateFlight");

        FlightData flight;
        try {
            flight = flightsService.findByFlightNumber(flightDataBody.getFlightNumber());
        } catch (FlightNotFoundException e) {
            flight = new FlightData();
        }
        flight.setFlightNumber(flightDataBody.getFlightNumber());
        flight.setAircraft(flightDataBody.getAircraft());
        flight.setDate(flightDataBody.getDate());
        flight.setStart(flightDataBody.getStart());
        flight.setEnd(flightDataBody.getEnd());

        return flightsService.createOrUpdateFlights(flight);
    }
}
