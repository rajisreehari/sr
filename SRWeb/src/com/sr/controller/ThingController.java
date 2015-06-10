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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import com.sr.Util;
import com.sr.config.AppConfig;
import com.sr.dao.ThingDto;
import com.sr.page.ThingResponse;
import com.sr.service.MasterService;
import com.sr.service.ThingService;

@Controller
public class ThingController {
	private static final String THING_THUMB_IMAGE_MAX_DIMENTION = "thing.thumb.image.max.dimention";
	private static final String THING_IMAGE_MAX_DIMENTION = "thing.image.max.dimention";
	private Log4JLogger logger = new Log4JLogger(this.getClass().getName());
	
	@Autowired
	private MasterService masterService;
	@Autowired
	private AppConfig conf;
	
    @RequestMapping(value = "/thing/{id}", method = RequestMethod.GET)
    public ModelAndView thing(@PathVariable(value="id") String id) throws NoSuchRequestHandlingMethodException {
    	ThingDto thingDto = masterService.getThingService().searchById(id);
        ThingResponse thingResponse = new ThingResponse(thingDto);
        thingResponse.setThingComments(masterService.getThingService().getThingComments(id));
		return new ModelAndView(ViewPath.THING, ModelName.THING, thingResponse);
    }
 
	@Secured("ROLE_USER")
    @RequestMapping(value = "/secure/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("thing") ThingDto thingDto, HttpServletRequest request, HttpServletResponse response) 
    		throws NoSuchRequestHandlingMethodException, IOException {
    	String userName = getUserName();
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
	
	@Secured("ROLE_USER")
    @RequestMapping(value = "/secure/addCommnet", method = RequestMethod.POST)
    public ModelAndView addCommnet(@ModelAttribute("thing") ThingResponse thingResponse) 
    		throws NoSuchRequestHandlingMethodException {
		String userName = getUserName();
        String id = thingResponse.getId().toString();
        masterService.getThingService().addCommnet(id, thingResponse.getComment(), userName);
		
        thingResponse.setThingComments(masterService.getThingService().getThingComments(id));
        thingResponse.setThingDto(masterService.getThingService().searchById(id));
        return new ModelAndView(ViewPath.THING, ModelName.THING, thingResponse);
	}

	private String getUserName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
		return userName;
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/secure/user/uploadThingImage", method = RequestMethod.POST)
	public ModelAndView uploadThingImage(@RequestParam("file") MultipartFile file, @RequestParam("id") String id) throws IOException, NoSuchRequestHandlingMethodException {
    	ThingDto thing = masterService.getThingService().searchById(id);
    	
    	if(thing.getCreatedBy().equals(getUserName())){
    		//Update main image
    		masterService.getThingService().uploadThingImage(file, thing, Util.IMAGE_MAIN, Util.IMAGE_EXT_JPG, conf.getInt(THING_IMAGE_MAX_DIMENTION, 6));
    		//Update thumb image
    		masterService.getThingService().uploadThingImage(file, thing, Util.IMAGE_THUMB, Util.IMAGE_EXT_JPG, conf.getInt(THING_THUMB_IMAGE_MAX_DIMENTION, 100));
    	}
    	
		return thing(id);
	}
}
