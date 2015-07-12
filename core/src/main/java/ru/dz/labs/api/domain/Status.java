package ru.dz.labs.api.domain;

import javax.persistence.*;

/**
 * Статус задачи
 *
 * Created by Айрат on 16.06.2015.
 */
@Entity
@Table(name = "Status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Статус
     */
    @Column(nullable = false)
    private String name;

    public Status() {
    }

    public Status(String name) {
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
