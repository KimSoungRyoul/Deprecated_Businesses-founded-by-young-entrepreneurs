package com.server.dao;

import java.util.List;

import com.server.domain.Multi_Media_VO;

public interface Multi_Media_DAO_IF {
	
	public void add(Multi_Media_VO vo)throws Exception;
	
	public List<Multi_Media_VO> select(int m_p_no)throws Exception;
	
	public void delete(String fileName)throws Exception;


}
