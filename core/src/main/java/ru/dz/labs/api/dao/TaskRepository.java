package ru.dz.labs.api.dao;

import ru.dz.labs.api.domain.Task;

/**
 * Created by Айрат on 19.06.2015.
 */
public interface TaskRepository {

    void addTask(Task task);

    Task getTaskById(Long taskId);
}
