package com.sr.dao;

import java.math.BigInteger;
import java.util.Date;

public class ThingCommentDto extends SrDto{
	private BigInteger id;
	private String thingId;
	private String comment;
	
	public ThingCommentDto() {
		super();
	}

	public ThingCommentDto(String thingId, String comment, String createdBy, String updatedBy) {
		super(new Date(), new Date(), createdBy, updatedBy);
		this.thingId = thingId;
		this.comment = comment;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getThingId() {
		return thingId;
	}

	public void setThingId(String thingId) {
		this.thingId = thingId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
