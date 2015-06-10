package com.sr.service;

import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.PropertyConfiguration;

import com.sr.Util;
import com.sr.config.AppConfig;
import com.sr.dao.ThingDto;

@Component
public class TwitterService {
	public static final String TWITTER_TWEET_SIZE = "twitter.tweet.size";
	public static final String THING_PATH = "thing.path";
	public static final String APPLICATION_PORT = "application.port";
	public static final String APPLICATION_URL = "application.url";
	public static final String TWITTER_OAUTH_CONSUMER_KEY = "twitter.oauth.consumer.key";
	public static final String TWITTER_MEDIA_PROVIDER_API_KEY = "twitter.media.provider.api.key";
	public static final String TWITTER_OAUTH_CONSUMER_SECRET = "twitter.oauth.consumer.secret";
	public static final String TWITTER = "TWITTER";
	public static final String REQUEST_TWITTER_ACCESS = "requestTwitterAccess";
	public static final String TWITTER_ACCESS_REQUEST = "twitterAccessRequest";
	public static final String SESSION_TOKEN = "sessionToken";
	public static final String SESSION_TOKEN_SECRET = "sessionTokenSecret";
	public static final String SESSION_AUTHORIZATION_URL = "sessionAuthorizationURL";
	public static final String OAUTH_CONSUMER_KEY = "oauth.consumerKey";
	public static final String MEDIA_PROVIDER_API_KEY = "media.providerAPIKey";
	public static final String OAUTH_CONSUMER_SECRET = "oauth.consumerSecret";

	@Autowired
	private AppConfig conf;
	
	private final Log4JLogger logger = new Log4JLogger(this.getClass().getName());
	
	public TwitterService(){}
	
	public void tweet(ThingDto thing, String oauthAccessToken, String oauthAccessTokenSecret, HttpServletRequest req) throws TwitterException{
    	Properties props = new Properties();
    	props.setProperty(OAUTH_CONSUMER_SECRET, conf.getString(TWITTER_OAUTH_CONSUMER_SECRET, null));
    	props.setProperty(MEDIA_PROVIDER_API_KEY, conf.getString(TWITTER_MEDIA_PROVIDER_API_KEY, null));
    	props.setProperty(OAUTH_CONSUMER_KEY, conf.getString(TWITTER_OAUTH_CONSUMER_KEY, null));
    	PropertyConfiguration propertyConfiguration = new PropertyConfiguration(props);
        Twitter twitter = new TwitterFactory(propertyConfiguration).getInstance(
        		new AccessToken(oauthAccessToken, oauthAccessTokenSecret));
        partitionMessageAndTweet(twitter, thing, req);
	}

	private void partitionMessageAndTweet(Twitter twitter, ThingDto thing, HttpServletRequest req) throws TwitterException {
		String thingUrl = conf.getString(APPLICATION_URL, null) + ":" + conf.getString(APPLICATION_PORT, null) 
				+ req.getContextPath() + "/" + conf.getString(THING_PATH, null) + "/" + thing.getId();
		
		String completeTweet = thing.getName() + " " + thingUrl;
		List<String> tweets = Util.breakupString(completeTweet, conf.getInt(TWITTER_TWEET_SIZE, 140));
		logger.debug("number of tweets: " + (tweets != null ? tweets.size() : 0) + " for thing: " + thing.getId());
		for (String tweet : tweets) {
			Status status = twitter.updateStatus(tweet);
			logger.debug("Successfully updated the status to [" + status.getText() + "].");
		}
	}
}
