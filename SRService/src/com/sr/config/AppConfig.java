package com.sr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/resources/suckrate.properties")
public class AppConfig {
	private String oauthConsumerSecret;
	private String mediaProviderAPIKey;
	private String oauthConsumerKey;

    @Autowired
    private Environment env;

    public String getOauthConsumerSecret() {
        if (oauthConsumerSecret == null) {
        	oauthConsumerSecret = env.getRequiredProperty("oauth.consumerSecret");
        }
        return oauthConsumerSecret;
    }

    public String getMediaProviderAPIKey() {
        if (mediaProviderAPIKey == null) {
        	mediaProviderAPIKey = env.getRequiredProperty("media.providerAPIKey");
        }
        return mediaProviderAPIKey;
    }

    public String getOauthConsumerKey() {
        if (oauthConsumerKey == null) {
        	oauthConsumerKey = env.getRequiredProperty("oauth.consumerKey");
        }
        return oauthConsumerKey;
    }
}
