package com.server.dao;

import java.util.List;

import com.server.domain.AttachVo;

public interface Attach_DAO_IF {
	
	public void add(AttachVo vo)throws Exception;
		
	public List<AttachVo> getByA_u_id(String a_u_id)throws Exception;
	
	public List<AttachVo> getByA_p_no(int a_p_no)throws Exception;
	
	public List<AttachVo> getByA_b_no(int a_b_no)throws Exception;
	
	public void deleteByP_no(int a_no)throws Exception;
	
	public void deleteProfilePhoto(String a_u_id)throws Exception;
	
	public void deleteByName(String fileName)throws Exception;

	
	
}
