package com.server.dao;

import java.util.List;

import com.server.domain.pofol.Language_pofol_Impl_Vo;

public interface Language_pofol_DAO_IF {
	
	public void add(Language_pofol_Impl_Vo vo) throws Exception;

	public List<Language_pofol_Impl_Vo> get(Language_pofol_Impl_Vo vo);
	
	public void delete(int p_no) throws Exception;

	public void update(Language_pofol_Impl_Vo vo) throws Exception;

	// public List<Object> getAllById(String p_u_id)throws Exception;

	public List<Language_pofol_Impl_Vo> getAllById(String p_u_id) throws Exception;
	// 타입은 각 Impl마다 강제 지정

	public List<Language_pofol_Impl_Vo> getPdfLangList(List<Integer> langList_I);

	

}
