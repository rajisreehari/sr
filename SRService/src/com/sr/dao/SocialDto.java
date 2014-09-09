package com.sr.dao;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;

import java.util.Date;

public class SocialDto extends SrDto{
	private String userName;
	private String networkName; 
	private String twitterOauthAccessToken; 
	private String twitterOauthAccessTokenSecret;

	public SocialDto(){}

	public SocialDto(String userName, String networkName,
			String twitterOauthAccessToken, String twitterOauthAccessTokenSecret,
			String createdBy, String updatedBy) {
		super(new Date(), new Date(), createdBy, updatedBy);
		this.userName = userName;
		this.networkName = networkName;
		this.twitterOauthAccessToken = twitterOauthAccessToken;
		this.twitterOauthAccessTokenSecret = twitterOauthAccessTokenSecret;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNetworkName() {
		return networkName;
	}
	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}
	public String getTwitterOauthAccessToken() {
		return twitterOauthAccessToken;
	}
	public void setTwitterOauthAccessToken(String twitterOauthAccessToken) {
		this.twitterOauthAccessToken = twitterOauthAccessToken;
	}
	public String getTwitterOauthAccessTokenSecret() {
		return twitterOauthAccessTokenSecret;
	}
	public void setTwitterOauthAccessTokenSecret(
			String twitterOauthAccessTokenSecret) {
		this.twitterOauthAccessTokenSecret = twitterOauthAccessTokenSecret;
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
