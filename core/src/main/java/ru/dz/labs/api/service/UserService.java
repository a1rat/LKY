package ru.dz.labs.api.service;

import ru.dz.labs.api.domain.*;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Айрат on 17.06.2015.
 */
@Transactional
public interface UserService {


    Users loadUserByUsername(String s);

    void addUser(Users user);

    /**
     * Получить пользователя по id
     * @param userId
     * @return
     */
    Users getUserById(Long userId);

    /**
     * Получить список всех задач пользователя с определенным статусом
     * @param userId
     * @param statusName
     * @return
     */
    List<Task> getListAllTasksUserByFilterStatus(Long userId, String statusName);

    /**
     * Получить список всех задач менеджера с определенным статусом
     * @param userId
     * @param statusName
     * @return
     */
    List<Task> getListAllTasksForManagerByFilterStatus(Long userId, String statusName);

    /**
     * Получить список всех задач менеджера
     * @param userId
     * @return
     */
    List<Task> getListAllTasksForManager(Long userId);
}
