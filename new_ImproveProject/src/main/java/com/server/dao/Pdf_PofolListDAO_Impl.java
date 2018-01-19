package com.server.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.server.domain.pofol.Edu_pofol_Impl_Vo;

@Repository
public class Pdf_PofolListDAO_Impl implements Pdf_PofolListDAO_IF {

	@Inject
	SqlSession session;

	private static String namespace = "com.server.mapper.pdf_pofolListMapper";

	@Override
	public void addEdu(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub

		session.insert(namespace + ".addEdu", param);
	}

	@Override
	public void addLang(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub

		session.insert(namespace + ".addLang", param);

	}

	@Override
	public void addMainAct(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub

		session.insert(namespace + ".addMainAct", param);

	}

	@Override
	public void addAward(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub

		session.insert(namespace + ".addAward", param);

	}

	@Override
	public void addQualifi(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub

		session.insert(namespace + ".addQualifi", param);

	}

	@Override
	public void addMilitary(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".addMilitary", param);
	}

	@Override
	public List<Edu_pofol_Impl_Vo> getEduList(String uniqueResumeKey) {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".getEduList", uniqueResumeKey);
	}

	@Override
	public List<Integer> getLangList(String uniqueResumeKey) {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".getLangList", uniqueResumeKey);
	}

	@Override
	public List<Integer> getMainActList(String uniqueResumeKey) {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".getMainActList", uniqueResumeKey);
	}

	@Override
	public List<Integer> getAwardList(String uniqueResumeKey) {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".getAwardList", uniqueResumeKey);
	}

	@Override
	public List<Integer> getQualifiList(String uniqueResumeKey) {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".getQualifiList", uniqueResumeKey);
	}

	@Override
	public List<Integer> getMilitaryList(String uniqueResumeKey) {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".getMilitaryList", uniqueResumeKey);
	}

	@Override
	public void deleteEdu(String uniqueResumeKey) {
		// TODO Auto-generated method stub
		session.delete(namespace + ".deleteEdu", uniqueResumeKey);
	}

	@Override
	public void deleteLang(String uniqueResumeKey) {
		// TODO Auto-generated method stub
		session.delete(namespace + ".deleteLang", uniqueResumeKey);
	}

	@Override
	public void deleteMainAct(String uniqueResumeKey) {
		// TODO Auto-generated method stub
		session.delete(namespace + ".deleteMainAct", uniqueResumeKey);
	}

	@Override
	public void deleteQualifi(String uniqueResumeKey) {
		// TODO Auto-generated method stub
		session.delete(namespace + ".deleteQualifi", uniqueResumeKey);
	}

	@Override
	public void deleteAward(String uniqueResumeKey) {
		// TODO Auto-generated method stub
		session.delete(namespace + ".deleteAward", uniqueResumeKey);
	}

}
