package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.dz.labs.api.domain.ExpendedTime;
import ru.dz.labs.api.domain.Task;
import ru.dz.labs.api.domain.Users;
import ru.dz.labs.api.domain.common.TaskTable;
import ru.dz.labs.api.service.TaskService;
import ru.dz.labs.api.service.UserService;
import ru.dz.labs.security.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by GRamis on 24.06.2015.
 */
@Controller
public class TaskController extends BaseController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/task/list", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<TaskTable> taskLists() {
        User userContext = (User)((Authentication) (SecurityContextHolder.getContext().getAuthentication())).getPrincipal();
        Users user = userService.getUserById(userContext.getUserInfo().getId());
        List<TaskTable> tasks = new ArrayList<>();
        List<Task> taskList = null;
        Calendar calendar = Calendar.getInstance();
        if (user.getRole().getName().equals("Manager")){
            taskList = userService.getListAllTasksForManager(user.getId());
        }else {
            taskList = userService.getUserById(user.getId()).getTasks();
        }
        for (Task task : taskList) {
            List<ExpendedTime> expendedTimeList = null;
            TaskTable taskTable = new TaskTable();
            expendedTimeList = task.getExpended_time();
            for (ExpendedTime expendedTime : expendedTimeList) {
                calendar.setTime(expendedTime.getDay());
                if (calendar.get(Calendar.WEEK_OF_YEAR) == (new GregorianCalendar()).get(Calendar.WEEK_OF_YEAR)) {
                switch (calendar.get(Calendar.DAY_OF_WEEK)) {
                    case 1:
                        taskTable.setSunday(expendedTime.getTime());
                        break;
                    case 2:
                        taskTable.setMonday(expendedTime.getTime());
                        break;
                    case 3:  taskTable.setTuesday(expendedTime.getTime());
                        break;
                    case 4:
                        taskTable.setWednesday(expendedTime.getTime());
                        break;
                    case 5:
                        taskTable.setThursday(expendedTime.getTime());
                        break;
                    case 6:
                        taskTable.setFriday(expendedTime.getTime());
                        break;
                    case 7:
                        taskTable.setSaturday(expendedTime.getTime());
                        break;
                    default: break;
                }
                }
            }
            taskTable.setId(task.getId());
            taskTable.setTask_name(task.getName());
            tasks.add(taskTable);
        }

//        tasks.add(new TaskTable(1L, "Сделать верстку", 2L, 0L, 3L, 0L, 0L, 7L, 6L));
//        tasks.add(new TaskTable(2L, "Авторизация", 2L, 0L, 3L, 0L, 0L, 7L, 6L));
//        tasks.add(new TaskTable(3L, "По пить меринду", 2L, 0L, 3L, 0L, 0L, 7L, 6L));
//        tasks.add(new TaskTable(0L, "Итого", 6L, 0L, 9L, 0L, 0L, 21L, 18L));
        return tasks;
    }

    @RequestMapping(value = "/task", method = RequestMethod.GET)
    public String getTaskById(@RequestParam(value = "id") Long id) {
        request.setAttribute("task", taskService.getTaskById(id));
        return "task/taskPage";
    }
}