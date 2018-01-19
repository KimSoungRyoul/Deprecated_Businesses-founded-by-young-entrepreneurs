package com.server.service;

import com.server.domain.Resume;
import com.server.dto.PofolListInPdfDTO;


public interface ResumeService {
	
	public void registResume(PofolListInPdfDTO pldto,String uniqueResumeKey)throws Exception;
	
	public Resume getResume(String u_id,String uniqueResumeKey)throws Exception;
	
	public void deleteResume(String uniqueResumeKey)throws Exception;
	
}
