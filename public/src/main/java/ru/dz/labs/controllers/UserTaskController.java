package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.api.domain.Users;
import ru.dz.labs.api.service.UserService;

/**
 * Created by GRamis on 24.06.2015.
 */
@Controller
public class UserTaskController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user-task", method = RequestMethod.GET)
    public String mainPage() {
        Users users = userService.getUserById(2L);
        request.setAttribute("task", users.getTasks());
        return "task/taskPage";
    }
}
