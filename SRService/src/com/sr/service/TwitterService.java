package com.sr.service;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.PropertyConfiguration;

import com.sr.config.AppConfig;

@Component
public class TwitterService {
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
	private final AppConfig appConfig;
	
	@Autowired
	public TwitterService(AppConfig appConfig){
		this.appConfig = appConfig;
	}
	
	public void tweet(String message, String oauthAccessToken, String oauthAccessTokenSecret) throws TwitterException{
    	Properties props = new Properties();
    	props.setProperty(OAUTH_CONSUMER_SECRET, appConfig.getOauthConsumerSecret());
    	props.setProperty(MEDIA_PROVIDER_API_KEY, appConfig.getMediaProviderAPIKey());
    	props.setProperty(OAUTH_CONSUMER_KEY, appConfig.getOauthConsumerKey());
    	PropertyConfiguration propertyConfiguration = new PropertyConfiguration(props);
        Twitter twitter = new TwitterFactory(propertyConfiguration).getInstance(
        		new AccessToken(oauthAccessToken, oauthAccessTokenSecret));
        Status status = twitter.updateStatus(message);
        logger.debug("Successfully updated the status to [" + status.getText() + "].");

	}
	
/**	public void getAccessToken(String userName) throws TwitterException{
    	Properties props = new Properties();
    	props.setProperty(OAUTH_CONSUMER_SECRET, appConfig.getOauthConsumerSecret());
    	props.setProperty(MEDIA_PROVIDER_API_KEY, appConfig.getMediaProviderAPIKey());
    	props.setProperty(OAUTH_CONSUMER_KEY, appConfig.getOauthConsumerKey());
    	PropertyConfiguration propertyConfiguration = new PropertyConfiguration(props);

        Twitter twitter = new TwitterFactory(propertyConfiguration).getInstance();
        RequestToken requestToken = twitter.getOAuthRequestToken();
        System.out.println("Got request token.");
        System.out.println("Request token: " + requestToken.getToken());
        System.out.println("Request token secret: " + requestToken.getTokenSecret());
        AccessToken accessToken = null;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (null == accessToken) {
            System.out.println("Open the following URL and grant access to your account:");
            System.out.println(requestToken.getAuthorizationURL());
            try {
                Desktop.getDesktop().browse(new URI(requestToken.getAuthorizationURL()));
            } catch (UnsupportedOperationException ignore) {
            } catch (IOException ignore) {
            } catch (URISyntaxException e) {
                throw new AssertionError(e);
            }
            System.out.print("Enter the PIN(if available) and hit enter after you granted access.[PIN]:");
            String pin = br.readLine();
            try {
                if (pin.length() > 0) {
                    accessToken = twitter.getOAuthAccessToken(requestToken, pin);
                } else {
                    accessToken = twitter.getOAuthAccessToken(requestToken);
                }
            } catch (TwitterException te) {
                if (401 == te.getStatusCode()) {
                    System.out.println("Unable to get the access token.");
                } else {
                    te.printStackTrace();
                }
            }
        }
        System.out.println("Got access token.");
        System.out.println("Access token: " + accessToken.getToken());
        System.out.println("Access token secret: " + accessToken.getTokenSecret());
	}**/
}
