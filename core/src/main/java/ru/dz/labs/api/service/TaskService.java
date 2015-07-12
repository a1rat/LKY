package ru.dz.labs.api.service;

import ru.dz.labs.api.domain.Task;

/**
 * Created by Айрат on 23.06.2015.
 */
public interface TaskService {

    void addTask(Task task);

    /**
     * Получить задачу по id
     * @param taskId
     * @return
     */
    Task getTaskById(Long taskId);
}
