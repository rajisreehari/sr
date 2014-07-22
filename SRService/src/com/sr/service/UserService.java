package com.sr.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sr.dao.ThingDto;
import com.sr.dao.UserAuthorityDto;
import com.sr.dao.UserDao;
import com.sr.dao.UserDto;

@Component
public class UserService {
	private UserDao userDao;
	
	@Autowired
	public UserService(UserDao userDao){
		this.userDao = userDao;
	}
	
	public List<ThingDto> search(BigInteger id){
		return userDao.findById(id); 
	}

	@Transactional
	public void create(UserDto userDto) {
		userDao.createUser(userDto);
		userDao.createUserAuthority(new UserAuthorityDto(userDto.getUserName(), UserAuthorityDto.ROLE_USER, userDto.getUserName(), userDto.getUserName()));
	}
}
