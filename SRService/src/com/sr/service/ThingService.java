package com.sr.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileExistsException;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sr.Util;
import com.sr.config.AppConfig;
import com.sr.dao.ThingCommentDto;
import com.sr.dao.ThingDao;
import com.sr.dao.ThingDto;

@Component
public class ThingService {
	public static final String CREATE_THING_DTO = "CREATE_THING_DTO";
	
	@Autowired
	private ThingDao thingDao;
	@Autowired
	private AppConfig conf;
	
	public ThingService(){}
	
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
		thingDto.setAuthorVote(thingDto.getRate());
		thingDao.create(thingDto);
	}

	@Transactional
	public void vote(BigInteger id, double rate){
		thingDao.vote(id, rate);
	}

	public double getVote(BigInteger id) {
		return thingDao.getVote(id);
	}

	public ThingDto searchById(String id) {
		return thingDao.searchById(id);
	}

	public List<ThingCommentDto> getThingComments(String id) {
		return thingDao.getThingComments(id);
	}

	public void addCommnet(String id, String comment, String userName) {
		thingDao.addCommnet(new ThingCommentDto(id, comment, userName, userName));
	}
	
	public void uploadThingImage(
			MultipartFile file, ThingDto thing, String type, String extension, int imageSize) 
					throws IOException {
		String path = conf.get("imagePath") + File.separator + conf.get("thingDir") + File.separator + thing.getId();
		if (!file.isEmpty()) {
			BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
			File dir = new File(path);
			if(!dir.exists()){
				boolean success = dir.mkdirs();
				if(!success){
					throw new FileExistsException("Could not create directory at this location: " + path); //Exit
				}
			}
			
			String fullPath = path + File.separator + (thing.getId() + type) + "." + extension;
			File destination = new File(fullPath);
			ImageIO.write(Scalr.resize(src, imageSize), extension, destination);
			persistImagePath(thing, type, extension);
		}
	}
	
	/**
	 * Write out image path to the db. Thing table.
	 * @param user
	 * @param type
	 * @param extension
	 */
	private void persistImagePath(ThingDto thing, String type, String extension){
		String baseDir = conf.get("imageBaseDir");
		String thingDir = conf.get("thingDir");
		String path = baseDir + File.separator + thingDir + File.separator + 
				thing.getId() + File.separator + (thing.getId() + type) + "." + extension;
		if(Util.IMAGE_MAIN.equals(type)){
			thing.setMainImagePath(path);
		}else if(Util.IMAGE_THUMB.equals(type)){
			thing.setThumbImagePath(path);
		}
		thingDao.persistThingImagePath(thing);
	}
}
