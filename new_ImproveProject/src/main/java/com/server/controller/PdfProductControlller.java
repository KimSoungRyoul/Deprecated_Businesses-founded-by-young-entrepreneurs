package com.server.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.server.dto.PofolListInPdfDTO;
import com.server.service.Pdf_PofolListService_IF;

@Controller
@RequestMapping("/settingPdf")
public class PdfProductControlller {
	
	private static final Logger logger = LoggerFactory.getLogger(PdfProductControlller.class);
	
	
	@Inject
	Pdf_PofolListService_IF pdf_PofolService;
	
	
	@RequestMapping(value = "/getPofolListForPdf", method = RequestMethod.POST)
	public ResponseEntity<PofolListInPdfDTO> getPofolListForPofol(@RequestBody String u_id) throws Exception {

		logger.info("pdf포폴 리스트  요청.............................");

		ResponseEntity<PofolListInPdfDTO> entity = null;
				
		try {			
			
			entity = new ResponseEntity<PofolListInPdfDTO>(pdf_PofolService.getPofolList(u_id), HttpStatus.OK);

			//PofolListInPdfDTO dto1=pdf_PofolService.getPofolList(u_id);
			//String aaa=dto1.parseTOJSON();
			//PofolListInPdfDTO dto2=dto1.parseTOObject(aaa);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<PofolListInPdfDTO>(HttpStatus.BAD_REQUEST);
		}

		return entity;

	}
	
	
	
}
