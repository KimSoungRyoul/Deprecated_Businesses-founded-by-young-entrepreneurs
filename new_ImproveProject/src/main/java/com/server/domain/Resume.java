package com.server.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.server.domain.pofol.Award_pofol_Impl_Vo;
import com.server.domain.pofol.Edu_pofol_Impl_Vo;
import com.server.domain.pofol.Language_pofol_Impl_Vo;
import com.server.domain.pofol.MainAct_pofol_Impl_Vo;
import com.server.domain.pofol.Military_pofol_Impl_Vo;
import com.server.domain.pofol.Qualifi_pofol_Impl_Vo;

public class Resume implements ValueObjcet_IF {

	private String uniqueResumeKey;
		
	private User_Info_Vo userVo;
	private List<Edu_pofol_Impl_Vo> eduList;
	private List<Award_pofol_Impl_Vo> awardList;
	private List<Language_pofol_Impl_Vo> languageList;
	private List<MainAct_pofol_Impl_Vo> mainActList;
	private List<Military_pofol_Impl_Vo> militaryList;
	private List<Qualifi_pofol_Impl_Vo> qualifiList;

	public Resume() {
		// TODO Auto-generated constructor stub
	}

	public Map<String, List> getGrouping(){
		Map<String, List> result = new HashMap<String,List>();
		result.put("어학능력", languageList);
		result.put("수상내역", awardList);
		result.put("주요활동", mainActList);
		result.put("자격사항", qualifiList);
		
		return result;
	}
	
	public Map<String, String> getH2Grouping(){
		Map<String, String> result = new HashMap<String,String>();
		result.put("어학능력", "lg");
		result.put("주요활동", "ac");
		result.put("수상내역", "pz");
		result.put("자격사항", "qf");
		return result;
	}
	
		
	public Resume(User_Info_Vo userVo, List<Edu_pofol_Impl_Vo> eduList, List<Award_pofol_Impl_Vo> awardList,
			List<Language_pofol_Impl_Vo> languageList, List<MainAct_pofol_Impl_Vo> mainActList,
			List<Military_pofol_Impl_Vo> militaryList, List<Qualifi_pofol_Impl_Vo> qualifiList) {
		super();
		this.userVo = userVo;
		this.eduList = eduList;
		this.awardList = awardList;
		this.languageList = languageList;
		this.mainActList = mainActList;
		this.militaryList = militaryList;
		this.qualifiList = qualifiList;
	}

	@Override
	public String parseTOJSON() {
		// TODO Auto-generated method stub
		return new Gson().toJson(this, Resume.class);
	}

	@Override
	public Object parseTOObject(String jsonStr) {
		// TODO Auto-generated method stub
		return new Gson().fromJson(jsonStr, Resume.class);
	}

	
	
	
	
	
	

	@Override
	public String toString() {
		return "Resume [uniqueResumeKey=" + uniqueResumeKey + ", userVo=" + userVo + ", eduList=" + eduList
				+ ", awardList=" + awardList + ", languageList=" + languageList + ", mainActList=" + mainActList
				+ ", militaryList=" + militaryList + ", qualifiList=" + qualifiList + "]";
	}

	public String getUniqueResumeKey() {
		return uniqueResumeKey;
	}

	public void setUniqueResumeKey(String uniqueResumeKey) {
		this.uniqueResumeKey = uniqueResumeKey;
	}

	public User_Info_Vo getUserVo() {
		return userVo;
	}

	public void setUserVo(User_Info_Vo userVo) {
		this.userVo = userVo;
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

}
