package ru.filimonov.hotelbusinessdatagenerator.service;

import org.springframework.stereotype.Service;
import ru.filimonov.hotelbusinessdatagenerator.domain.Employee;
import ru.filimonov.hotelbusinessdatagenerator.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public int count() {
        return (int) employeeRepository.count();
    }

    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
