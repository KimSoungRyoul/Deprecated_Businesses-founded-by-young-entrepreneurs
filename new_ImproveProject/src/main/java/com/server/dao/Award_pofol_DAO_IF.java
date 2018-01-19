package com.server.dao;

import java.util.List;

import com.server.domain.pofol.Award_pofol_Impl_Vo;

public interface Award_pofol_DAO_IF {

	public void add(Award_pofol_Impl_Vo vo) throws Exception;

	public List<Award_pofol_Impl_Vo> get(Award_pofol_Impl_Vo vo)throws Exception;
	
	public void delete(int p_no) throws Exception;

	public void update(Award_pofol_Impl_Vo vo) throws Exception;

	// public List<Object> getAllById(String p_u_id)throws Exception;

	public List<Award_pofol_Impl_Vo> getAllById(String p_u_id) throws Exception;
	// 타입은 각 Impl마다 강제 지정

	public List<Award_pofol_Impl_Vo> getPdfAwardList(List<Integer> awardList_I);
}
