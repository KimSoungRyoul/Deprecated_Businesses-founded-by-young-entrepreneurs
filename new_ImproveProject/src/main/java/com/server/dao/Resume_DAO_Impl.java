package com.server.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.server.domain.AttachVo;
import com.server.domain.Resume;
import com.server.domain.pofol.Edu_pofol_Impl_Vo;
import com.server.dto.ResumeDTO;

@Repository
public class Resume_DAO_Impl implements Resume_DAO_IF {

	@Inject
	SqlSession session;

	private static String namespace = "com.server.mapper.resumeMapper";

	@Override
	public void add(Map<String, String> param) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace + ".add", param);
	}

	@Override
	public Resume select(Map<String, String> param) throws Exception {
		// TODO Auto-generated method stub

		return session.selectOne(namespace + ".select", param);

	}

	@Override
	public List<Resume> list(Resume resume) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".list", resume);
	}

	@Override
	public void update(Resume resume) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".update", resume);
	}

	@Override
	public void delete(String uniqueResumeKey) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace + ".delete", uniqueResumeKey);
	}

}
