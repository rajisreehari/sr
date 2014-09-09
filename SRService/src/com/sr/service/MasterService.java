package com.sr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sr.config.AppConfig;

@Component
public class MasterService {
	@Autowired
	private ThingService thingService;
	@Autowired
	private TwitterService twitterService;
	@Autowired
	private UserDomainService userDomainService;
	@Autowired
	private AppConfig conf;
	
	public ThingService getThingService() {
		return thingService;
	}
	public TwitterService getTwitterService() {
		return twitterService;
	}
	public UserDomainService getUserDomainService() {
		return userDomainService;
	}	
}
