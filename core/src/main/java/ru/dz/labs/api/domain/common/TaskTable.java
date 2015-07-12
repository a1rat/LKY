package ru.dz.labs.api.domain.common;

/**
 * Created by GRamis on 26.06.2015.
 */
public class TaskTable {

    private Long id;
    private String task_name;
    private Long monday = 0L;
    private Long tuesday = 0L;
    private Long wednesday = 0L;
    private Long thursday = 0L;
    private Long friday = 0L;
    private Long saturday = 0L;
    private Long sunday = 0L;
    private Long sum = monday + tuesday + wednesday + thursday + friday + saturday + sunday;

    public TaskTable(Long id, String task_name, Long monday, Long tuesday, Long wednesday, Long thursday, Long friday, Long saturday, Long sunday) {
        this.id = id;
        this.task_name = task_name;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
    }

    public TaskTable() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public Long getMonday() {
        return monday;
    }

    public void setMonday(Long monday) {
        this.sum += monday - this.monday;
        this.monday = monday;
    }

    public Long getTuesday() {
        return tuesday;
    }

    public void setTuesday(Long tuesday) {
        this.sum += tuesday - this.tuesday;
        this.tuesday = tuesday;
    }

    public Long getWednesday() {
        return wednesday;
    }

    public void setWednesday(Long wednesday) {
        this.sum += wednesday - this.wednesday;
        this.wednesday = wednesday;
    }

    public Long getThursday() {
        return thursday;
    }

    public void setThursday(Long thursday) {
        this.sum += thursday - this.thursday;
        this.thursday = thursday;
    }

    public Long getFriday() {
        return friday;
    }

    public void setFriday(Long friday) {
        this.sum += friday - this.friday;
        this.friday = friday;
    }

    public Long getSaturday() {
        return saturday;
    }

    public void setSaturday(Long saturday) {
        this.sum += saturday - this.saturday;
        this.saturday = saturday;
    }

    public Long getSunday() {
        return sunday;
    }

    public void setSunday(Long sunday) {
        this.sum += sunday - this.sunday;
        this.sunday = sunday;
    }

    public Long getSum() {
        return  monday + tuesday + wednesday + thursday + friday + saturday + sunday;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }
}
