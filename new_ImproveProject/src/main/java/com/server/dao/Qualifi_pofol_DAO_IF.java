package com.server.dao;

import java.util.List;

import com.server.domain.pofol.Qualifi_pofol_Impl_Vo;

public interface Qualifi_pofol_DAO_IF {

	public void add(Qualifi_pofol_Impl_Vo vo) throws Exception;

	public List<Qualifi_pofol_Impl_Vo> get(Qualifi_pofol_Impl_Vo vo);
	
	public void delete(int p_no) throws Exception;

	public void update(Qualifi_pofol_Impl_Vo vo) throws Exception;

	// public List<Object> getAllById(String p_u_id)throws Exception;

	public List<Qualifi_pofol_Impl_Vo> getAllById(String p_u_id) throws Exception;
	// 타입은 각 Impl마다 강제 지정

	public List<Qualifi_pofol_Impl_Vo> getQualifiList(List<Integer> qualifiList_I);

	
}
