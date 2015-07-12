package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.dz.labs.api.service.ProjectService;

/**
 * Created by Айрат on 23.06.2015.
 */
@Controller
public class ProjectController extends BaseController {

    @Autowired
    private ProjectService projectService;


}
