package com.server.dto;

import java.util.List;
import java.util.UUID;

import com.google.gson.Gson;
import com.server.domain.ValueObjcet_IF;

public class ResumeDTO implements ValueObjcet_IF {

	private String uniqueResumeKey;
	private String u_id;

	private List<Integer> eduNoList;
	private List<Integer> awardNoList;
	private List<Integer> langNoList;
	private List<Integer> mainActNoList;
	private List<Integer> militaryNoList;
	private List<Integer> qualifiNoList;

	
	public ResumeDTO() {
		// TODO Auto-generated constructor stub
		
	}
	
	
	
	@Override
	public String parseTOJSON() {
		// TODO Auto-generated method stub
		return new Gson().toJson(this, ResumeDTO.class);
	}

	@Override
	public Object parseTOObject(String jsonStr) {
		// TODO Auto-generated method stub
		return new Gson().fromJson(jsonStr, ResumeDTO.class);
	}

	
	
	
	
	
	
	public String getUniqueResumeKey() {
		return uniqueResumeKey;
	}

	public void setUniqueResumeKey(String uniqueResumeKey) {
		this.uniqueResumeKey = uniqueResumeKey;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public List<Integer> getEduNoList() {
		return eduNoList;
	}

	public void setEduNoList(List<Integer> eduNoList) {
		this.eduNoList = eduNoList;
	}

	public List<Integer> getAwardNoList() {
		return awardNoList;
	}

	public void setAwardNoList(List<Integer> awardNoList) {
		this.awardNoList = awardNoList;
	}

	public List<Integer> getLangNoList() {
		return langNoList;
	}

	public void setLangNoList(List<Integer> langNoList) {
		this.langNoList = langNoList;
	}

	public List<Integer> getMainActNoList() {
		return mainActNoList;
	}

	public void setMainActNoList(List<Integer> mainActNoList) {
		this.mainActNoList = mainActNoList;
	}

	public List<Integer> getMilitaryNoList() {
		return militaryNoList;
	}

	public void setMilitaryNoList(List<Integer> militaryNoList) {
		this.militaryNoList = militaryNoList;
	}

	public List<Integer> getQualifiNoList() {
		return qualifiNoList;
	}

	public void setQualifiNoList(List<Integer> qualifiNoList) {
		this.qualifiNoList = qualifiNoList;
	}

}
