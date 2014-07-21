package com.sr.dao;

import java.math.BigInteger;
import java.util.Date;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;

public class ThingDto {
	private BigInteger id;
	private String name;
	private String description;
	private Date createdTime;
	private Date updatedTime;
	private String createdBy;
	private String updatedBy;
	private double rate;
	private ThingState state;
	
	public ThingDto(){}
	
	public ThingDto(String name, ThingState state){
		super();
		this.name = name;
		this.state = state;
	}
	
    public ThingDto(BigInteger id, String name, String description,
			Date createdTime, Date updatedTime, String createdBy,
			String updatedBy, double rate) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.rate = rate;
	}
    
    public ThingState getState(){
    	return state;
    }

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
    public String toString() {
        return reflectionToString(this);
    }

    @Override
    public boolean equals(Object o) {
        return reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return reflectionHashCode(this);
    }
}
