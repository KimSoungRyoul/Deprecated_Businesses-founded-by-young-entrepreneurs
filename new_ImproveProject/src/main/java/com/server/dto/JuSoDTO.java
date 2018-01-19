package com.server.dto;

import org.json.JSONObject;

import com.server.domain.ValueObjcet_IF;

public class JuSoDTO implements ValueObjcet_IF {

	private String currentPage;
	private String countPerPage;
	private String confmKey;
	private String keyword;

	@Override
	public String parseTOJSON() {
		// TODO Auto-generated method stub
		JSONObject obj=new JSONObject();
		
		obj.put("currentPage", this.currentPage);
		obj.put("countPerPage", this.countPerPage);
		obj.put("confmKey", this.confmKey);
		obj.put("keyword", this.keyword);
		
		
		return obj.toString();
	}

	@Override
	public JuSoDTO parseTOObject(String jsonStr) {
		// TODO Auto-generated method stub
		JSONObject obj=new JSONObject(jsonStr);
		JuSoDTO dto=new JuSoDTO();
		
		String currentPage=obj.getString("currentPage");
		String countPerPage=obj.getString("countPerPage");
		String confmKey=obj.getString("confmKey");
		String keyword=obj.getString("keyword");
		
		dto.setCurrentPage(currentPage);
		dto.setCountPerPage(countPerPage);
		dto.setConfmKey(confmKey);
		dto.setKeyword(keyword);
		
		return dto;
	}
	
	
	
	//------------------------------------------------------

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public String getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(String countPerPage) {
		this.countPerPage = countPerPage;
	}

	public String getConfmKey() {
		return confmKey;
	}

	public void setConfmKey(String confmKey) {
		this.confmKey = confmKey;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "JuSoDTO [currentPage=" + currentPage + ", countPerPage=" + countPerPage + ", confmKey=" + confmKey
				+ ", keyword=" + keyword + "]";
	}
	
	
	
	
	
	
	
	
}
