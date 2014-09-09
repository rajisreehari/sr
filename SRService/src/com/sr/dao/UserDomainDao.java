package com.sr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserDomainDao {
	void createUser(@Param("user") UserDto userDto);
	void createUserAuthority(@Param("userAuthority") UserAuthorityDto userAuthority);
	UserDto findByUserName(@Param("userName") String userName);
	List<SocialDto> findSocialByUserName(@Param("userName") String userName);
	void updateTwitterCredentials(@Param("social") SocialDto social);
	void updateUser(@Param("user") UserDto user);
	void persistUserImagePath(@Param("user") UserDto userDto);
	UserDto findByUserId(@Param("userId") String userId);
}
