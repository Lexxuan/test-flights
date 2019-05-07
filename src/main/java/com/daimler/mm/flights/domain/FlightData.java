package com.daimler.mm.flights.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@Table(name = "flight_data")
public class FlightData {
    @Id
    private String flightNumber;

    @NotNull
    private String start;

    @NotNull
    private String end;

    @NotNull
    private String date;

    @NotNull
    private String aircraft;
}
