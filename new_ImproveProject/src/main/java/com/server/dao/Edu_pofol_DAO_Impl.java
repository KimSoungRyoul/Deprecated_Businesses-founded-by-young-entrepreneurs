package com.server.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.server.domain.pofol.Edu_pofol_Impl_Vo;

@Repository
public class Edu_pofol_DAO_Impl implements Edu_pofol_DAO_IF {

	@Inject
	SqlSession session;
	
	private static String namespace="com.server.mapper.edu_pofolMapper";
	
	@Override
	public void add(Edu_pofol_Impl_Vo vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".add", vo);
	}

	@Override
	public List<Edu_pofol_Impl_Vo> get(Edu_pofol_Impl_Vo vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".get", vo);
	}
	
	
	@Override
	public void delete(int p_no) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".delete", p_no);
	}

	@Override
	public void update(Edu_pofol_Impl_Vo vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".update", vo);
	}
	

	@Override
	public List<Edu_pofol_Impl_Vo> getAllById(String p_u_id) throws Exception {
		// TODO Auto-generated method stub
		Map<String, String> param=new HashMap<String, String>();
		
		param.put("p_u_id", p_u_id);
		param.put("p_type","EducationHistory");
		
		
		return session.selectList(namespace+".getAllByIdAndType", param);
	}

	@Override
	public void DeleteAll() throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".deleteAll");
	}

	@Override
	public List<Integer> getP_noList(String p_u_id) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".getP_noList", p_u_id);
	}

	
	@Override
	public List<Edu_pofol_Impl_Vo> getPdfEduList(List<Integer> eduList_I) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".getPdfEduList", eduList_I);
	}

	
}
