package com.server.domain;

import org.json.JSONObject;

public class Board_log_Info_Vo implements ValueObjcet_IF {

	private int b_log_no;
	private String b_log_regDate;
	private String b_log_recipient; //로그를 받는사람
	private String b_log_message;
	private boolean b_log_IsRead;

	public Board_log_Info_Vo() {
		// TODO Auto-generated constructor stub

	}
	
	@Override
	public String parseTOJSON() {
		// TODO Auto-generated method stub
		JSONObject obj = new JSONObject();
		
		obj.put("b_log_no", this.b_log_no);
		obj.put("b_log_regDate", this.b_log_regDate);
		obj.put("b_log_recipient", this.b_log_recipient);
		obj.put("b_log_message", this.b_log_message);
		obj.put("b_log_IsRead", this.b_log_IsRead);
		
		return obj.toString();
	}

	@Override
	public Object parseTOObject(String jsonStr) {
		// TODO Auto-generated method stub
		JSONObject obj=new JSONObject(jsonStr);
		Board_log_Info_Vo vo=new Board_log_Info_Vo();
		
		int b_log_no=obj.getInt("b_log_no");
		String b_log_regDate=obj.getString("b_log_regDate");
		String b_log_recipient=obj.getString("b_log_recipient");
		String b_log_message=obj.getString("b_log_message");
		boolean b_log_IsRead=obj.getBoolean("b_log_IsRead");
		
		vo.setB_log_no(b_log_no);
		vo.setB_log_regDate(b_log_regDate);
		vo.setB_log_recipient(b_log_recipient);
		vo.setB_log_message(b_log_message);
		vo.setB_log_IsRead(b_log_IsRead);
		return vo;
	}
	
	
	

	public void createBoardLog(String writer) {
		
		this.setB_log_message(writer+" 님이 회원님의 게시물에 댓글을 달았습니다");				
	}

	public int getB_log_no() {
		return b_log_no;
	}

	public void setB_log_no(int b_log_no) {
		this.b_log_no = b_log_no;
	}

	public String getB_log_regDate() {
		return b_log_regDate;
	}

	public void setB_log_regDate(String b_log_regDate) {
		this.b_log_regDate = b_log_regDate;
	}

	public String getB_log_recipient() {
		return b_log_recipient;
	}

	public void setB_log_recipient(String b_log_recipient) {
		this.b_log_recipient = b_log_recipient;
	}

	public String getB_log_message() {
		return b_log_message;
	}

	public void setB_log_message(String b_log_message) {
		this.b_log_message = b_log_message;
	}

	public boolean isB_log_IsRead() {
		return b_log_IsRead;
	}

	public void setB_log_IsRead(boolean b_log_IsRead) {
		this.b_log_IsRead = b_log_IsRead;
	}

	

}
