package ru.dz.labs.api.dao.impl;


import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.api.dao.UserRepository;
import ru.dz.labs.api.domain.*;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Айрат on 19.06.2015.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public Users loadUserByUsername(String s) {
        return (Users) sessionFactory.getCurrentSession().createCriteria(Users.class)
                .add(Restrictions.eq("login", s)).uniqueResult();
    }

    @Transactional
    public void addUser(Users user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Transactional
    public Users getUserById(Long userId) {
        return (Users)sessionFactory.getCurrentSession().load(Users.class, userId);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<Task> getListAllTasksUserByFilterStatus(Long userId, String statusName){
        Status status = (Status) sessionFactory.getCurrentSession().createCriteria(Status.class)
                .add(Restrictions.eq("name", statusName)).uniqueResult();
        Users user = (Users) sessionFactory.getCurrentSession().load(Users.class, userId);
        return sessionFactory.getCurrentSession().createCriteria(Task.class)
                .add(Restrictions.and(Restrictions.eq("user_task", user), Restrictions.eq("status", status))).list();
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<Task> getListAllTasksForManagerByFilterStatus(Long userId, String statusName){
        Status status = (Status) sessionFactory.getCurrentSession().createCriteria(Status.class)
                .add(Restrictions.eq("name", statusName)).uniqueResult();
        Users user = (Users) sessionFactory.getCurrentSession().load(Users.class, userId);
        return sessionFactory.getCurrentSession().createCriteria(Task.class)
                .add(Restrictions.and(Restrictions.eq("manager", user), Restrictions.eq("status", status))).list();
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<Task> getListAllTasksForManager(Long userId){
        Users user = (Users) sessionFactory.getCurrentSession().load(Users.class, userId);
        return sessionFactory.getCurrentSession().createCriteria(Task.class)
                .add(Restrictions.eq("manager", user)).list();
    }
}
