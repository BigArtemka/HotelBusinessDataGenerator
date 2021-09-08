package ru.filimonov.hotelbusinessdatagenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.filimonov.hotelbusinessdatagenerator.domain.Service;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
