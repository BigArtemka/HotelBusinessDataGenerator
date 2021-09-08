package ru.filimonov.hotelbusinessdatagenerator.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "room")
@NoArgsConstructor
@Getter
@Setter
public class Room {

    @Id
    private Integer id;

    @NotNull
    private Integer floor, numofbeds;

    @NotNull
    private String imageurl;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "categoryid")
    private Category category;
}
