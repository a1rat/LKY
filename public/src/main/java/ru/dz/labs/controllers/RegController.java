package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.dz.labs.api.domain.Users;

import ru.dz.labs.api.service.RoleService;

import ru.dz.labs.api.service.UserService;
import ru.dz.labs.form.RegUserForm;
import ru.dz.labs.security.PassEncode;
import ru.dz.labs.validator.UserRegistrationValidator;

/**
 * Created by Rail on 29.06.2015.
 */
@Controller
public class RegController {

    @Autowired
    UserRegistrationValidator userRegistrationValidator;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;


    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String renderReg(ModelMap map) {
    /*    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            if (!((UserDetails) principal).getAuthorities().isEmpty()) {
                return "redirect:/";
            }
        }*/
        map.put("reg-form", new RegUserForm());
        map.put("roleList", roleService.getAllRole());

        return "auth/registry";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String reg(@ModelAttribute("reg-form") RegUserForm form, BindingResult bindingResult, ModelMap map) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            if (!((UserDetails) principal).getAuthorities().isEmpty()) {
                return "redirect:/";
            }
        }

        userRegistrationValidator.validate(form, bindingResult);
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            map.put("cityList", roleService.getAllRole());

            return "auth/registry";
        }

        userService.addUser(getUserInfo(form));
        return "auth/login";
    }

    private Users getUserInfo(RegUserForm form) {
        Users userInfo = new Users();
        userInfo.setLogin(form.getEmail());
        userInfo.setPassword(new PassEncode().encode(form.getPassword()));
        userInfo.setName(form.getName());
        userInfo.setRole(roleService.getRoleById(form.getRole()));

        return userInfo;
    }

}
