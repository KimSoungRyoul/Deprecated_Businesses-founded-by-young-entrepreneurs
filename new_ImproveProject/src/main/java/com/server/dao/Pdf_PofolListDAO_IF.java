package com.server.dao;

import java.util.List;
import java.util.Map;

import com.server.domain.pofol.Edu_pofol_Impl_Vo;

public interface Pdf_PofolListDAO_IF {

	public void addEdu(Map<String, Object> param) throws Exception;

	public void addLang(Map<String, Object> param) throws Exception;

	public void addMainAct(Map<String, Object> param) throws Exception;

	public void addAward(Map<String, Object> param) throws Exception;

	public void addQualifi(Map<String, Object> param) throws Exception;
	
	public void addMilitary(Map<String, Object> param)throws Exception;
	

	public List<Edu_pofol_Impl_Vo> getEduList(String uniqueResumeKey);

	public List<Integer> getLangList(String uniqueResumeKey);

	public List<Integer> getMainActList(String uniqueResumeKey);

	public List<Integer> getAwardList(String uniqueResumeKey);

	public List<Integer> getQualifiList(String uniqueResumeKey);

	public List<Integer> getMilitaryList(String uniqueResumeKey);
	
	
	public void deleteEdu(String uniqueResumeKey);
	public void deleteLang(String uniqueResumeKey);
	public void deleteMainAct(String uniqueResumeKey);
	public void deleteQualifi(String uniqueResumeKey);
	public void deleteAward(String uniqueResumeKey);

}
