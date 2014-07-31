package com.sr.controller;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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

import com.sr.Util;
import com.sr.config.AppConfig;
import com.sr.dao.SocialDto;
import com.sr.dao.ThingDto;
import com.sr.service.ThingService;
import com.sr.service.TwitterService;
import com.sr.service.UserDomainService;
import com.sr.session.TwitterAccessRequest;

@Controller
public class TwitterController {
	private Log4JLogger logger = new Log4JLogger(this.getClass().getName());
	@Autowired
	private AppConfig appConfig;
	@Autowired
	private UserDomainService userDomainService;
	@Autowired
	private TwitterService twitterService;
	
	public TwitterController(){}

	@Secured("ROLE_USER")
    @RequestMapping(value = ViewPath.TWITTER, method = RequestMethod.GET)
    public ModelAndView twitter(HttpServletRequest request, HttpServletResponse response) throws NoSuchRequestHandlingMethodException, IOException {
		HttpSession session = request.getSession();
		ThingDto thingDto = (ThingDto) session.getAttribute(ThingService.CREATE_THING_DTO);
		
		if(thingDto == null){
			logger.error("No thing to tweet/facebook");
			return new ModelAndView(ViewPath.ERROR); //Exit
		}
		
    	if(thingDto.tweetIt()){
    		try {
				if(!tweetIt(thingDto, thingDto.getCreatedBy())){
			    	TwitterAccessRequest accessRequest = null;
			    	try{
				        Twitter twitter = new TwitterFactory(getTwitterCredentials()).getInstance();
				        RequestToken requestToken = twitter.getOAuthRequestToken();
				        accessRequest = new TwitterAccessRequest(requestToken);
						session.setAttribute(TwitterService.TWITTER_ACCESS_REQUEST, accessRequest);
			    	}catch(TwitterException e){
			    		logger.error("Could not request session info from Twitter to link", e);
			    		goToFacebook(request, response);
			    	}
			    	
			    	//Back to this controller after we get a pin from Twitter.
			        return new ModelAndView(ViewPath.REQUEST_TWITTER_ACCESS, TwitterService.TWITTER_ACCESS_REQUEST, accessRequest); //Exit
				}
			} catch (TwitterException e) {
				logger.fatal("Could not resolve Twitter", e);
				return goToFacebook(request, response); //Exit
			}
    	}

    	return goToFacebook(request, response);
    }

	@Secured("ROLE_USER")
    @RequestMapping(value = "/secure/tconfirm", method = RequestMethod.POST)
    public ModelAndView tconfirm(@RequestParam("twitterPin") String pin, HttpServletRequest request, HttpServletResponse response) 
    		throws NoSuchRequestHandlingMethodException, TwitterException, IOException {
		HttpSession session = request.getSession();
		ThingDto thingDto = (ThingDto)session.getAttribute(ThingService.CREATE_THING_DTO);
        Twitter twitter = new TwitterFactory(getTwitterCredentials()).getInstance();

        //Get the request token from Twitter request and pull secret token/secret
        RequestToken requestToken = ((TwitterAccessRequest)session.getAttribute(TwitterService.TWITTER_ACCESS_REQUEST)).getRequestToken();
        AccessToken accessToken = twitter.getOAuthAccessToken(requestToken, pin);
        logger.debug("Got access token.");
        String token = accessToken.getToken();
		logger.debug("Access token: " + token);
        String tokenSecret = accessToken.getTokenSecret();
		logger.debug("Access token secret: " + tokenSecret);
		
		//Store the token/secret for future calls
        userDomainService.updateTwitterCredentials(thingDto.getCreatedBy(), token, tokenSecret);
    	
        //Tweet the massage
    	twitterService.tweet(thingDto, token, tokenSecret);
    	
    	return goToFacebook(request, response);
    }

	private ModelAndView goToFacebook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
 			//After we Twitter we go to Facebook by default.  
 			//We'll resolve what to do about Facebook there.
			response.sendRedirect(Util.buildResponseUrl(request, ViewPath.FACEBOOK));
		} catch (IOException e) {
			logger.error("Could not redirect", e);
		}
		return new ModelAndView(ViewPath.ERROR); //Last resort. All else failed.
	}

	private boolean tweetIt(ThingDto thingDto, String userName) throws TwitterException {
		List<SocialDto> socials = userDomainService.findSocialByUserName(userName);
		if(socials == null || socials.size() <= 0){
			return false; //Exit
		}
		for (SocialDto socialDto : socials) {
			if(socialDto.getNetworkName().equals(TwitterService.TWITTER)){
				twitterService.tweet(thingDto, socialDto.getTwitterOauthAccessToken(), 
						socialDto.getTwitterOauthAccessTokenSecret());
			}
		}
		return true;
	}
	
	/**
	 * All require credentials to make twitter api calls
	 * @return
	 */
	private PropertyConfiguration getTwitterCredentials() {
		Properties props = new Properties();
		props.setProperty(TwitterService.OAUTH_CONSUMER_SECRET, appConfig.getOauthConsumerSecret());
		props.setProperty(TwitterService.MEDIA_PROVIDER_API_KEY, appConfig.getMediaProviderAPIKey());
		props.setProperty(TwitterService.OAUTH_CONSUMER_KEY, appConfig.getOauthConsumerKey());
		PropertyConfiguration propertyConfiguration = new PropertyConfiguration(props);
		return propertyConfiguration;
	}
}
