package ru.filimonov.hotelbusinessdatagenerator.service;

import org.springframework.stereotype.Service;
import ru.filimonov.hotelbusinessdatagenerator.domain.Booking;
import ru.filimonov.hotelbusinessdatagenerator.repository.BookingRepository;

import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }


    public int count() {
        return (int) bookingRepository.count();
    }

    public void createBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    public Booking findById(Integer id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }
}
