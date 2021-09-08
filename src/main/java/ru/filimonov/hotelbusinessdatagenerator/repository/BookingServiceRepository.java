package ru.filimonov.hotelbusinessdatagenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.filimonov.hotelbusinessdatagenerator.domain.BookingServiceEntity;
import ru.filimonov.hotelbusinessdatagenerator.domain.BookingServiceId;

public interface BookingServiceRepository extends JpaRepository<BookingServiceEntity, BookingServiceId> {
}
