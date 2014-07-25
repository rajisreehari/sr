package com.sr.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import twitter4j.TwitterException;

import com.sr.dao.SocialDto;
import com.sr.dao.ThingDto;
import com.sr.page.SearchResponse;
import com.sr.service.ThingService;
import com.sr.service.TwitterService;
import com.sr.service.UserDomainService;

@Controller
public class CrateController {
	private Log4JLogger logger = new Log4JLogger(this.getClass().getName());
	
	@Autowired
	private ThingService thingService;
	@Autowired
	private TwitterService twitterService;
	@Autowired
	private UserDomainService userDomainService;
	
    @RequestMapping(value = "/secure/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("thing") ThingDto thingDto, HttpSession session, 
    		@RequestParam("tweetIt") String tweetIt, HttpServletResponse response) 
    		throws NoSuchRequestHandlingMethodException {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        logger.debug("userName: " + userName + ". Is creating a thing.");
		thingDto.setCreatedBy(userName);
    	thingService.create(thingDto);
    	List<ThingDto> searchResults = thingService.search(thingDto.getName());
    	SearchResponse searchResponse = new SearchResponse(searchResults, userName, thingDto);
    	
    	boolean requestTwitterAccess = false;
    	if("Y".equals(tweetIt)){
    		try {
				requestTwitterAccess = !tweetIt(thingDto, userName);
			} catch (TwitterException e) {
				searchResponse.setTwitterErrorMessage("Could not tweet, error: " + e.getMessage());
			}
    	}
    	
    	session.setAttribute(UserDomainService.SESSION_USER, userName);
    	session.setAttribute(TwitterService.TWEET_AFTER_ACCESS_MESSAGE, thingDto);
    	searchResponse.setRequestTwitterAccess(requestTwitterAccess);
    	
    	ModelAndView result = new ModelAndView(ViewPath.SEARCH_RESULTS, ModelName.SEARCH_RESPONSE, searchResponse);
    	if(requestTwitterAccess){
    		try {
				response.sendRedirect("/SRWeb/twitterAccess");
			} catch (IOException e) {
				logger.error("Could not redirect", e);
			}
    	}
        return result; //Exit
    }

	private boolean tweetIt(ThingDto thingDto, String userName) throws TwitterException {
		List<SocialDto> socials = userDomainService.findSocialByUserName(userName);
		if(socials == null || socials.size() <= 0){
			return false; //Exit
		}
		for (SocialDto socialDto : socials) {
			if(socialDto.getNetworkName().equals(TwitterService.TWITTER)){
				twitterService.tweet(thingDto.getName(), socialDto.getTwitterOauthAccessToken(), 
						socialDto.getTwitterOauthAccessTokenSecret());
			}
		}
		return true;
	}
}
