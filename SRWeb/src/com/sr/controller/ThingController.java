package com.sr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import com.sr.dao.ThingDto;
import com.sr.page.ThingResponse;
import com.sr.service.MasterService;

@Controller
public class ThingController {
	@Autowired
	private MasterService masterService;
	
    @RequestMapping(value = "/thing/{id}", method = RequestMethod.GET)
    public ModelAndView thing(@PathVariable(value="id") String id) throws NoSuchRequestHandlingMethodException {
    	ThingDto thingDto = masterService.getThingService().searchById(id);
        ThingResponse thingResponse = new ThingResponse(thingDto);
        thingResponse.setThingComments(masterService.getThingService().getThingComments(id));
		return new ModelAndView(ViewPath.THING, ModelName.THING, thingResponse);
    }
    
	@Secured("ROLE_USER")
    @RequestMapping(value = "/secure/addCommnet", method = RequestMethod.POST)
    public ModelAndView addCommnet(@ModelAttribute("thing") ThingResponse thingResponse) 
    		throws NoSuchRequestHandlingMethodException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        String id = thingResponse.getId().toString();
        masterService.getThingService().addCommnet(id, thingResponse.getComment(), userName);
		
        thingResponse.setThingComments(masterService.getThingService().getThingComments(id));
        thingResponse.setThingDto(masterService.getThingService().searchById(id));
        return new ModelAndView(ViewPath.THING, ModelName.THING, thingResponse);
	}
}
