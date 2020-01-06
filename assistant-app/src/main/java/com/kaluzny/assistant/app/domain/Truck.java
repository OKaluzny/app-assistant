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
@Table(name = "ms_trucks", schema = "ms_assistant")
public class Truck {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String manufacturer;
    private String model;
}
