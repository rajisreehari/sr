package com.sr.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import com.sr.Util;
import com.sr.dao.ThingDto;
import com.sr.service.MasterService;
import com.sr.service.ThingService;

@Controller
public class CrateController {
	private Log4JLogger logger = new Log4JLogger(this.getClass().getName());
	
	@Autowired
	private MasterService masterService;
	
	@Secured("ROLE_USER")
    @RequestMapping(value = "/secure/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("thing") ThingDto thingDto, HttpServletRequest request, HttpServletResponse response) 
    		throws NoSuchRequestHandlingMethodException, IOException {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String userName = auth.getName();
    	HttpSession session = request.getSession();
        logger.debug("userName: " + userName + ". Is creating a thing.");
		thingDto.setCreatedBy(userName);
		masterService.getThingService().create(thingDto);
    	
    	session.setAttribute(ThingService.CREATE_THING_DTO, thingDto);
 		try {
 			//After we create we go to Twitter by default.  
 			//We'll resolve what to do about Twitter there.
			response.sendRedirect(Util.buildResponseUrl(request, ViewPath.TWITTER));
		} catch (IOException e) {
			logger.error("Could not redirect", e);
		}
 		
 		return new ModelAndView(ViewPath.ERROR); //Exit
    }
}
