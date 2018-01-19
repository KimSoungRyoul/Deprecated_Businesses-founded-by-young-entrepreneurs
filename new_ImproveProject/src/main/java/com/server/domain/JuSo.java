package com.server.domain;

import org.json.JSONObject;

import com.google.gson.Gson;

public class JuSo implements ValueObjcet_IF {

	private String zipNo; // 집주소
	private String roadAddr; // 도로명주소
	private String jibunAddr; // 지번 주소

	@Override
	public String parseTOJSON() {
		// TODO Auto-generated method stub
		

		return new Gson().toJson(this, JuSo.class);
	}

	@Override
	public JuSo parseTOObject(String jsonStr) {
		

		return new Gson().fromJson(jsonStr, JuSo.class);
	}
	
	@Override
	public String toString() {
		return "JuSo [zipNo=" + zipNo + ", roadAddr=" + roadAddr + ", jibunAddr=" + jibunAddr + "]";
	}
	
	
	
	
		
	

	

	public String getZipNo() {
		return zipNo;
	}

	public void setZipNo(String zipNo) {
		this.zipNo = zipNo;
	}

	public String getRoadAddr() {
		return roadAddr;
	}

	public void setRoadAddr(String roadAddr) {
		this.roadAddr = roadAddr;
	}

	public String getJibunAddr() {
		return jibunAddr;
	}

	public void setJibunAddr(String jibunAddr) {
		this.jibunAddr = jibunAddr;
	}

}
