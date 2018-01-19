package com.server.dto;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.server.domain.ValueObjcet_IF;

public class LoginDTO implements ValueObjcet_IF {

	private String u_id;
	private String u_pw;

	public LoginDTO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String parseTOJSON() {
		// TODO Auto-generated method stub
		return new Gson().toJson(this, LoginDTO.class);
	}

	@Override
	public LoginDTO parseTOObject(String jsonStr) {
		return new Gson().fromJson(jsonStr, LoginDTO.class);
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_pw() {
		return u_pw;
	}

	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}

}
