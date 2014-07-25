package com.sr.controller;

import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.PropertyConfiguration;

import com.sr.config.AppConfig;
import com.sr.dao.ThingDto;
import com.sr.dao.ThingState;
import com.sr.page.SearchResponse;
import com.sr.service.ThingService;
import com.sr.service.TwitterService;
import com.sr.service.UserDomainService;
import com.sr.session.TwitterAccessRequest;

@Controller
public class TwitterController {
	private Log4JLogger logger = new Log4JLogger(this.getClass().getName());
	private final AppConfig appConfig;
	private final ThingService thingService;
	private final UserDomainService userDomainService;
	private final TwitterService twitterService;
	
	@Autowired
	public TwitterController(AppConfig appConfig, ThingService thingService, UserDomainService userDomainService,
			TwitterService twitterService){
		this.appConfig = appConfig;
		this.thingService = thingService;
		this.userDomainService = userDomainService;
		this.twitterService = twitterService;
	}

	@Secured("ROLE_USER")
    @RequestMapping(value = "/twitterAccess", method = RequestMethod.GET)
    public ModelAndView twitterAccess(HttpSession session) throws NoSuchRequestHandlingMethodException {
    	TwitterAccessRequest accessRequest = null;
    	try{
	    	Properties props = new Properties();
	    	props.setProperty(TwitterService.OAUTH_CONSUMER_SECRET, appConfig.getOauthConsumerSecret());
	    	props.setProperty(TwitterService.MEDIA_PROVIDER_API_KEY, appConfig.getMediaProviderAPIKey());
	    	props.setProperty(TwitterService.OAUTH_CONSUMER_KEY, appConfig.getOauthConsumerKey());
	    	PropertyConfiguration propertyConfiguration = new PropertyConfiguration(props);
	
	        Twitter twitter = new TwitterFactory(propertyConfiguration).getInstance();
	        RequestToken requestToken = twitter.getOAuthRequestToken();
	        accessRequest = addToSession(requestToken, session);
    	}catch(TwitterException e){
    		logger.error("Could not request session info from Twitter to link", e);
    		return new ModelAndView(ViewPath.HOME);
    	}
        return new ModelAndView(ViewPath.REQUEST_TWITTER_ACCESS, TwitterService.TWITTER_ACCESS_REQUEST, accessRequest);
    }

	private TwitterAccessRequest addToSession(RequestToken requestToken, HttpSession session) {
		TwitterAccessRequest twitterAccessRequest = new TwitterAccessRequest(requestToken.getToken(), requestToken.getTokenSecret(), requestToken.getAuthorizationURL(), requestToken);
		session.setAttribute(TwitterService.TWITTER_ACCESS_REQUEST, twitterAccessRequest);
		return twitterAccessRequest;
	}

	@Secured("ROLE_USER")
    @RequestMapping(value = "/confirmTwitter", method = RequestMethod.POST)
    public ModelAndView confirmTwitter(@RequestParam("twitterPin") String twitterPin, HttpSession session) 
    		throws NoSuchRequestHandlingMethodException, TwitterException {
    	Properties props = new Properties();
    	props.setProperty(TwitterService.OAUTH_CONSUMER_SECRET, appConfig.getOauthConsumerSecret());
    	props.setProperty(TwitterService.MEDIA_PROVIDER_API_KEY, appConfig.getMediaProviderAPIKey());
    	props.setProperty(TwitterService.OAUTH_CONSUMER_KEY, appConfig.getOauthConsumerKey());
    	PropertyConfiguration propertyConfiguration = new PropertyConfiguration(props);

        Twitter twitter = new TwitterFactory(propertyConfiguration).getInstance();
        RequestToken requestToken = ((TwitterAccessRequest)session.getAttribute(TwitterService.TWITTER_ACCESS_REQUEST)).getRequestToken();
        AccessToken accessToken = twitter.getOAuthAccessToken(requestToken, twitterPin);
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        logger.debug("Got access token.");
        String token = accessToken.getToken();
		logger.debug("Access token: " + token);
        String tokenSecret = accessToken.getTokenSecret();
		logger.debug("Access token secret: " + tokenSecret);
        userDomainService.updateTwitterCredentials(userName, token, tokenSecret);
        
        List<ThingDto> searchResults = thingService.search(userName);
    	SearchResponse searchResponse = new SearchResponse(searchResults, userName);
    	ThingDto thingDto = (ThingDto)session.getAttribute(TwitterService.TWEET_AFTER_ACCESS_MESSAGE);
    	twitterService.tweet(thingDto.getName(), token, tokenSecret);
        return new ModelAndView(ViewPath.SEARCH_RESULTS, ModelName.SEARCH_RESPONSE, searchResponse); //Exit
    }

}
