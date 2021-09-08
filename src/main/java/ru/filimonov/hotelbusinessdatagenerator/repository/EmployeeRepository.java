package ru.filimonov.hotelbusinessdatagenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.filimonov.hotelbusinessdatagenerator.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
