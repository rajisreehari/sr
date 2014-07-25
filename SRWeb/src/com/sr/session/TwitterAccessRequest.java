package com.sr.session;

import twitter4j.auth.RequestToken;

public class TwitterAccessRequest {
	private String token;
	private String tokenSecret;
	private String authorizationURL;
	private RequestToken requestToken;

	public TwitterAccessRequest(String token, String tokenSecret,
			String authorizationURL, RequestToken requestToken) {
		this.token = token;
		this.tokenSecret = tokenSecret;
		this.authorizationURL = authorizationURL;
		this.requestToken = requestToken;
	}

	public RequestToken getRequestToken() {
		return requestToken;
	}

	public void setRequestToken(RequestToken requestToken) {
		this.requestToken = requestToken;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTokenSecret() {
		return tokenSecret;
	}

	public void setTokenSecret(String tokenSecret) {
		this.tokenSecret = tokenSecret;
	}

	public String getAuthorizationURL() {
		return authorizationURL;
	}

	public void setAuthorizationURL(String authorizationURL) {
		this.authorizationURL = authorizationURL;
	}
}
