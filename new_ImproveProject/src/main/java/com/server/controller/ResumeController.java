package com.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.server.domain.Resume;
import com.server.service.ResumeService;

@Controller
public class ResumeController {

	private static final Logger logger = LoggerFactory.getLogger(ResumeController.class);

	@Autowired
	ResumeService resumeService;
	
	
	
	/*@RequestMapping(value = "/QrResume", method = RequestMethod.GET)
	public String QrResume() {
		logger.info("Welcome QrResume Page.");

		return "QrResume";
	}
*/
	
	
	
	
	
	@RequestMapping(value = "/{u_id}", method = RequestMethod.GET)
	public String IdAccess(@PathVariable("u_id") String u_id, 
			@RequestParam("uniqueResumeKey") String uniqueResumeKey,
			Model model)throws Exception {
		logger.info("Welcome   " + u_id + "'s Page.");
		logger.info("uniqueResumeKey: " + uniqueResumeKey);
		Resume rrr=resumeService.getResume(u_id, uniqueResumeKey);
		model.addAttribute("resume", resumeService.getResume(u_id, uniqueResumeKey));
		
		return "QrResume";
	}

}
