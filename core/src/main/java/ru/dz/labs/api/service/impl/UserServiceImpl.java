package ru.dz.labs.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dz.labs.api.dao.UserRepository;
import ru.dz.labs.api.domain.Task;
import ru.dz.labs.api.domain.Users;
import ru.dz.labs.api.service.UserService;

import java.util.List;

/**
 * Created by Айрат on 20.06.2015.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users loadUserByUsername(String s) {
        return   userRepository.loadUserByUsername(s);
    }

    @Override
    public void addUser(Users user) {
        userRepository.addUser(user);
    }

    @Override
    public Users getUserById(Long userId) {
        return userRepository.getUserById(userId);
    }

    @Override
    public List<Task> getListAllTasksUserByFilterStatus(Long userId, String statusName) {
        return userRepository.getListAllTasksUserByFilterStatus(userId, statusName);
    }

    @Override
    public List<Task> getListAllTasksForManagerByFilterStatus(Long userId, String statusName) {
        return userRepository.getListAllTasksForManagerByFilterStatus(userId, statusName);
    }

    @Override
    public List<Task> getListAllTasksForManager(Long userId) {
        return userRepository.getListAllTasksForManager(userId);
    }

}
