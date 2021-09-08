package ru.filimonov.hotelbusinessdatagenerator.service;

import org.springframework.stereotype.Service;
import ru.filimonov.hotelbusinessdatagenerator.domain.Cleaning;
import ru.filimonov.hotelbusinessdatagenerator.repository.CleaningRepository;

import java.util.List;

@Service
public class CleaningService {
    private final CleaningRepository cleaningRepository;

    public CleaningService(CleaningRepository cleaningRepository) {
        this.cleaningRepository = cleaningRepository;
    }


    public int count() {
        return (int) cleaningRepository.count();
    }

    public void createCleaning(Cleaning cleaning) {
        cleaningRepository.save(cleaning);
    }

    public Cleaning findById(Integer id) {
        return cleaningRepository.findById(id).orElse(null);
    }

    public List<Cleaning> findAll() {
        return cleaningRepository.findAll();
    }
}
