package com.server.dto;

import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.server.domain.ValueObjcet_IF;

public class UploadFileDTO implements ValueObjcet_IF{
	private MultipartFile file;
	private int a_p_no;
	private String a_u_id;
	
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public int getA_p_no() {
		return a_p_no;
	}
	public void setA_p_no(int a_p_no) {
		this.a_p_no = a_p_no;
	}
	public String getA_u_id() {
		return a_u_id;
	}
	public void setA_u_id(String a_u_id) {
		this.a_u_id = a_u_id;
	}
	
	
	@Override
	public String parseTOJSON() {
		// TODO Auto-generated method stub
		
		return new Gson().toJson(this, UploadFileDTO.class);
	}
	
	
	
	@Override
	public UploadFileDTO parseTOObject(String jsonStr) {
		// TODO Auto-generated method stub
		return new Gson().fromJson(jsonStr, UploadFileDTO.class);
	}

	
}