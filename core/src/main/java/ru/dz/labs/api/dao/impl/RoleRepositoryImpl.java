package ru.dz.labs.api.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.api.dao.RoleRepository;
import ru.dz.labs.api.domain.Role;

import java.util.List;

/**
 * Created by Rail on 29.06.2015.
 */
@Repository
public class RoleRepositoryImpl implements RoleRepository {

    @Autowired
    private SessionFactory sessionFactory;




    @Transactional
    @Override
    public List<Role> getAllRoles() {


        return sessionFactory.getCurrentSession().createCriteria(Role.class).list();
    }

    @Override
    public Role getRoleById(Long roleId) {
        return (Role) sessionFactory.getCurrentSession().load(Role.class, roleId);
    }


}
