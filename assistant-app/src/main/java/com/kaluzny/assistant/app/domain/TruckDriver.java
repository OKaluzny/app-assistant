package com.kaluzny.assistant.app.domain;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Oleg Kaluzny
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "truck_drivers", schema = "ms_assistant")
public class TruckDriver {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "truck_drivers_seq")
    @SequenceGenerator(name = "truck_drivers_seq", sequenceName = "truck_drivers_seq", allocationSize = 1)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}
