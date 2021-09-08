package ru.filimonov.hotelbusinessdatagenerator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeRoomId implements Serializable {
    private Integer employee;
    private Integer room;
}
