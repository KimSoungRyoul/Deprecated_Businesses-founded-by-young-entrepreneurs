package com.server.dao;

import java.util.List;

import com.server.domain.pofol.MainAct_pofol_Impl_Vo;

public interface MainAct_pofol_DAO_IF {

	public void add(MainAct_pofol_Impl_Vo vo) throws Exception;

	public void delete(int p_no) throws Exception;

	public void update(MainAct_pofol_Impl_Vo vo) throws Exception;

	// public List<Object> getAllById(String p_u_id)throws Exception;

	public List<MainAct_pofol_Impl_Vo> getAllById(String p_u_id) throws Exception;
	// 타입은 각 Impl마다 강제 지정

	public List<MainAct_pofol_Impl_Vo> get(MainAct_pofol_Impl_Vo vo);

	public List<MainAct_pofol_Impl_Vo> getMainActList(List<Integer> mainActList_I);

}
