package com.server.service;

import java.util.List;

import com.server.domain.AttachVo;
import com.server.domain.User_Info_Vo;
import com.server.dto.LoginDTO;

public interface User_Info_Service_IF {
	
	public void SignUp(User_Info_Vo userVo)throws Exception;
	
	public void RegistProfilePhoto(AttachVo vo)throws Exception;
	public void UpdateProfilePhoto(AttachVo profilePhoto)throws Exception;
	
	public User_Info_Vo Login(LoginDTO dto)throws Exception;
	
	public void UpdateUser_Info(User_Info_Vo vo)throws Exception;

	public List<User_Info_Vo> getUser_InfoByEmail(String u_email);
	
	public void withdrawUser(String u_id)throws Exception;

	public String IsDuplicated(String u_id);

	
}
