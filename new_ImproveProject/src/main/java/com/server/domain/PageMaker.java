package com.server.domain;

import org.json.JSONObject;

public class PageMaker implements ValueObjcet_IF {

	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;

	private boolean maxPrev;
	private boolean maxNext;

	private int displayPageNum = 5;

	private Criteria cri;

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;

		calcData();
	}

	private void calcData() {

		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);

		startPage = (endPage - displayPageNum) + 1;

		int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));

		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}

		prev = startPage == 1 ? false : true;

		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
		
		maxPrev=startPage==1 ? false : true;
		maxNext=endPage * cri.getPerPageNum() >= totalCount ? false : true;
		
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}




	public boolean isMaxPrev() {
		return maxPrev;
	}

	public void setMaxPrev(boolean maxPrev) {
		this.maxPrev = maxPrev;
	}

	public boolean isMaxNext() {
		return maxNext;
	}

	public void setMaxNext(boolean maxNext) {
		this.maxNext = maxNext;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	@Override
	public String parseTOJSON() {
		// TODO Auto-generated method stub
		JSONObject obj = new JSONObject();

		obj.put("totalCount", this.totalCount);
		obj.put("startPage", this.startPage);
		obj.put("endPage", this.endPage);
		obj.put("prev", this.prev);
		obj.put("next", this.next);
		obj.put("maxPrev", this.maxPrev);
		obj.put("maxNext", this.maxNext);
		
		Criteria cri = this.getCri();

		// cri.parseTOJSON();
		String jStr = obj.toString().replace("}", ",\"cri\":");
		jStr = jStr.concat(cri.parseTOJSON()) + "}";

		return jStr;

	}

	@Override
	public PageMaker parseTOObject(String jsonStr) {
		// TODO Auto-generated method stub
		JSONObject obj = new JSONObject(jsonStr);
		PageMaker pageMaker = new PageMaker();

		Criteria cri = new Criteria();

		int criStrStart = jsonStr.indexOf("cri") + 5;
		String criStr = jsonStr.substring(criStrStart, jsonStr.length() - 1);
		cri = cri.parseTOObject(criStr);

		pageMaker.setCri(cri);
		int totalCount = obj.getInt("totalCount");

		pageMaker.setTotalCount(totalCount);

		/*
		 * int totalCount=obj.getInt("totalCount"); int
		 * startPage=obj.getInt("startPage"); int endPage=obj.getInt("endPage");
		 * boolean prev=obj.getBoolean("prev"); boolean
		 * next=obj.getBoolean("nextobj");
		 */

		return pageMaker;
	}

	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", maxPrev=" + maxPrev + ", maxNext=" + maxNext + ", displayPageNum="
				+ displayPageNum + ", cri=" + cri + "]";
	}

	

	/*
	 * public String makeQuery(int page) {
	 * 
	 * UriComponents uriComponents =
	 * UriComponentsBuilder.newInstance().queryParam("page", page)
	 * .queryParam("perPageNum", cri.getPerPageNum()).build();
	 * 
	 * return uriComponents.toUriString(); }
	 * 
	 * 
	 * public String makeSearch(int page){
	 * 
	 * UriComponents uriComponents = UriComponentsBuilder.newInstance()
	 * .queryParam("page", page) .queryParam("perPageNum", cri.getPerPageNum())
	 * .queryParam("searchType", ((SearchCriteria)cri).getSearchType())
	 * .queryParam("keyword", ((SearchCriteria)cri).getKeyword()) .build();
	 * 
	 * return uriComponents.toUriString(); }
	 */
}
