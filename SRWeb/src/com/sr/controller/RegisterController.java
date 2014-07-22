package com.sr.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import com.sr.dao.UserDto;
import com.sr.service.UserService;

@Controller
public class RegisterController {
	private Log4JLogger logger = new Log4JLogger(this.getClass().getName());
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserDetailsManager manager; 
	
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) throws NoSuchRequestHandlingMethodException {
        return ViewPath.REGISTER;
    }

    @RequestMapping(value = "/registeruser", method = RequestMethod.POST)
    public String registerUser(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest request) 
    		throws NoSuchRequestHandlingMethodException {
    	logger.info("Crating User: " + email);
    	userService.create(new UserDto(email, password, true, email, email));
    	UserDetails userDetails = manager.loadUserByUsername (email);
    	Authentication auth = new UsernamePasswordAuthenticationToken (userDetails.getUsername (),userDetails.getPassword (),userDetails.getAuthorities ());
    	SecurityContextHolder.getContext().setAuthentication(auth);
        return ViewPath.HOME;
    }

}
