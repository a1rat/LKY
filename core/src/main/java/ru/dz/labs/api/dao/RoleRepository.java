package ru.dz.labs.api.dao;

import org.springframework.stereotype.Repository;
import ru.dz.labs.api.domain.Role;

import java.util.List;

/**
 * Created by Rail on 29.06.2015.
 */

public interface RoleRepository {
    List<Role> getAllRoles();

    Role getRoleById(Long roleId);
}
