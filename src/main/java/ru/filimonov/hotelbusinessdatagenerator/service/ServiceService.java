package ru.filimonov.hotelbusinessdatagenerator.service;

import ru.filimonov.hotelbusinessdatagenerator.domain.Service;
import ru.filimonov.hotelbusinessdatagenerator.repository.ServiceRepository;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService {
    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }


    public int count() {
        return (int) serviceRepository.count();
    }

    public void createService(Service service) {
        serviceRepository.save(service);
    }

    public Service findById(Integer id) {
        return serviceRepository.findById(id).orElse(null);
    }

    public List<Service> findAll() {
        return serviceRepository.findAll();
    }
}
