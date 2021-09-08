package ru.filimonov.hotelbusinessdatagenerator.domain;

import lombok.*;

import javax.persistence.*;
import com.sun.istack.NotNull;
import java.sql.Date;

@Entity
@Table(name = "client")
@NoArgsConstructor
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String firstname, lastname, phone;

    private String address;
    private Date birthdate;

}
