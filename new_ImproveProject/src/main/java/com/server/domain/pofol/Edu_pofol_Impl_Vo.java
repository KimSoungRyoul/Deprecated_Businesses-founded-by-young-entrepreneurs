package com.server.domain.pofol;

import com.google.gson.Gson;
import com.server.domain.AttachVo;
import com.server.domain.ValueObjcet_IF;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class Edu_pofol_Impl_Vo extends Pofol_Abstract implements ValueObjcet_IF {
	/*
	 * //서버 통신과 필요한 내용 private int p_no; private String p_type; private String
	 * p_u_id; private String p_regDate;
	 * 
	 * 
	 * // ui 필요 내용 private String p_title; //학교명 private String p_startDate;
	 * //시작일 private String p_endDate; //종료일 private String p_organizer; //null
	 * 
	 * private List<AttachVo> AttachFileList=new LinkedList<AttachVo>();
	 */ private String p_major; // 전공
	private String p_completeType; // 이수구분

	public Edu_pofol_Impl_Vo() {
		// TODO Auto-generated constructor stub
		setP_type("EducationHistory");
	}

	public Edu_pofol_Impl_Vo(int p_no, String p_type, String p_u_id, String p_regDate, String p_title,
			String p_startDate, String p_endDate, List<AttachVo> p_attachFileList, String p_actcontent, String p_major,
			String p_completeType) {
		setP_type("EducationHistory");
		this.p_no = p_no;
		this.p_type = p_type;
		this.p_u_id = p_u_id;
		this.p_regDate = p_regDate;
		this.p_title = p_title;
		this.p_startDate = p_startDate;
		this.p_endDate = p_endDate;
		this.p_actcontent = p_actcontent;
		this.p_attachFileList = p_attachFileList;
		this.p_major = p_major;
		this.p_completeType = p_completeType;

	}

	public String parseTOJSON() throws JSONException {

		return new Gson().toJson(this, Edu_pofol_Impl_Vo.class);
	}

	public Edu_pofol_Impl_Vo parseTOObject(String jsonStr) throws JSONException {

		return new Gson().fromJson(jsonStr, Edu_pofol_Impl_Vo.class);
	}

	public String getP_major() {
		return p_major;
	}

	public void setP_major(String p_major) {
		this.p_major = p_major;
	}

	public String getP_completeType() {
		return p_completeType;
	}

	public void setP_completeType(String p_completeType) {
		this.p_completeType = p_completeType;
	}

}
