package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.api.domain.Users;
import ru.dz.labs.api.service.UserService;
import ru.dz.labs.security.User;

import javax.servlet.http.HttpSession;

/**
 * Created by Айрат on 17.06.2015.
 */
@Controller
public class MainController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainPage() {
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null){
            User userContext = (User)((Authentication) (SecurityContextHolder.getContext().getAuthentication())).getPrincipal();
            Users user = userService.getUserById(userContext.getUserInfo().getId());
            session.setAttribute("username", user.getName());
        }
        return "main/mainPage";
    }
}
