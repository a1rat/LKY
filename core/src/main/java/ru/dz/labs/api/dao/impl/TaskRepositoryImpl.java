package ru.dz.labs.api.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.api.dao.TaskRepository;
import ru.dz.labs.api.domain.Task;

import javax.transaction.Transactional;

/**
 * Created by Айрат on 19.06.2015.
 */
@Repository
public class TaskRepositoryImpl implements TaskRepository {

    @Autowired
    protected SessionFactory sessionFactory;

    @Transactional
    public void addTask(Task task) {
        sessionFactory.getCurrentSession().save(task);
    }

    @Transactional
    public Task getTaskById(Long taskId) {
        return (Task) sessionFactory.getCurrentSession().load(Task.class, taskId);
    }

}
