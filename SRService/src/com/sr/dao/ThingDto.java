package com.sr.dao;

import java.math.BigInteger;
import java.util.Date;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;

public class ThingDto extends SrDto{
	private BigInteger id;
	private String name;
	private String description;
	private double rate;
	private double numberOfVotes;
	private ThingState state;
	private double authorVote;
	private boolean tweetIt;
	private boolean facebookIt;
	private String mainImagePath;
	private String thumbImagePath;
	private int upperBoundary;
	
	public ThingDto(){}
	
	public ThingDto(String name, ThingState state){
		super();
		this.name = name;
		this.state = state;
	}
	
	public ThingDto(String name, ThingState state, int upperBoundary){
		super();
		this.name = name;
		this.state = state;
		this.upperBoundary = upperBoundary;
	}
	
    public ThingDto(BigInteger id, String name, String description,
			Date createdTime, Date updatedTime, String createdBy,
			String updatedBy, double rate, double numberOfVotes) {
		super(createdTime, updatedTime, createdBy, updatedBy);
		this.id = id;
		this.name = name;
		this.description = description;
		this.rate = rate;
		this.numberOfVotes = numberOfVotes;
	}
    
    public double getCurrentRate(){
    	double numberOfVotes = (this.numberOfVotes <= 0 ? 1 : this.numberOfVotes);
    	double rate = (this.rate <= 0 ? 1 : this.rate);
    	return (rate/numberOfVotes) > upperBoundary ? upperBoundary : (rate/numberOfVotes);
    }
    
    public ThingDto(BigInteger id, String name, String description,
			String createdBy, String updatedBy, double rate, double numberOfVotes) {
		super(new Date(), new Date(), createdBy, updatedBy);
		this.id = id;
		this.name = name;
		this.description = description;
		this.rate = rate;
		this.numberOfVotes = numberOfVotes;
	}
    
    public int getUpperBoundary() {
		return upperBoundary;
	}

	public void setUpperBoundary(int upperBoundary) {
		this.upperBoundary = upperBoundary;
	}

	public String getMainImagePath() {
		return mainImagePath;
	}

	public void setMainImagePath(String mainImagePath) {
		this.mainImagePath = mainImagePath;
	}

	public String getThumbImagePath() {
		return thumbImagePath;
	}

	public void setThumbImagePath(String thumbImagePath) {
		this.thumbImagePath = thumbImagePath;
	}

	public boolean facebookIt() {
		return facebookIt;
	}

	public void setFacebookIt(boolean facebookIt) {
		this.facebookIt = facebookIt;
	}

	public double getAuthorVote() {
		return authorVote;
	}

	public void setAuthorVote(double authorVote) {
		this.authorVote = authorVote;
	}

	public boolean tweetIt() {
		return tweetIt;
	}

	public void setTweetIt(boolean tweetIt) {
		this.tweetIt = tweetIt;
	}

	public double getNumberOfVotes() {
		return numberOfVotes;
	}

	public void setNumberOfVotes(double numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
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
