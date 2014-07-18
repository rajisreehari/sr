package com.sr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sr.dao.ThingDao;
import com.sr.dao.ThingDto;

@Component
public class ThingService {
	private ThingDao thingDao;
	
	@Autowired
	public ThingService(ThingDao thingDao){
		this.thingDao = thingDao;
	}
	
	public List<ThingDto> search(String phrase){
		return thingDao.search("%"+ phrase + "%"); 
	}
}
