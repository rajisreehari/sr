package com.sr.page;

import java.util.List;

import com.sr.dao.ThingDto;

public class SearchResponse {
	private List<ThingDto> searchResults;
	private boolean myAccount;
	private String userName;
	private boolean requestTwitterAccess;
	private String twitterErrorMessage;
	
	public SearchResponse(List<ThingDto> searchResults) {
		super();
		this.searchResults = searchResults;
	}
	
	public SearchResponse(List<ThingDto> searchResults, boolean myAccount) {
		super();
		this.searchResults = searchResults;
		this.myAccount = myAccount;
	}

	public SearchResponse(List<ThingDto> searchResults, boolean myAccount,
			String userName) {
		super();
		this.searchResults = searchResults;
		this.myAccount = myAccount;
		this.userName = userName;
	}

	public SearchResponse(List<ThingDto> searchResults, String userName) {
		super();
		this.searchResults = searchResults;
		this.userName = userName;
	}

	public SearchResponse(List<ThingDto> searchResults, boolean myAccount,
			String userName, boolean requestTwitterAccess) {
		super();
		this.searchResults = searchResults;
		this.myAccount = myAccount;
		this.userName = userName;
		this.requestTwitterAccess = requestTwitterAccess;
	}

	public SearchResponse(List<ThingDto> searchResults, boolean myAccount,
			String userName, boolean requestTwitterAccess, String twitterErrorMessage) {
		super();
		this.searchResults = searchResults;
		this.myAccount = myAccount;
		this.userName = userName;
		this.requestTwitterAccess = requestTwitterAccess;
		this.twitterErrorMessage = twitterErrorMessage;
	}

	public String getTwitterErrorMessage() {
		return twitterErrorMessage;
	}
	public void setTwitterErrorMessage(String twitterErrorMessage) {
		this.twitterErrorMessage = twitterErrorMessage;
	}
	public boolean getRequestTwitterAccess() {
		return requestTwitterAccess;
	}
	public void setRequestTwitterAccess(boolean requestTwitterAccess) {
		this.requestTwitterAccess = requestTwitterAccess;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean isMyAccount() {
		return myAccount;
	}
	public void setMyAccount(boolean myAccount) {
		this.myAccount = myAccount;
	}
	public List<ThingDto> getSearchResults() {
		return searchResults;
	}
	public void setSearchResults(List<ThingDto> searchResults) {
		this.searchResults = searchResults;
	}
}
