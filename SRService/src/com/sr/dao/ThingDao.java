package com.sr.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ThingDao {
	List<ThingDto> search(@Param("phrase") String phrase);

	void create(@Param("thing") ThingDto thingDto);

	void vote(@Param("id") BigInteger id, @Param("rate") double rate);
	double getVote(@Param("id") BigInteger id);
}
