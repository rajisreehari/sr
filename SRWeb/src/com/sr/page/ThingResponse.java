package com.sr.page;

import java.math.BigInteger;
import java.util.List;

import com.sr.dao.ThingCommentDto;
import com.sr.dao.ThingDto;

public class ThingResponse {
	private BigInteger id;
	private String comment;
	private ThingDto thingDto;
	private List<ThingCommentDto> thingComments;

	public ThingResponse(){}
	
	public ThingResponse(ThingDto thingDto) {
		this.thingDto = thingDto;
	}

	public List<ThingCommentDto> getThingComments() {
		return thingComments;
	}

	public void setThingComments(List<ThingCommentDto> thingComments) {
		this.thingComments = thingComments;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public ThingDto getThingDto() {
		return thingDto;
	}

	public void setThingDto(ThingDto thingDto) {
		this.thingDto = thingDto;
	}
}
