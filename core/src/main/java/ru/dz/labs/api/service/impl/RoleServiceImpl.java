package ru.dz.labs.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dz.labs.api.dao.RoleRepository;
import ru.dz.labs.api.domain.Role;
import ru.dz.labs.api.service.RoleService;

import java.util.List;

/**
 * Created by Rail on 29.06.2015.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRole() {
        return roleRepository.getAllRoles();
    }

    @Override
    public Role getRoleById(Long roleId) {
        return roleRepository.getRoleById(roleId);
    }
}
