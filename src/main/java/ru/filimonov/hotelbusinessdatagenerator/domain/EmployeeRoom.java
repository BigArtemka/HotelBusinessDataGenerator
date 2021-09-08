package ru.filimonov.hotelbusinessdatagenerator.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "employeeroom")
@IdClass(EmployeeRoomId.class)
@NoArgsConstructor
@Getter
@Setter
public class EmployeeRoom {
    @Id
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "employeeid")
    private Employee employee;

    @Id
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "roomid")
    private Room room;
}
