package com.server.dto;

import org.json.JSONObject;

import com.server.domain.ValueObjcet_IF;

public class BoardDTO implements ValueObjcet_IF{
	int b_no;
	String like_id;
	
	
	@Override
	public String parseTOJSON() {
		// TODO Auto-generated method stub
		JSONObject obj=new JSONObject();
		
		obj.put("like_id", like_id);
		obj.put("b_no", b_no);
		
		
		
		return obj.toString();
	}
	@Override
	public Object parseTOObject(String jsonStr) {
		// TODO Auto-generated method stub
		JSONObject obj=new JSONObject(jsonStr);
		
		BoardDTO dto=new BoardDTO();
		
		int b_no=obj.getInt("b_no");
		String liked_id=obj.getString("like_id");
		
		dto.setB_no(b_no);
		dto.setLike_id(liked_id);
		
		return dto;
	}
	
	
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public String getLike_id() {
		return like_id;
	}
	public void setLike_id(String like_id) {
		this.like_id = like_id;
	}
	
	
}
