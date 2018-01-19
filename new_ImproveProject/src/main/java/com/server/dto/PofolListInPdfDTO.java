package com.server.dto;

import java.util.List;

import com.google.gson.Gson;
import com.server.domain.User_Info_Vo;
import com.server.domain.ValueObjcet_IF;
import com.server.domain.pofol.Award_pofol_Impl_Vo;
import com.server.domain.pofol.Edu_pofol_Impl_Vo;
import com.server.domain.pofol.Language_pofol_Impl_Vo;
import com.server.domain.pofol.MainAct_pofol_Impl_Vo;
import com.server.domain.pofol.Military_pofol_Impl_Vo;

import com.server.domain.pofol.Qualifi_pofol_Impl_Vo;

public class PofolListInPdfDTO implements ValueObjcet_IF {

	private User_Info_Vo userVo;
	private List<Edu_pofol_Impl_Vo> eduList;
	private List<Award_pofol_Impl_Vo> awardList;
	private List<Language_pofol_Impl_Vo> languageList;
	private List<MainAct_pofol_Impl_Vo> mainActList;
	private List<Military_pofol_Impl_Vo> militaryList;
	private List<Qualifi_pofol_Impl_Vo> qualifiList;
	private String juso;

	public PofolListInPdfDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	public PofolListInPdfDTO(User_Info_Vo userVo, List<Edu_pofol_Impl_Vo> eduList, List<Award_pofol_Impl_Vo> awardList,
			List<Language_pofol_Impl_Vo> languageList, List<MainAct_pofol_Impl_Vo> mainActList,
			List<Military_pofol_Impl_Vo> militaryList, List<Qualifi_pofol_Impl_Vo> qualifiList, String juso) {
		super();
		this.userVo = userVo;
		this.eduList = eduList;
		this.awardList = awardList;
		this.languageList = languageList;
		this.mainActList = mainActList;
		this.militaryList = militaryList;
		this.qualifiList = qualifiList;
		this.juso = juso;
	}





	@Override
	public String parseTOJSON() {

		return new Gson().toJson(this, PofolListInPdfDTO.class);

	}

	@Override
	public PofolListInPdfDTO parseTOObject(String jsonStr) {

		PofolListInPdfDTO pofolListGet = new Gson().fromJson(jsonStr, PofolListInPdfDTO.class);

		return pofolListGet;
	}

	@Override
	public String toString() {
		return "PofolListInPdfDTO [userVo=" + userVo + ", eduList=" + eduList + ", awardList=" + awardList
				+ ", languageList=" + languageList + ", mainActList=" + mainActList + ", militaryList=" + militaryList
				+ ", qualifiList=" + qualifiList + "]";
	}

	public String getJuso() {
		return juso;
	}

	public void setJuso(String juso) {
		this.juso = juso;
	}

	public List<Edu_pofol_Impl_Vo> getEduList() {
		return eduList;
	}

	public void setEduList(List<Edu_pofol_Impl_Vo> eduList) {
		this.eduList = eduList;
	}

	public List<Award_pofol_Impl_Vo> getAwardList() {
		return awardList;
	}

	public void setAwardList(List<Award_pofol_Impl_Vo> awardList) {
		this.awardList = awardList;
	}

	public List<Language_pofol_Impl_Vo> getLanguageList() {
		return languageList;
	}

	public void setLanguageList(List<Language_pofol_Impl_Vo> languageList) {
		this.languageList = languageList;
	}

	public List<MainAct_pofol_Impl_Vo> getMainActList() {
		return mainActList;
	}

	public void setMainActList(List<MainAct_pofol_Impl_Vo> mainActList) {
		this.mainActList = mainActList;
	}

	public List<Military_pofol_Impl_Vo> getMilitaryList() {
		return militaryList;
	}

	public void setMilitaryList(List<Military_pofol_Impl_Vo> militaryList) {
		this.militaryList = militaryList;
	}

	public List<Qualifi_pofol_Impl_Vo> getQualifiList() {
		return qualifiList;
	}

	public void setQualifiList(List<Qualifi_pofol_Impl_Vo> qualifiList) {
		this.qualifiList = qualifiList;
	}

	public User_Info_Vo getUserVo() {
		return userVo;
	}

	public void setUserVo(User_Info_Vo userVo) {
		this.userVo = userVo;
	}

}
