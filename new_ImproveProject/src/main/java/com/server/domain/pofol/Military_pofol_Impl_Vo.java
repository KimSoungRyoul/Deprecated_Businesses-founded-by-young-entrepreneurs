package com.server.domain.pofol;

import com.google.gson.Gson;

import com.server.domain.ValueObjcet_IF;


import org.json.JSONException;

public class Military_pofol_Impl_Vo extends Pofol_Abstract implements ValueObjcet_IF {

	/*
	 * //서버 통신과 필요한 내용 private int p_no; private String p_type; private String
	 * p_u_id; private String p_regDate;
	 * 
	 * 
	 * // ui 필요 내용 private String p_title; //militartType private String
	 * p_startDate; //입대일 private String p_endDate; //전역일 private String
	 * p_organizer; //계급 protected String p_act_content;
	 * 
	 * private List<AttachVo> AttachFileList=new LinkedList<AttachVo>();
	 */

	public Military_pofol_Impl_Vo() {
		// TODO Auto-generated constructor stub
		setP_type("MilitarySpec");
	}

	public Military_pofol_Impl_Vo(int p_no, String p_type, String p_u_id, String p_regDate, String p_title,
			String p_startDate, String p_endDate, String p_organizer, String p_act_content) {
		setP_type("MilitarySpec");
		this.p_no = p_no;
		this.p_type = p_type;
		this.p_u_id = p_u_id;
		this.p_regDate = p_regDate;
		this.p_title = p_title;
		this.p_startDate = p_startDate;
		this.p_endDate = p_endDate;
		this.p_organizer = p_organizer;
		this.p_actcontent = p_act_content;
	}

	@Override
	public String parseTOJSON() throws JSONException {
		// TODO Auto-generated method stub

		return new Gson().toJson(this, Military_pofol_Impl_Vo.class);

	}

	@Override
	public Military_pofol_Impl_Vo parseTOObject(String jsonStr) throws JSONException {

		return new Gson().fromJson(jsonStr, Military_pofol_Impl_Vo.class);
	}

}
