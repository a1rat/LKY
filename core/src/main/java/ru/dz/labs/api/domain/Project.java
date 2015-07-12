package ru.dz.labs.api.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Айрат on 16.06.2015.
 */
@Entity
@Table(name = "Project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Название проекта
     */
    @Column(nullable = false)
    private String name;

    /**
     * Описание
     */
    @Column
    private String text;

    /**
     * Список задач по проекту
     */
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "project")
    private List<Task> task;

    public Project() {
    }

    public Project(String name, String text, List<Task> task) {
        this.name = name;
        this.text = text;
        this.task = task;
    }

    public Project(String name, String text) {
        this.name = name;
        this.text = text;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Task> getTask() {
        return task;
    }

    public void setTask(List<Task> task) {
        this.task = task;
    }
}
