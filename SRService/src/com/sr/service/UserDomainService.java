package com.sr.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
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
import com.sr.dao.SocialDto;
import com.sr.dao.UserAuthorityDto;
import com.sr.dao.UserDomainDao;
import com.sr.dao.UserDto;

@Component
public class UserDomainService {
	@Autowired
	private UserDomainDao userDomainDao;
	@Autowired
	private AppConfig conf;
	
	public UserDto findByUserName(String userName){
		return userDomainDao.findByUserName(userName);
	}

	public List<SocialDto> findSocialByUserName(String userName){
		return userDomainDao.findSocialByUserName(userName);
	}

	@Transactional
	public void create(UserDto userDto) {
		userDomainDao.createUser(userDto);
		userDomainDao.createUserAuthority(new UserAuthorityDto(userDto.getUserName(), UserAuthorityDto.ROLE_USER, userDto.getUserName(), userDto.getUserName()));
	}

	public void updateTwitterCredentials(String userName, String token,
			String tokenSecret) {
		userDomainDao.updateTwitterCredentials(new SocialDto(userName, TwitterService.TWITTER,
				token, tokenSecret, userName, userName));
	}

	public void updateUser(UserDto user) {
		userDomainDao.updateUser(user);
	}

	public void uploadProfileImage(
			MultipartFile file, UserDto user, String type, String extension, int imageSize) 
					throws IOException {
		String path = conf.get("imagePath") + File.separator + conf.get("profileDir") + File.separator + user.getUserId();
		if (!file.isEmpty()) {
			BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
			File dir = new File(path);
			if(!dir.exists()){
				boolean success = dir.mkdirs();
				if(!success){
					throw new FileExistsException("Could not create directory at this location: " + path); //Exit
				}
			}
			
			String fullPath = path + File.separator + (user.getUserId() + type) + "." + extension;
			File destination = new File(fullPath);
			ImageIO.write(Scalr.resize(src, imageSize), extension, destination);
			persistImagePath(user, type, extension);
		}
	}
	
	/**
	 * Write out image path to the db. Users table.
	 * @param user
	 * @param type
	 * @param extension
	 */
	private void persistImagePath(UserDto user, String type, String extension){
		String baseDir = conf.get("imageBaseDir");
		String profileDir = conf.get("profileDir");
		String path = baseDir + File.separator + profileDir + File.separator + 
				user.getUserId() + File.separator + (user.getUserId() + type) + "." + extension;
		UserDto userDto = userDomainDao.findByUserId(user.getUserId().toString());
		if(Util.IMAGE_MAIN.equals(type)){
			userDto.setMainImagePath(path);
		}else if(Util.IMAGE_THUMB.equals(type)){
			userDto.setThumbImagePath(path);
		}
		userDomainDao.persistUserImagePath(userDto);
	}
}
