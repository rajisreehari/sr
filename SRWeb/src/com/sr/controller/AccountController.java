package com.sr.controller;

import java.util.List;

import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import com.sr.dao.ThingDto;
import com.sr.dao.ThingState;
import com.sr.page.SearchResponse;
import com.sr.service.ThingService;

@Controller
public class AccountController {
	private Log4JLogger logger = new Log4JLogger(this.getClass().getName());
	
	@Autowired
	private ThingService thingService;
	
	@Secured("ROLE_USER")
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public ModelAndView search() throws NoSuchRequestHandlingMethodException {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String user = auth.getName();
		List<ThingDto> searchResults = thingService.searchByCreatedBy(user);
    	logger.info("things found: " + (searchResults != null ? searchResults.size() : 0));
    	
    	ModelAndView result = null;
    	if(searchResults != null && searchResults.size() > 0){
    		result = new ModelAndView(ViewPath.SEARCH_RESULTS, ModelName.SEARCH_RESPONSE, new SearchResponse(searchResults, true, user));
    	}else{
    		result = new ModelAndView(ViewPath.CREATE, ModelName.THING, new ThingDto("", ThingState.SEARCHED_NOT_FOUND_CREATE));
    	}
    	return result;
    }
}
