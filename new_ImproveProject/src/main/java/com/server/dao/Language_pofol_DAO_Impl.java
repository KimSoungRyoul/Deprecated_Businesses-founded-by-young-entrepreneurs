package com.server.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.server.domain.pofol.Language_pofol_Impl_Vo;

@Repository
public class Language_pofol_DAO_Impl implements Language_pofol_DAO_IF {

	@Inject
	SqlSession session;
	
	private static String namespace="com.server.mapper.language_pofolMapper";
	
	@Override
	public void add(Language_pofol_Impl_Vo vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".add", vo);
	}
	
	@Override
	public List<Language_pofol_Impl_Vo> get(Language_pofol_Impl_Vo vo) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".get", vo);
	}

	@Override
	public void delete(int p_no) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".delete", p_no);
	}

	@Override
	public void update(Language_pofol_Impl_Vo vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".update", vo);
	}

	
	@Override
	public List<Language_pofol_Impl_Vo> getAllById(String p_u_id) throws Exception {
		// TODO Auto-generated method stub
		Map<String, String> param=new HashMap<String, String>();
		
		param.put("p_u_id", p_u_id);
		param.put("p_type", "LanguageSkill");
		
		
		return session.selectList(namespace+".getAllByIdAndType", param);
	}

	@Override
	public List<Language_pofol_Impl_Vo> getPdfLangList(List<Integer> langList_I) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".getPdfLangList", langList_I);
	}

	

}