package ru.dz.labs.api.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Время затраченное на задание
 *
 * Created by GRamis on 26.06.2015.
 */
@Entity
@Table(name = "ExpendedTime")
public class ExpendedTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Задача за которое списывается время
     */
    @JoinColumn(name = "task_id")
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Task task;

    /**
     * Разработчик который списал время
     */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users developer;

    /**
     * День за который списывается время на задачу
     */
    @Column
    private Date day;

    /**
     * Количество часов списываемое за указанный день
     */
    @Column
    private Long time;

    public ExpendedTime() {
    }

    public ExpendedTime(Long id, Task task, Users developer, Date day, Long time) {
        this.id = id;
        this.task = task;
        this.developer = developer;
        this.day = day;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Users getDeveloper() {
        return developer;
    }

    public void setDeveloper(Users developer) {
        this.developer = developer;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
