package com.server.domain;

import com.google.gson.Gson;

public class AttachVo implements ValueObjcet_IF{
	private int a_no;
	private String a_filePath;
	private String a_regDate;
	
	private String a_u_id;  //어떤 계정에 소속되어있는 첨부파일인가    프로필 사진 
	private int a_p_no;   //어던 경력에 소속되어있는 첨부파일인가  포폴 첨부파일
	private int a_b_no;	//게시판 첨부파일
	
	
	public AttachVo(){
		
	}
	
		
	public AttachVo(int a_no, String a_filePath, String a_regDate, String a_u_id, int a_p_no, int a_b_no) {
		super();
		this.a_no = a_no;
		this.a_filePath = a_filePath;
		this.a_regDate = a_regDate;
		this.a_u_id = a_u_id;
		this.a_p_no = a_p_no;
		this.a_b_no = a_b_no;
	}



	public String parseTOJSON(){
		
		
		return  new Gson().toJson(this, AttachVo.class);
			
	}
	
	
	public AttachVo parseTOObject(String jsonStr){
		
				
		return new Gson().fromJson(jsonStr, AttachVo.class);
	}
	
	
	
	
	
	
	
	
	public int getA_no() {
		return a_no;
	}
	public void setA_no(int a_no) {
		this.a_no = a_no;
	}
	public String getA_filePath() {
		return a_filePath;
	}
	public void setA_filePath(String a_filePath) {
		this.a_filePath = a_filePath;
	}
	public String getA_regDate() {
		return a_regDate;
	}
	public void setA_regDate(String a_regDate) {
		this.a_regDate = a_regDate;
	}
	public String getA_u_id() {
		return a_u_id;
	}
	public void setA_u_id(String a_u_id) {
		this.a_u_id = a_u_id;
	}


	public int getA_p_no() {
		return a_p_no;
	}


	public void setA_p_no(int a_p_no) {
		this.a_p_no = a_p_no;
	}


	public int getA_b_no() {
		return a_b_no;
	}


	public void setA_b_no(int a_b_no) {
		this.a_b_no = a_b_no;
	}


	@Override
	public String toString() {
		return "AttachVo [a_no=" + a_no + ", a_filePath=" + a_filePath + ", a_regDate=" + a_regDate + ", a_u_id="
				+ a_u_id + ", a_p_no=" + a_p_no + ", a_b_no=" + a_b_no + "]";
	}
	
		
	
	
}
