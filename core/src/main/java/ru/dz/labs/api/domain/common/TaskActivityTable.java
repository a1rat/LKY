package ru.dz.labs.api.domain.common;

/**
 * Created by GRamis on 26.06.2015.
 */
public class TaskActivityTable {

    private Long id;
    private String name;
    private String status;
    private String priority;
    private String estimated_time;

    public TaskActivityTable(String name, String status, String priority, String estimated_time) {
        this.name = name;
        this.status = status;
        this.priority = priority;
        this.estimated_time = estimated_time;
    }

    public TaskActivityTable(Long id, String name, String status, String priority, String estimated_time) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.priority = priority;
        this.estimated_time = estimated_time;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getestimated_time() {
        return estimated_time;
    }

    public void setestimated_time(String estimated_time) {
        this.estimated_time = estimated_time;
    }
}
