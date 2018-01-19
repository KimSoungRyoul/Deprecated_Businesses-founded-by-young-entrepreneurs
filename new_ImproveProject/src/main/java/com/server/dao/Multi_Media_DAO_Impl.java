package com.server.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.server.domain.Multi_Media_VO;

@Repository
public class Multi_Media_DAO_Impl implements Multi_Media_DAO_IF{

	@Inject
	SqlSession session;
	
	private static String namespace="com.server.mapper.multiMediaMapper";
	
	
	@Override
	public void add(Multi_Media_VO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".add", vo);
	}

	@Override
	public List<Multi_Media_VO> select(int m_p_no) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".select", m_p_no);
	}

	@Override
	public void delete(String fileName) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".delete", fileName);
	}

}
