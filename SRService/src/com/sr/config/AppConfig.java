package com.sr.config;

import java.util.HashMap;
import java.util.Map;

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
	private Map<String, String> data = new HashMap<String, String>();

    @Autowired
    private Environment env;
    
    public String get(String key){
    	String result = data.get(key);
    	if(result == null){
    		result = env.getRequiredProperty(key);
			data.put(key, result);
    	}
    	return result;
    }
    
    public int getInt(String key){
    	return Integer.parseInt(get(key));
    }

    public String getOauthConsumerSecret() {
        if (oauthConsumerSecret == null) {
        	oauthConsumerSecret = env.getRequiredProperty("oauthConsumerSecret");
        }
        return oauthConsumerSecret;
    }

    public String getMediaProviderAPIKey() {
        if (mediaProviderAPIKey == null) {
        	mediaProviderAPIKey = env.getRequiredProperty("mediaProviderAPIKey");
        }
        return mediaProviderAPIKey;
    }

    public String getOauthConsumerKey() {
        if (oauthConsumerKey == null) {
        	oauthConsumerKey = env.getRequiredProperty("oauthConsumerKey");
        }
        return oauthConsumerKey;
    }
}
