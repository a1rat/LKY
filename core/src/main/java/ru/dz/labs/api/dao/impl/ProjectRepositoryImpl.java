package ru.dz.labs.api.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.api.dao.ProjectRepository;
import ru.dz.labs.api.domain.Project;
import ru.dz.labs.api.domain.Task;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Айрат on 19.06.2015.
 */
@Repository
public class ProjectRepositoryImpl implements ProjectRepository{

    @Autowired
    protected SessionFactory sessionFactory;

    @Transactional
    public void addProject(Project project) {
        sessionFactory.getCurrentSession().save(project);
    }

    @Transactional
    public Project getProjectById(Long projectId) {
        return (Project) sessionFactory.getCurrentSession().load(Project.class, projectId);
    }

    @Transactional
    public List<Task> getListTasksByFilterStatus(Long projectId, String statusName) {
        return sessionFactory.getCurrentSession().createCriteria(Task.class)
                .add(Restrictions.and(
                        Restrictions.eq("project", projectId), Restrictions.eq("status.name", statusName)))
                .list();
    }

}
