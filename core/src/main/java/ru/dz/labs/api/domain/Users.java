package ru.dz.labs.api.domain;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Айрат on 16.06.2015.
 */
@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Роль
     */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    /**
     * Имя
     */
    @Column(nullable = false)
    private String name;

    /**
     * Логин
     */
    @Column(nullable = false)
    private String login;

    /**
     * Пароль
     */
    @Column(nullable = false)
    private String password;

    /**
     * Время работы
     */
    @Column
    private String workink_hours;

    /**
     * Расписание
     */
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Schedule> schedule;

    /**
     * Список задач
     */
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "user_task")
    private List<Task> tasks;

    public Users() {
    }

    public Users(Role role, String name, String login, String password) {
        this.role = role;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWorkink_hours() {
        return workink_hours;
    }

    public void setWorkink_hours(String workink_hours) {
        this.workink_hours = workink_hours;
    }

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
