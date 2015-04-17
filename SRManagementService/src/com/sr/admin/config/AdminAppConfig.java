package com.sr.admin.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources(value = {@PropertySource("classpath:/resources/suckrateAdmin.properties")})
public class AdminAppConfig {
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
}
