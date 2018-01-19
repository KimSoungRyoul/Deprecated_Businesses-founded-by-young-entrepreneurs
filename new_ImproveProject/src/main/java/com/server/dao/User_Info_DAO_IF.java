package com.server.dao;

import java.util.List;

import com.server.domain.User_Info_Vo;

public interface User_Info_DAO_IF {
	
	public void add(User_Info_Vo user)throws Exception;

	public User_Info_Vo get(String u_id,String u_pw)throws Exception;// login 할때 쓸듯
	
	public void update(User_Info_Vo user)throws Exception;
	
	public void delete(String id)throws Exception;

	public List<User_Info_Vo> getByEmail(String u_email);

	public String IsDuplicated(String u_id);

	public User_Info_Vo get2(String p_u_id);

	// 기본 CRUD  (create read update delete)
	
	
	
	
	
	
	
}
