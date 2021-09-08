package ru.filimonov.hotelbusinessdatagenerator.service;

import org.springframework.stereotype.Service;
import ru.filimonov.hotelbusinessdatagenerator.domain.EmployeeRoom;
import ru.filimonov.hotelbusinessdatagenerator.domain.EmployeeRoomId;
import ru.filimonov.hotelbusinessdatagenerator.repository.EmployeeRoomRepository;

import java.util.List;

@Service
public class EmployeeRoomService {
    private final EmployeeRoomRepository employeeRoomRepository;

    public EmployeeRoomService(EmployeeRoomRepository employeeRoomRepository) {
        this.employeeRoomRepository = employeeRoomRepository;
    }


    public int count() {
        return (int) employeeRoomRepository.count();
    }

    public void createEmployeeRoom(EmployeeRoom employeeRoom) {
        employeeRoomRepository.save(employeeRoom);
    }

    public EmployeeRoom findById(EmployeeRoomId id) {
        return employeeRoomRepository.findById(id).orElse(null);
    }

    public List<EmployeeRoom> findAll() {
        return employeeRoomRepository.findAll();
    }
}
