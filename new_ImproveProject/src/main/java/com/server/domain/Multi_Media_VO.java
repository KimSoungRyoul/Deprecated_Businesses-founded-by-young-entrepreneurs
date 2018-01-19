package com.server.domain;

import org.json.JSONObject;

import com.google.gson.Gson;

public class Multi_Media_VO implements ValueObjcet_IF {

	private int m_no;
	private String m_filePath;
	private String m_regDate;
	private int m_p_no;

	public Multi_Media_VO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String parseTOJSON() {
			
		return new Gson().toJson(this,Multi_Media_VO.class);
	}

	@Override
	public Multi_Media_VO parseTOObject(String jsonStr) {
				
		return new Gson().fromJson(jsonStr, Multi_Media_VO.class);
	}
	
	

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getM_filePath() {
		return m_filePath;
	}

	public void setM_filePath(String m_filePath) {
		this.m_filePath = m_filePath;
	}

	public String getM_regDate() {
		return m_regDate;
	}

	public void setM_regDate(String m_regDate) {
		this.m_regDate = m_regDate;
	}

	public int getM_p_no() {
		return m_p_no;
	}

	public void setM_p_no(int m_p_no) {
		this.m_p_no = m_p_no;
	}

}
