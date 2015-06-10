package com.sr.admin.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

@Controller
public class AdminHomeController {
	
	@Secured("ROLE_ADMIN")
    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public String home(Model model) throws NoSuchRequestHandlingMethodException {
        return "secure/admin/home";
    }

}
