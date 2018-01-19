package com.server.dao;

import java.util.List;

import com.server.domain.pofol.Edu_pofol_Impl_Vo;

public interface Edu_pofol_DAO_IF {

	public void add(Edu_pofol_Impl_Vo vo) throws Exception;
	
	public List<Edu_pofol_Impl_Vo> get(Edu_pofol_Impl_Vo vo)throws Exception;

	public void delete(int p_no) throws Exception;

	public void update(Edu_pofol_Impl_Vo vo) throws Exception;

	// public List<Object> getAllById(String p_u_id)throws Exception;

	public List<Edu_pofol_Impl_Vo> getAllById(String p_u_id) throws Exception;
	// 타입은 각 Impl마다 강제 지정
	
	public List<Integer> getP_noList(String p_u_id)throws Exception;
		
	
	public void DeleteAll()throws Exception;

	public List<Edu_pofol_Impl_Vo> getPdfEduList(List<Integer> eduList_I)throws Exception;
}
