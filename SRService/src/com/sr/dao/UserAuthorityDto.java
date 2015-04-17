package com.sr.dao;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;

import java.util.Date;

public class UserAuthorityDto extends SrGenericPropertiesDto{
	public static final String ROLE_USER = "ROLE_USER";
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String UNKNOWN = "UNKNOWN";
	
	private String userName;
	private String authority;
	public UserAuthorityDto(String userName, String authority, String createdBy, String updatedBy) {
		super(new Date(), new Date(), createdBy, updatedBy);
		this.userName = userName;
		this.authority = authority;
	}
	public UserAuthorityDto(String userName, String authority, Date createdTime, Date updatedTime, String createdBy, String updatedBy) {
		super(createdTime, updatedTime, createdBy, updatedBy);
		this.userName = userName;
		this.authority = authority;
	}
	public UserAuthorityDto(String userName, String authority) {
		super(new Date(), new Date(), UNKNOWN, UNKNOWN);
		this.userName = userName;
		this.authority = authority;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
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
