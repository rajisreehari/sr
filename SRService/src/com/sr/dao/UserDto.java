package com.sr.dao;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class UserDto extends SrDto{
	private BigDecimal userId;
	private String userName;
	private String password;
	private boolean enabled;
	private String firstName;
	private String lastName;
	private String gender;
	private Date dateOfBirth;
	private String mainImagePath;
	private String thumbImagePath;
	private List<ThingDto> things;
	
	public UserDto(){}
	
	public UserDto(String userName, String password, boolean enabled, String createdBy, String updatedBy) {
		super(new Date(), new Date(), createdBy, updatedBy);
		this.userName = userName;
		this.password = password;
		this.enabled = enabled;
	}

	public UserDto(String userName, String password, boolean enabled, Date createdTime, Date updatedTime, String createdBy, String updatedBy) {
		super(createdTime, updatedTime, createdBy, updatedBy);
		this.userName = userName;
		this.password = password;
		this.enabled = enabled;
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

	public BigDecimal getUserId() {
		return userId;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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

	public void setThings(List<ThingDto> things) {
		this.things = things;
	}
	
	public List<ThingDto> getThings(){
		return things;
	}
	
	public boolean hasThings(){
		if(things == null || things.size() <= 0){
			return false;
		}
		return true;
	}
}
