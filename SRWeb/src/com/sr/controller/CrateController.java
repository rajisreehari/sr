package com.sr.controller;

import java.util.List;

import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import com.sr.dao.ThingDto;
import com.sr.dao.ThingState;
import com.sr.service.ThingService;

@Controller
public class CrateController {
	private Log4JLogger logger = new Log4JLogger(this.getClass().getName());
	
	@Autowired
	private ThingService thingService;
	
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView search(@ModelAttribute("thing") ThingDto thingDto, ModelMap model) throws NoSuchRequestHandlingMethodException {
    	thingService.create(thingDto);
    	List<ThingDto> searchResults = thingService.search(thingDto.getName());
    	ModelAndView result = new ModelAndView(ViewPath.SEARCH_RESULTS, ModelName.SEARCH_RESULTS, searchResults);
        return result; //Exit
    }

}
