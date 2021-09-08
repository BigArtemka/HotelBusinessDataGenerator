package ru.filimonov.hotelbusinessdatagenerator.service;

import org.springframework.stereotype.Service;
import ru.filimonov.hotelbusinessdatagenerator.domain.Room;
import ru.filimonov.hotelbusinessdatagenerator.repository.RoomRepository;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    public int count() {
        return (int) roomRepository.count();
    }

    public void createRoom(Room room) {
        roomRepository.save(room);
    }

    public Room findById(Integer id) {
        return roomRepository.findById(id).orElse(null);
    }

    public List<Room> findAll() {
        return roomRepository.findAll();
    }
}
