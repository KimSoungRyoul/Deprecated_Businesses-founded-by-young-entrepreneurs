package com.server.service;

import java.util.List;

import com.server.dto.PofolListInPdfDTO;

public interface Pdf_PofolListService_IF {

	public PofolListInPdfDTO getPofolList(String p_u_id)throws Exception;
	
}
