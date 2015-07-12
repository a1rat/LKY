package ru.dz.labs.api.service;

import ru.dz.labs.api.domain.Project;
import ru.dz.labs.api.domain.Task;

import java.util.List;

/**
 * Created by Айрат on 23.06.2015.
 */
public interface ProjectService {

    void addProject(Project project);

    /**
     * Получить проект по id
     * @param projectId
     * @return
     */
    Project getProjectById(Long projectId);

    /**
     * Получить список задач в проекте с определенным статусом
     * @param projectId
     * @param statusName
     * @return
     */
    List<Task> getListTasksByFilterStatus(Long projectId, String statusName);
}
