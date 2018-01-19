package com.server.dao;

import java.util.List;

public interface Pofol_DAO_IF {
	
	public void add(Object vo)throws Exception;
	
	public void delete(int p_no)throws Exception;
	
	public void update(Object vo)throws Exception;
	
	//public List<Object> getAllById(String p_u_id)throws Exception;
	
	public List<Object> getAllById(String p_u_id, String p_type)throws Exception; 
	//타입은 각 Impl마다 강제 지정 

	public void deleteById(String u_id)throws Exception;
	
	
}
