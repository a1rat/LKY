package ru.dz.labs.api.domain;

import javax.persistence.*;

/**
 * Created by Айрат on 16.06.2015.
 */
@Entity
@Table(name = "Priority")
public class Priority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Приоритет
     */
    @Column(nullable = false)
    private String name;

    public Priority() {
    }

    public Priority(String name) {
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
