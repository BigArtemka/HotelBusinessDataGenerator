package ru.filimonov.hotelbusinessdatagenerator.domain;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "bookingservice")
@IdClass(BookingServiceId.class)
@NoArgsConstructor
@Getter
@Setter
public class BookingServiceEntity {

    @Id
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "bookingid")
    private Booking booking;

    @Id
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "serviceid")
    private Service service;
}
