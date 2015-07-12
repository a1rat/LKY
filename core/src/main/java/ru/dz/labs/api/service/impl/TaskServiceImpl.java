package ru.dz.labs.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dz.labs.api.dao.TaskRepository;
import ru.dz.labs.api.domain.Task;
import ru.dz.labs.api.service.TaskService;

/**
 * Created by Айрат on 23.06.2015.
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void addTask(Task task) {
        taskRepository.addTask(task);
    }

    @Override
    public Task getTaskById(Long taskId) {
        return taskRepository.getTaskById(taskId);
    }
}
