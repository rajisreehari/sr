package com.sr.service;

import java.util.List;
import java.util.Properties;

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
	@Autowired
	private AppConfig conf;
	
	public static final String OAUTH_CONSUMER_KEY = "oauth.consumerKey";
	public static final String MEDIA_PROVIDER_API_KEY = "media.providerAPIKey";
	public static final String OAUTH_CONSUMER_SECRET = "oauth.consumerSecret";
	public static final String TWITTER = "TWITTER";
	public static final String REQUEST_TWITTER_ACCESS = "requestTwitterAccess";
	public static final String TWITTER_ACCESS_REQUEST = "twitterAccessRequest";
	
	public static final String SESSION_TOKEN = "sessionToken";
	public static final String SESSION_TOKEN_SECRET = "sessionTokenSecret";
	public static final String SESSION_AUTHORIZATION_URL = "sessionAuthorizationURL";
	public static final String TWEET_AFTER_ACCESS_MESSAGE = "TWEET_AFTER_ACCESS_MESSAGE";
	
	private final Log4JLogger logger = new Log4JLogger(this.getClass().getName());
	
	public TwitterService(){}
	
	public void tweet(ThingDto thing, String oauthAccessToken, String oauthAccessTokenSecret) throws TwitterException{
    	Properties props = new Properties();
    	props.setProperty(OAUTH_CONSUMER_SECRET, conf.getOauthConsumerSecret());
    	props.setProperty(MEDIA_PROVIDER_API_KEY, conf.getMediaProviderAPIKey());
    	props.setProperty(OAUTH_CONSUMER_KEY, conf.getOauthConsumerKey());
    	PropertyConfiguration propertyConfiguration = new PropertyConfiguration(props);
        Twitter twitter = new TwitterFactory(propertyConfiguration).getInstance(
        		new AccessToken(oauthAccessToken, oauthAccessTokenSecret));
        partitionMessageAndTweet(twitter, thing);
	}

	private void partitionMessageAndTweet(Twitter twitter, ThingDto thing) throws TwitterException {
		String thingUrl = conf.get("applicationUrl") + ":" + conf.get("port") + conf.get("thingPath") + thing.getId();
		
		String completeTweet = thing.getName() + " " + thingUrl;
		List<String> tweets = Util.breakupString(completeTweet, conf.getInt("tweetSize"));
		logger.debug("number of tweets: " + (tweets != null ? tweets.size() : 0) + " for thing: " + thing.getId());
		for (String tweet : tweets) {
			Status status = twitter.updateStatus(tweet);
			logger.debug("Successfully updated the status to [" + status.getText() + "].");
		}
	}
}
