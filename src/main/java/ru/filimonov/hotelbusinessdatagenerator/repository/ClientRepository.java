package ru.filimonov.hotelbusinessdatagenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.filimonov.hotelbusinessdatagenerator.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
