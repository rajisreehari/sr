package com.sr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

@Controller
public class ContactController {
	
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Model model) throws NoSuchRequestHandlingMethodException {
        return ViewPath.CONTACT;
    }

}
