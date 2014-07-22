package com.sr.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserDao {
	List<ThingDto> findById(@Param("id") BigInteger id);
	void createUser(@Param("user") UserDto userDto);
	void createUserAuthority(@Param("userAuthority") UserAuthorityDto userAuthority);
}
