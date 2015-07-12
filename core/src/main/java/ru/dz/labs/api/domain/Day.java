package ru.dz.labs.api.domain;

import javax.persistence.*;

/**
 * Created by Айрат on 16.06.2015.
 */
@Entity
@Table(name = "Day")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * День недели
     */
    @Column(nullable = false)
    private String name;

    public Day() {
    }

    public Day(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
