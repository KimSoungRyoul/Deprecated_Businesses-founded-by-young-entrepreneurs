package com.server.dto;

import org.json.JSONObject;


import com.server.domain.ValueObjcet_IF;

public class HashTagDTO implements ValueObjcet_IF{
	
	private int boardCnt;
	private String h_tagname;
	
		
	@Override
	public String parseTOJSON() {
		// TODO Auto-generated method stub
		JSONObject obj = new JSONObject();
		obj.put("h_tagname",this.getH_tagname() );
		obj.put("boardCnt", this.getBoardCnt());
		
		return obj.toString();
	}
	@Override
	public Object parseTOObject(String jsonStr) {
		// TODO Auto-generated method stub
		JSONObject obj=new JSONObject(jsonStr);
		HashTagDTO dto=new HashTagDTO();
		
		int boardCnt=obj.getInt("boardCnt");
		String h_tagname=obj.getString("h_tagname");
				
		dto.setBoardCnt(boardCnt);
		dto.setH_tagname(h_tagname);
				
		return dto;
	}
	
	
	
	
	
	
	
	public String getH_tagname() {
		return h_tagname;
	}
	public void setH_tagname(String h_tagname) {
		this.h_tagname = h_tagname;
	}
	public int getBoardCnt() {
		return boardCnt;
	}
	public void setBoardCnt(int boardCnt) {
		this.boardCnt = boardCnt;
	}
	@Override
	public String toString() {
		return "HashTagDTO [boardCnt=" + boardCnt + ", h_tagname=" + h_tagname + "]";
	}
	
	
	
	
	
}
