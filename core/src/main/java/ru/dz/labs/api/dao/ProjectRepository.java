package ru.dz.labs.api.dao;

import ru.dz.labs.api.domain.Project;
import ru.dz.labs.api.domain.Task;

import java.util.List;

/**
 * Created by Айрат on 19.06.2015.
 */
public interface ProjectRepository {

    void addProject(Project project);

    Project getProjectById(Long projectId);

    List<Task> getListTasksByFilterStatus(Long projectId, String statusName);
}
