package com.sr.dao;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;

import java.util.Date;

public class UserDto extends SrDto{
	private String userName;
	private String password;
	private boolean enabled;
	
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
}
