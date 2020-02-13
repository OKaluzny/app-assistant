package com.kaluzny.assistant.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Oleg Kaluzny
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trucks", schema = "ms_assistant")
public class Truck {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trucks_seq")
    @SequenceGenerator(name = "trucks_seq", sequenceName = "trucks_seq", allocationSize = 1)
    private Long id;

    @Column(name = "create_date")
    @CreatedDate
    private Instant createDate;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "model")
    private String model;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "truck_id", referencedColumnName = "id")
    @OrderBy("id asc")
    private List<Driver> drivers = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Owner owner;
}
