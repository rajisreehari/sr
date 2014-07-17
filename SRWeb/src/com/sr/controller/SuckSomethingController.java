package com.sr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

@Controller
public class SuckSomethingController {
	
    @RequestMapping(value = "/sucksomething", method = RequestMethod.GET)
    public String suckSomething(Model model) throws NoSuchRequestHandlingMethodException {
        return "sr/sucksomething";
    }

}
