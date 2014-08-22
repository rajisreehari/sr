package com.sr.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import com.sr.Util;
import com.sr.config.AppConfig;
import com.sr.dao.ThingDto;
import com.sr.dao.UserDto;
import com.sr.page.SearchResponse;
import com.sr.page.UserInput;
import com.sr.service.MasterService;

@Controller
public class UserController {
	private Log4JLogger logger = new Log4JLogger(this.getClass().getName());
	
	@Autowired
	private UserDetailsManager manager;
	@Autowired
	private MasterService masterService;
	@Autowired
	private AppConfig conf;
	
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) throws NoSuchRequestHandlingMethodException {
    	//Just send them to the view spring security will take over.
        return ViewPath.REGISTER;
    }

	@RequestMapping(value = "/registeruser", method = RequestMethod.POST)
    public String registerUser(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest request) 
    		throws NoSuchRequestHandlingMethodException {
    	logger.info("Crating User: " + email);
    	masterService.getUserDomainService().create(new UserDto(email, password, true, email, email));
    	UserDetails userDetails = manager.loadUserByUsername (email);
    	Authentication auth = new UsernamePasswordAuthenticationToken (userDetails.getUsername (),userDetails.getPassword (),userDetails.getAuthorities ());
    	SecurityContextHolder.getContext().setAuthentication(auth);
        return ViewPath.HOME;
    }
	
	@Secured("ROLE_USER")
    @RequestMapping(value = "/secure/user/things", method = RequestMethod.GET)
    public ModelAndView things() throws NoSuchRequestHandlingMethodException {
    	String user = getUserName();
		List<ThingDto> searchResults = masterService.getThingService().searchByCreatedBy(user);
    	logger.info("things found: " + (searchResults != null ? searchResults.size() : 0));
    	return new ModelAndView(ViewPath.SEARCH_RESULTS, ModelName.SEARCH_RESPONSE, new SearchResponse(searchResults, true, user));
    }

	@Secured("ROLE_USER")
    @RequestMapping(value = "/secure/user/profile", method = RequestMethod.GET)
    public ModelAndView profile() throws NoSuchRequestHandlingMethodException {
    	String userName = getUserName();
		UserDto user = masterService.getUserDomainService().findByUserName(userName);
		List<ThingDto> things = masterService.getThingService().searchByCreatedBy(userName);
		user.setThings(things);
    	logger.debug("Logging in: " + user);
    	ModelAndView model = new ModelAndView(ViewPath.PROFILE, "command", new UserInput(user, things));
		return model;
    }

	@Secured("ROLE_USER")
    @RequestMapping(value = "/secure/user/update", method = RequestMethod.POST)
    public ModelAndView update(@ModelAttribute(ModelName.USER) UserInput user) throws NoSuchRequestHandlingMethodException {
		String userName = getUserName();
    	user.setUserName(userName);
    	user.setUpdatedTime(new Date());
    	user.setUpdatedBy(userName);
		logger.debug("user: " + user);
    	masterService.getUserDomainService().updateUser(user);
    	return profile();
    }

	private String getUserName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String userName = auth.getName();
		return userName;
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/secure/user/uploadProfileImage", method = RequestMethod.POST)
	public ModelAndView uploadProfileImage(@RequestParam("file") MultipartFile file) throws IOException, NoSuchRequestHandlingMethodException {
    	UserDto user = masterService.getUserDomainService().findByUserName(getUserName());
    	//Upload main image
		masterService.getUserDomainService().uploadProfileImage(
				file, user, Util.IMAGE_MAIN, Util.IMAGE_EXT_JPG, conf.getInt("profileImageMaxDimention"));
		//Upload thumb image
		masterService.getUserDomainService().uploadProfileImage(
				file, user, Util.IMAGE_THUMB, Util.IMAGE_EXT_JPG, conf.getInt("profileThumbImageMaxDimention"));
		return profile();
	}
}
