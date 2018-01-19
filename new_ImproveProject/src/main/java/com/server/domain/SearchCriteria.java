package com.server.domain;

public class SearchCriteria extends Criteria {
	
	private String hashTag;

	public String getHashTag() {
		return hashTag;
	}

	public void setHashTag(String hashTag) {
		this.hashTag = hashTag;
	}

	
	
	@Override
	public String toString() {
		
		return "SearchCriteria [hashTag=" + hashTag + "]";
	}
	
	
	
}
