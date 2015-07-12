package ru.dz.labs.api.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Айрат on 16.06.2015.
 */
@Entity
@Table(name = "Task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * id Менеджера
     */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Users manager;

    /**
     * id Исполнителя
     */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "dev_id")
    private Users user_task;

    /**
     * Проект
     */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    /**
     * Статус задачи
     */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private Status status;

    /**
     * Родительская задача
     */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id_parent")
    private Task task;

    /**
     * Приоритет
     */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "priority_id")
    private Priority priority;

    /**
     * Название
     */
    @Column()
    private String name;

    /**
     * Описание
     */
    @Column
    private String description;

    /**
     * Планируемая дата начала
     */
    @Column
    private Date plan_date;

    /**
     * Изначально запланированное время на задачу (менеджером)
     */
    @Column
    private Date estimated_time;

    /**
     * Время затраченное на задание
     */
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "task")
    private List<ExpendedTime> expended_time;

    /**
     * Планируемое время работы (разработчиком)
     */
    @Column
    private Date due_time;

    /**
     * Дата начала
     */
    @Column
    private Date start_date;

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "task")
    private List<Comment> comments;

    public Task(String name, Status status, Priority priority, Date estimated_time) {
        this.name = name;
        this.status = status;
        this.priority = priority;
        this.estimated_time = estimated_time;
    }

    public Task(){}

    public Task(Users manager, Users user_task, Project project, Status status, Task task, Priority priority, String name, String description, Date plan_date, Date estimated_time, List<ExpendedTime> expended_time, Date due_time, Date start_date, List<Comment> comments) {
        this.manager = manager;
        this.user_task = user_task;
        this.project = project;
        this.status = status;
        this.task = task;
        this.priority = priority;
        this.name = name;
        this.description = description;
        this.plan_date = plan_date;
        this.estimated_time = estimated_time;
        this.expended_time = expended_time;
        this.due_time = due_time;
        this.start_date = start_date;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getManager() {
        return manager;
    }

    public void setManager(Users manager) {
        this.manager = manager;
    }

    public Users getUser_task() {
        return user_task;
    }

    public void setUser_task(Users user_task) {
        this.user_task = user_task;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPlan_date() {
        return plan_date;
    }

    public void setPlan_date(Date plan_date) {
        this.plan_date = plan_date;
    }

    public Date getEstimated_time() {
        return estimated_time;
    }

    public void setEstimated_time(Date estimated_time) {
        this.estimated_time = estimated_time;
    }

    public List<ExpendedTime> getExpended_time() {
        return expended_time;
    }

    public void setExpended_time(List<ExpendedTime> expended_time) {
        this.expended_time = expended_time;
    }

    public Date getDue_time() {
        return due_time;
    }

    public void setDue_time(Date due_time) {
        this.due_time = due_time;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
