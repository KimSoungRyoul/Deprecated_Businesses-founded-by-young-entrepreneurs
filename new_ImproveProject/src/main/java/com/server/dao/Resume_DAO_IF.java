package com.server.dao;

import java.util.List;
import java.util.Map;

import com.server.domain.Resume;
import com.server.dto.ResumeDTO;

public interface Resume_DAO_IF {

	public void add(Map<String, String> param)throws Exception;
	
	public Resume select(Map<String, String> param)throws Exception;
	
	public List<Resume> list(Resume resume)throws Exception;
	
	public void update (Resume resume)throws Exception;
	
	public void delete(String uniqueResumeKey)throws Exception;
	
	
		
}
