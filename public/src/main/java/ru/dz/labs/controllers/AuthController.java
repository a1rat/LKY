package ru.dz.labs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
/**
 * Created by Rail on 23.06.2015.
 */
@Controller
public class AuthController extends BaseController {


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String renderAuth() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails) {
            if(!((UserDetails) principal).getAuthorities().isEmpty()) {
                return "redirect:/";
            }
        }
        return "auth/login";
    }

    @RequestMapping(value = "/error403", method = RequestMethod.GET)
    public String denied() {
        return "error403";
    }
}
