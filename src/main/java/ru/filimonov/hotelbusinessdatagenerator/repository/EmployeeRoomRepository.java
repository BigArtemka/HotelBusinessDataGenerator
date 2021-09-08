package ru.filimonov.hotelbusinessdatagenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.filimonov.hotelbusinessdatagenerator.domain.EmployeeRoom;
import ru.filimonov.hotelbusinessdatagenerator.domain.EmployeeRoomId;

public interface EmployeeRoomRepository extends JpaRepository<EmployeeRoom, EmployeeRoomId> {
}
