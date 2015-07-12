package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.dz.labs.api.domain.Task;
import ru.dz.labs.api.domain.Users;
import ru.dz.labs.api.domain.common.TaskActivityTable;
import ru.dz.labs.api.service.UserService;
import ru.dz.labs.security.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GRamis on 26.06.2015.
 */
@Controller
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String mainPage() {
        User user = (User)((Authentication) (SecurityContextHolder.getContext().getAuthentication())).getPrincipal();
        request.setAttribute("user", userService.getUserById(user.getUserInfo().getId()));
        return "user/userPage";
    }

    @RequestMapping(value = "/task/list/user", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<TaskActivityTable> taskActivityTableLists() {
        User user = (User)((Authentication) (SecurityContextHolder.getContext().getAuthentication())).getPrincipal();
        List<Task> tasks = null;
        Users userInfo = userService.getUserById(user.getUserInfo().getId());
        if (userInfo.getRole().getName().equals("Manager")){
            tasks = userService.getListAllTasksForManagerByFilterStatus(userInfo.getId(), "open");
        }else {
            tasks = userService.getListAllTasksUserByFilterStatus(userInfo.getId(), "open");
        }
        List<TaskActivityTable> taskActivityTables = new ArrayList<>();
        for (Task task : tasks) {
            taskActivityTables.add(new TaskActivityTable(task.getId(),task.getName(), task.getStatus().getName(),
                    task.getPriority().getName(), task.getEstimated_time().toString()));
        }
//        taskActivityTables.add(new TaskActivityTable(1L, "Сделать верстку", "Высокий", "1", "2016"));
//        taskActivityTables.add(new TaskActivityTable(2L, "Авторизация", "Высокий", "1", "2015"));
//        taskActivityTables.add(new TaskActivityTable(3L, "По пить меринду", "Высокий", "1", "2015"));
        return taskActivityTables;
    }
}
