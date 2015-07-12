package ru.dz.labs.api.service;

import org.springframework.stereotype.Service;
import ru.dz.labs.api.domain.Role;

import java.util.List;

/**
 * Created by Rail on 29.06.2015.
 */

public interface RoleService {

    List<Role> getAllRole();
    Role getRoleById(Long roleId);
}
