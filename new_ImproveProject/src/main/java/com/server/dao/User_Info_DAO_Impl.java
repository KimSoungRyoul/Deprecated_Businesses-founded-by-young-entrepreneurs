package com.server.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.server.domain.User_Info_Vo;

@Repository
public class User_Info_DAO_Impl implements User_Info_DAO_IF{
	
	@Inject
	SqlSession session;
	
	private static String namespace = "com.server.mapper.UserMapper";
	
	
	@Override
	public void add(User_Info_Vo user)throws Exception{
		// TODO Auto-generated method stub
		
			session.insert(namespace+".add", user);
		
	}

	@Override
	public User_Info_Vo get(String u_id,String u_pw) throws Exception {
		// TODO Auto-generated method stub
		Map<String, String> param=new HashMap<String, String>();
		param.put("u_id", u_id);
		param.put("u_pw", u_pw);
		return session.selectOne(namespace+".get", param);
	}

	@Override
	public void update(User_Info_Vo user) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".update", user);
	}

	@Override
	public void delete(String u_id) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".delete", u_id);
		
	}

	@Override
	public List<User_Info_Vo> getByEmail(String u_email) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".getByEmail", u_email);
	}

	@Override
	public String IsDuplicated(String u_id) {
		// TODO Auto-generated method stub
		
		String id= session.selectOne(namespace+".IsDuplicated",u_id);
		
		if(id!=null){
			return "DUPLICATED";
		}else {
			return "SUCCESS";
		}
		
		
		
	}

	@Override
	public User_Info_Vo get2(String p_u_id) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".get2", p_u_id);
	}
	
}
