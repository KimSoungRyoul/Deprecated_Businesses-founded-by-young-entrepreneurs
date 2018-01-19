package com.server.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.server.domain.AttachVo;

@Repository
public class Attach_DAO_Impl implements Attach_DAO_IF{

	@Inject
	SqlSession session;
	
	private static String namespace ="com.server.mapper.attachMapper";
	
	@Override
	public void add(AttachVo vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".add", vo);
	}

	@Override
	public List<AttachVo> getByA_u_id(String a_u_id) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".getByA_u_id", a_u_id);
	}

	@Override
	public List<AttachVo> getByA_p_no(int a_p_no) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".getByA_p_no", a_p_no);
	}

	@Override
	public List<AttachVo> getByA_b_no(int a_b_no) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".getByA_b_no", a_b_no);
	}

	@Override
	public void deleteByP_no(int a_no) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".deleteByP_no", a_no);
	}

	@Override
	public void deleteProfilePhoto(String a_u_id) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".deleteProfilePhoto", a_u_id);
	}

	@Override
	public void deleteByName(String a_filePath) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".deleteByName", a_filePath);
	}

	

}
