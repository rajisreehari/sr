package com.sr.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sr.Util;
import com.sr.config.AppConfig;
import com.sr.dao.ThingDto;
import com.sr.service.ThingService;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;

@Controller
public class FacebookController {
	private Log4JLogger logger = new Log4JLogger(this.getClass().getName());
	
	@Autowired
	private AppConfig conf;
	
	@Secured("ROLE_USER")
    @RequestMapping(value = ViewPath.FACEBOOK, method = RequestMethod.GET)
    public void facebook(HttpServletRequest req, HttpServletResponse res) throws IOException {
		ThingDto thingDto = (ThingDto)req.getSession().getAttribute(ThingService.CREATE_THING_DTO);
		
		if(thingDto == null){
			logger.error("No thing to tweet/facebook");
			res.sendRedirect(Util.buildResponseUrl(req, ViewPath.ERROR));
		}
		
		if(thingDto.facebookIt()){
	    	Facebook f = new FacebookFactory().getInstance();
	    	f.setOAuthAppId(conf.get("fAppId"), conf.get("fAppSecret"));
	    	f.setOAuthPermissions(conf.get("fAuthPermissions"));
	        req.getSession().setAttribute("facebook", f);
	        String callbackURL = Util.buildResponseUrl(req, ViewPath.FACEBOOK_CALLBACK);
	        res.sendRedirect(f.getOAuthAuthorizationURL(callbackURL.toString()));
		}else{
			res.sendRedirect(Util.buildResponseUrl(req, "/thing/" + thingDto.getId()));
		}
    }

	@Secured("ROLE_USER")
    @RequestMapping(value = ViewPath.FACEBOOK_CALLBACK, method = RequestMethod.GET)
	public void fcallback(HttpServletRequest req, HttpServletResponse res) throws FacebookException, IOException {
        Facebook f = (Facebook) req.getSession().getAttribute("facebook");
        String oauthCode = req.getParameter("code");
        f.getOAuthAccessToken(oauthCode);
        res.sendRedirect(Util.buildResponseUrl(req, ViewPath.FACEBOOK_POST_FROM_CREATE));
    }
    
	@Secured("ROLE_USER")
    @RequestMapping(value = ViewPath.FACEBOOK_POST_FROM_CREATE, method = RequestMethod.GET)
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws FacebookException, IOException {
        req.setCharacterEncoding("UTF-8");
        ThingDto thingDto = (ThingDto)req.getSession().getAttribute(ThingService.CREATE_THING_DTO);
        Facebook f = (Facebook) req.getSession().getAttribute("facebook");
        logger.info("Posting for Facebook user: " + f.getMe().getFirstName() + " " + f.getMe().getLastName());
        logger.info("From SuckRate user: " + thingDto.getCreatedBy());
        f.postStatusMessage(thingDto.getName());
        res.sendRedirect(Util.buildResponseUrl(req, "/thing/" + thingDto.getId()));
    }
}
