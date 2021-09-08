package ru.filimonov.hotelbusinessdatagenerator;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;
import ru.filimonov.hotelbusinessdatagenerator.generator.Generator;
import ru.filimonov.hotelbusinessdatagenerator.service.*;

@ConfigurationProperties(prefix = "demo")
@Validated
public class AppProperties {

    @Autowired
    CategoryService categoryService;
    @Autowired
    BookingServiceService bookingServiceService;
    @Autowired
    BookingService bookingService;
    @Autowired
    ClientService clientService;
    @Autowired
    RoomService roomService;
    @Autowired
    PositionService positionService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    CleaningService cleaningService;
    @Autowired
    ServiceService serviceService;
    @Autowired
    EmployeeRoomService employeeRoomService;

    @Value("${demo.category}")
    Integer category;
    @Value("${demo.booking}")
    Integer booking;
    @Value("${demo.position}")
    Integer position;
    @Value("${demo.client}")
    Integer client;
    @Value("${demo.employee}")
    Integer employee;
    @Value("${demo.service}")
    Integer service;
    @Value("${demo.room}")
    Integer room;
    @Value("${demo.cleaning}")
    Integer cleaning;
    @Value("${demo.bookingService}")
    Integer bookingServiceCount;
    @Value("${demo.employeeRoom}")
    Integer employeeRoom;


    @SneakyThrows
    public void generate() {
        Generator generator = new Generator(categoryService, bookingService, bookingServiceService,
                clientService, roomService, positionService, employeeService, serviceService, employeeRoomService, cleaningService);
        generator.generatePosition(position);
        generator.generateCategory(category);
        generator.generateService(service);
        generator.generateClient(client);
        generator.generateEmployee(employee);
        generator.generateRoom(room);
        generator.generateBooking(booking);
        generator.generateCleaning(cleaning);
        generator.generateBookingService(bookingServiceCount);
        generator.generateEmployeeRoom(employeeRoom);
    }

}
