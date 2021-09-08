package ru.filimonov.hotelbusinessdatagenerator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookingServiceId implements Serializable {
    private Integer booking;
    private Integer service;
}
