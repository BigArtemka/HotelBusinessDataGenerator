package ru.filimonov.hotelbusinessdatagenerator.generator;


import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import lombok.AllArgsConstructor;
import ru.filimonov.hotelbusinessdatagenerator.domain.*;
import ru.filimonov.hotelbusinessdatagenerator.service.*;
import ru.filimonov.hotelbusinessdatagenerator.service.BookingService;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static ru.filimonov.hotelbusinessdatagenerator.generator.DataGenerator.*;

@AllArgsConstructor
public class Generator {
    private final Faker faker = new Faker(new Locale("ru"));

    private final CategoryService categoryService;
    private final BookingService bookingService;
    private final BookingServiceService bookingServiceService;
    private final ClientService clientService;
    private final RoomService roomService;
    private final PositionService positionService;
    private final EmployeeService employeeService;
    private final ServiceService serviceService;
    private final EmployeeRoomService employeeRoomService;
    private final CleaningService cleaningService;

    public void generateBooking(int bookingCount) {
        for (int i = 0; i < bookingCount; i++) {
            Booking booking = new Booking();
            Date arrive = new Date(faker.date().between(faker.date()
                    .past(600, TimeUnit.DAYS), faker.date().future(300, TimeUnit.DAYS)).getTime());
            booking.setArrive(arrive);
            booking.setCheckout(new Date(faker.
                    date().future(30, TimeUnit.DAYS, new java.util.Date(arrive.getTime())).getTime()));
            booking.setClient(clientService.findAll().get(faker.number().numberBetween(0, clientService.count())));
            booking.setRoom(roomService.findAll().get(faker.number().numberBetween(0, roomService.count())));
            bookingService.createBooking(booking);
        }
    }

    public void generateCategory(int categoryCount) {
        for (int i = 0; i < categoryCount; i++) {
            Category category = new Category();
            category.setName(faker.ancient().god());
            category.setDescription(generateText());
            category.setPrice(generatePrice());
            categoryService.createCategory(category);
        }
    }

    public void generatePosition(int positionCount) {
        for (int i = 0; i < positionCount; i++) {
            Position position = new Position();
            position.setName(faker.job().position());
            position.setSalary(generatePrice());
            positionService.createPosition(position);
        }
    }

    public void generateClient(int clientCount) {
        for (int i = 0; i < clientCount; i++) {
            Client client = new Client();
            Name name = faker.name();
            client.setFirstname(name.firstName());
            client.setLastname(name.lastName());
            client.setBirthdate(new Date(faker.date().birthday().getTime()));
            client.setAddress(faker.address().fullAddress());
            client.setPhone(generatePhone());
            clientService.createClient(client);
        }
    }

    public void generateEmployee(int employeeCount) {
        for (int i = 0; i < employeeCount; i++) {
            Employee employee = new Employee();
            Name name = faker.name();
            employee.setFirstname(name.firstName());
            employee.setLastname(name.lastName());
            employee.setBirthdate(new Date(faker.date().birthday().getTime()));
            employee.setPhone(generatePhone());
            employee.setPosition(positionService.findAll()
                    .get(faker.number().numberBetween(0, positionService.count())));
            employeeService.createEmployee(employee);
        }
    }

    public void generateService(int serviceCount) {
        for (int i = 0; i < serviceCount; i++) {
            Service service = new Service();
            service.setName(faker.commerce().productName());
            service.setPrice(generatePrice());
            serviceService.createService(service);
        }
    }

    public void generateRoom(int roomCount) throws IOException {
        for (int i = 0; i < roomCount; i++) {
            Room room = new Room();
            room.setId(faker.number().numberBetween(100, 999));
            room.setFloor(room.getId() / 100);
            room.setNumofbeds(faker.number().numberBetween(1, 10));
            room.setImageurl(generateImageUrl());
            room.setCategory(categoryService.findAll()
                    .get(faker.number().numberBetween(0, categoryService.count())));
            roomService.createRoom(room);
        }
    }

    public void generateCleaning(int cleaningCount) {
        for (int i = 0; i < cleaningCount; i++) {
            Cleaning cleaning = new Cleaning();
            cleaning.setEmployee(employeeService.findAll()
                    .get(faker.number().numberBetween(0, employeeService.count())));
            cleaning.setRoom(roomService.findAll()
                    .get(faker.number().numberBetween(0, roomService.count())));
            Time[] interval = generateTimeInterval();
            cleaning.setStarttime(interval[0]);
            cleaning.setEndtime(interval[1]);
            cleaningService.createCleaning(cleaning);
        }
    }

    public void generateEmployeeRoom(int count) {
        for (int i = 0; i < count; i++) {
            EmployeeRoom employeeRoom = new EmployeeRoom();
            employeeRoom.setEmployee(employeeService.findAll()
                    .get(faker.number().numberBetween(0, employeeService.count())));
            employeeRoom.setRoom(roomService.findAll()
                    .get(faker.number().numberBetween(0, roomService.count())));
            employeeRoomService.createEmployeeRoom(employeeRoom);

        }
    }

    public void generateBookingService(int count) {
        for (int i = 0; i < count; i++) {
            BookingServiceEntity bookingServiceEntity = new BookingServiceEntity();
            bookingServiceEntity.setBooking(bookingService.findAll()
                    .get(faker.number().numberBetween(0, bookingService.count())));
            bookingServiceEntity.setService(serviceService.findAll()
                    .get(faker.number().numberBetween(0, serviceService.count())));
            bookingServiceService.createBookingService(bookingServiceEntity);
        }
    }
}


