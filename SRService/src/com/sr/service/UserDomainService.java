package com.sr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sr.dao.SocialDto;
import com.sr.dao.UserAuthorityDto;
import com.sr.dao.UserDomainDao;
import com.sr.dao.UserDto;

@Component
public class UserDomainService {
	public static final String SESSION_USER = "sessionUser";
	
	private UserDomainDao userDomainDao;
	
	@Autowired
	public UserDomainService(UserDomainDao userDao){
		this.userDomainDao = userDao;
	}
	
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
}
