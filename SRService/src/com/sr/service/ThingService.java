package com.sr.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

	public List<ThingDto> searchByCreatedBy(String createdBy){
		return thingDao.searchByCreatedBy(createdBy); 
	}

	@Transactional
	public void create(ThingDto thingDto) {
		if(thingDto.getCreatedBy() == null || thingDto.getCreatedBy().trim().length() <= 0){
			throw new IllegalArgumentException("Every Thing must have an author (createdBy)"); //Exit
		}
		
		if(thingDto.getName() == null || thingDto.getName().trim().length() <= 0){
			throw new IllegalArgumentException("Every Thing must have a name"); //Exit
		}

		if(thingDto.getDescription() == null || thingDto.getDescription().trim().length() <= 0){
			throw new IllegalArgumentException("Every Thing must have a description"); //Exit
		}
		
		thingDto.setUpdatedBy(thingDto.getCreatedBy());
		Date now = new Date();
		thingDto.setNumberOfVotes(1);
		thingDto.setCreatedTime(now);
		thingDto.setUpdatedTime(now);
		thingDao.create(thingDto);
	}
	
	@Transactional
	public void vote(BigInteger id, double rate){
		thingDao.vote(id, rate);
	}

	public double getVote(BigInteger id) {
		return thingDao.getVote(id);
	}
}
