package ru.filimonov.hotelbusinessdatagenerator.service;

import org.springframework.stereotype.Service;
import ru.filimonov.hotelbusinessdatagenerator.domain.BookingServiceEntity;
import ru.filimonov.hotelbusinessdatagenerator.domain.BookingServiceId;
import ru.filimonov.hotelbusinessdatagenerator.repository.BookingServiceRepository;

import java.util.List;

@Service
public class BookingServiceService {
    private final BookingServiceRepository bookingServiceRepository;

    public BookingServiceService(BookingServiceRepository bookingServiceRepository) {
        this.bookingServiceRepository = bookingServiceRepository;
    }


    public int count() {
        return (int) bookingServiceRepository.count();
    }

    public void createBookingService(BookingServiceEntity bookingServiceEntity) {
        bookingServiceRepository.save(bookingServiceEntity);
    }

    public BookingServiceEntity findById(BookingServiceId id) {
        return bookingServiceRepository.findById(id).orElse(null);
    }

    public List<BookingServiceEntity> findAll() {
        return bookingServiceRepository.findAll();
    }
}
