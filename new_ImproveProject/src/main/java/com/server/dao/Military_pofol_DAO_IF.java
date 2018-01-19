package com.server.dao;

import java.util.List;

import com.server.domain.pofol.Military_pofol_Impl_Vo;



public interface Military_pofol_DAO_IF {
	
	public void add(Military_pofol_Impl_Vo vo) throws Exception;
	
	public List<Military_pofol_Impl_Vo> get(Military_pofol_Impl_Vo vo)throws Exception;

	public void delete(int p_no) throws Exception;

	public void update(Military_pofol_Impl_Vo vo) throws Exception;

	// public List<Object> getAllById(String p_u_id)throws Exception;

	public List<Military_pofol_Impl_Vo> getAllById(String p_u_id) throws Exception;
	// 타입은 각 Impl마다 강제 지정

}
