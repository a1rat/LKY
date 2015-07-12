package ru.dz.labs.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dz.labs.api.dao.ProjectRepository;
import ru.dz.labs.api.domain.Project;
import ru.dz.labs.api.domain.Task;
import ru.dz.labs.api.service.ProjectService;

import java.util.List;

/**
 * Created by Айрат on 23.06.2015.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void addProject(Project project) {
        projectRepository.addProject(project);
    }

    @Override
    public Project getProjectById(Long projectId) {
        return projectRepository.getProjectById(projectId);
    }

    @Override
    public List<Task> getListTasksByFilterStatus(Long projectId, String statusName) {
        return projectRepository.getListTasksByFilterStatus(projectId, statusName);
    }
}
