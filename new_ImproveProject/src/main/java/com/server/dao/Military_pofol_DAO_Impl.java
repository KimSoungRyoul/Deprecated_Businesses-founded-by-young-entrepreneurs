package com.server.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.server.domain.pofol.Military_pofol_Impl_Vo;

@Repository
public class Military_pofol_DAO_Impl implements Military_pofol_DAO_IF {

	@Inject
	SqlSession session;

	private static String namespace = "com.server.mapper.military_pofolMapper";

	@Override
	public void add(Military_pofol_Impl_Vo vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace + ".add", vo);
	}

	@Override
	public void delete(int p_no) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace + ".delete", p_no);
	}

	@Override
	public void update(Military_pofol_Impl_Vo vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".update", vo);
	}

	@Override
	public List<Military_pofol_Impl_Vo> getAllById(String p_u_id) throws Exception {
		Map<String, String> param = new HashMap<String, String>();

		param.put("p_u_id", p_u_id);
		param.put("p_type", "MilitarySpec");

		return session.selectList(namespace + ".getAllByIdAndType", param);
	}

	@Override
	public List<Military_pofol_Impl_Vo> get(Military_pofol_Impl_Vo vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".get", vo);
	}

}
