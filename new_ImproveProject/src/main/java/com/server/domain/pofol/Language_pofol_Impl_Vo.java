package com.server.domain.pofol;

import com.google.gson.Gson;
import com.server.domain.AttachVo;
import com.server.domain.ValueObjcet_IF;

import org.json.JSONException;

import java.util.List;


public class Language_pofol_Impl_Vo extends Pofol_Abstract implements ValueObjcet_IF {
	/*
 	//서버 통신과 필요한 내용
	private int p_no;
	private String p_type;
	private String p_u_id;
	private String p_regDate;
	
	
	
	
	// ui 필요 내용
	private String p_title;// 시험 이름
	private String p_startDate; //취득일
	private String p_endDate; //null
	private String p_organizer; //증빙 기관
	
	private List<AttachVo> AttachFileList=new LinkedList<AttachVo>(); 
*/  
	
	private String p_examScore;  //시험 점수
	private String p_language; //외국어 종류

	
	
	public Language_pofol_Impl_Vo() {
		// TODO Auto-generated constructor stub
	setP_type("LanguageSkill");
	}
	
	
	public Language_pofol_Impl_Vo(int p_no, String p_type, String p_u_id, String p_regDate, String p_title, String p_startDate,
								  String p_organizer, List<AttachVo> p_attachFileList, String p_actcontent, String p_examScore, String p_language) {
		setP_type("LanguageSkill");
		this.p_no = p_no;
		this.p_type = p_type;
		this.p_u_id = p_u_id;
		this.p_regDate = p_regDate;
		this.p_title = p_title;
		this.p_startDate = p_startDate;
		this.p_actcontent=p_actcontent;
		this.p_organizer = p_organizer;
		this.p_attachFileList = p_attachFileList;
		this.p_examScore = p_examScore;
		this.p_language = p_language;
	}


	public String parseTOJSON() throws JSONException {
		
		return new Gson().toJson(this, Language_pofol_Impl_Vo.class);
			
	}

	public Language_pofol_Impl_Vo parseTOObject(String jsonStr) throws JSONException {
		
		return new Gson().fromJson(jsonStr, Language_pofol_Impl_Vo.class);
	}
	
	
	
	
	
	
	
	
	
	
	

	public String getP_examScore() {
		return p_examScore;
	}
	public void setP_examScore(String p_examScore) {
		this.p_examScore = p_examScore;
	}
	public String getP_language() {
		return p_language;
	}
	public void setP_language(String p_language) {
		this.p_language = p_language;
	}
	
		
	

	
	
	
	
}
