package ru.dz.labs.api.dao;

import ru.dz.labs.api.domain.*;

import java.util.List;

/**
 * Created by Айрат on 19.06.2015.
 */

public interface UserRepository {
    Users loadUserByUsername(String s);

    void addUser(Users user);

    Users getUserById(Long userId);

    List<Task> getListAllTasksUserByFilterStatus(Long userId, String statusName);

    List<Task> getListAllTasksForManagerByFilterStatus(Long userId, String statusName);

    List<Task> getListAllTasksForManager(Long userId);
}
