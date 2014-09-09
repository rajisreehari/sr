package com.sr.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ThingDao {
	//Things
	List<ThingDto> search(@Param("phrase") String phrase);
	void create(@Param("thing") ThingDto thingDto);
	List<ThingDto> searchByCreatedBy(@Param("createdBy") String createdBy);
	ThingDto searchById(@Param("id") String id);
	
	//Vote
	void vote(@Param("id") BigInteger id, @Param("rate") double rate);
	double getVote(@Param("id") BigInteger id);
	
	//Thing Comments
	List<ThingCommentDto> getThingComments(@Param("thingId") String thingId);
	void addCommnet(@Param("thingComment") ThingCommentDto thingComment);
	void persistThingImagePath(@Param("thing") ThingDto thingDto);
}
