package com.server.domain;

import org.json.JSONObject;

public class Criteria implements ValueObjcet_IF {

	private int page;
	private int perPageNum;

	private String hashtag;

	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public int getPageStart() {
		return (this.page - 1) * perPageNum;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {

		if (perPageNum <= 0 || perPageNum > 100) {
			this.page = 1;
			return;
		}

		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}

	@Override
	public String parseTOJSON() {
		// TODO Auto-generated method stub
		JSONObject obj = new JSONObject();

		obj.put("page", this.page);
		obj.put("perPageNum", this.perPageNum);
		obj.put("hashtag", this.hashtag);
		return obj.toString();
	}

	@Override
	public Criteria parseTOObject(String jsonStr) {
		// TODO Auto-generated method stub
		JSONObject obj = new JSONObject(jsonStr);
		Criteria cri = new Criteria();

		int page = obj.getInt("page");
		int perPageNum = obj.getInt("perPageNum");
		String hashtag = obj.getString("hashtag");

		cri.setPage(page);
		cri.setPerPageNum(perPageNum);
		cri.setHashtag(hashtag);

		return cri;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", hashtag=" + hashtag + "]";
	}

}
