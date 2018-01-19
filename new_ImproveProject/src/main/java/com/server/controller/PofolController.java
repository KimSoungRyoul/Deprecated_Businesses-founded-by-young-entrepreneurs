package com.server.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.server.domain.pofol.Award_pofol_Impl_Vo;
import com.server.domain.pofol.Edu_pofol_Impl_Vo;
import com.server.domain.pofol.Language_pofol_Impl_Vo;
import com.server.domain.pofol.MainAct_pofol_Impl_Vo;
import com.server.domain.pofol.Military_pofol_Impl_Vo;
import com.server.domain.pofol.Qualifi_pofol_Impl_Vo;
import com.server.service.Pofol_Service_IF;

@Controller
@RequestMapping("/pofol")
public class PofolController {
	
	private static final Logger logger = LoggerFactory.getLogger(PofolController.class);
	
	
	@Inject
	Pofol_Service_IF pofolService;
	
	
	
	
	@RequestMapping(value = "/registEduPofol", method = RequestMethod.POST)
	public ResponseEntity<String> registEduPofol(@RequestBody Edu_pofol_Impl_Vo vo) throws Exception {

		logger.info("학력 정보 등록.............................");

		ResponseEntity<String> entity = null;
						
		try {
						
			entity = new ResponseEntity<String>(String.valueOf(pofolService.RegistEdu_pofol(vo)), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

		return entity;

	}
	
	@RequestMapping(value = "/registAwardPofol", method = RequestMethod.POST)
	public ResponseEntity<String> registAwardPofol(@RequestBody Award_pofol_Impl_Vo vo) throws Exception {

		logger.info("수상 정보 등록.............................");

		ResponseEntity<String> entity = null;
						
		try {
						
			entity = new ResponseEntity<String>(String.valueOf(pofolService.RegistAward_pofol(vo)), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

		return entity;

	}
	
	@RequestMapping(value = "/registMainActPofol", method = RequestMethod.POST)
	public ResponseEntity<String> registMainActPofol(@RequestBody MainAct_pofol_Impl_Vo vo) throws Exception {

		logger.info("주요활동 정보 등록.............................");

		ResponseEntity<String> entity = null;
						
		try {
					
			entity = new ResponseEntity<String>(String.valueOf(pofolService.RegistMainAct_pofol(vo)), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

		return entity;

	}
	
	@RequestMapping(value = "/registQualifiPofol", method = RequestMethod.POST)
	public ResponseEntity<String> registQualifiPofol(@RequestBody Qualifi_pofol_Impl_Vo vo) throws Exception {

		logger.info("자격증 정보 등록.............................");

		ResponseEntity<String> entity = null;
						
		try {
				
			entity = new ResponseEntity<String>(String.valueOf(pofolService.RegistQualifi_pofol(vo)), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

		return entity;

	}
	
	@RequestMapping(value = "/registLanguagePofol", method = RequestMethod.POST)
	public ResponseEntity<String> registLanguagePofol(@RequestBody Language_pofol_Impl_Vo vo) throws Exception {

		logger.info("어학 정보 등록.............................");

		ResponseEntity<String> entity = null;
						
		try {
				
			entity = new ResponseEntity<String>(String.valueOf(pofolService.RegistLanguage_pofol(vo)), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

		return entity;

	}
	
	@RequestMapping(value = "/registMilitaryPofol", method = RequestMethod.POST)
	public ResponseEntity<String> registMilitaryPofol(@RequestBody Military_pofol_Impl_Vo vo) throws Exception {

		logger.info("군경력 정보 등록.............................");

		ResponseEntity<String> entity = null;
						
		try {
				
			entity = new ResponseEntity<String>(String.valueOf(pofolService.RegistMilitary_pofol(vo)), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

		return entity;

	}
	
	
	//--------------------------------------------------------
	
	
	@RequestMapping(value = "/getEduList", method = RequestMethod.POST)
	public ResponseEntity<List<Edu_pofol_Impl_Vo>> getEduList(@RequestBody String p_u_id)throws Exception{
		
		logger.info("학력리스트 가져오기.............................");

		ResponseEntity<List<Edu_pofol_Impl_Vo>> entity = null;
						
		try {
			
			entity = new ResponseEntity<List<Edu_pofol_Impl_Vo>>(pofolService.getEduList(p_u_id), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<Edu_pofol_Impl_Vo>>(HttpStatus.BAD_REQUEST);
		}

		return entity;

		
	}
	
	@RequestMapping(value = "/getAwardList", method = RequestMethod.POST)
	public ResponseEntity<List<Award_pofol_Impl_Vo>> getAwardList(@RequestBody String p_u_id)throws Exception{
		
		logger.info("수상 리스트 가져오기.............................");

		ResponseEntity<List<Award_pofol_Impl_Vo>> entity = null;
						
		try {
			
			entity = new ResponseEntity<List<Award_pofol_Impl_Vo>>(pofolService.getAwardList(p_u_id), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<Award_pofol_Impl_Vo>>(HttpStatus.BAD_REQUEST);
		}

		return entity;

		
	}
	
	@RequestMapping(value = "/getMainActList", method = RequestMethod.POST)
	public ResponseEntity<List<MainAct_pofol_Impl_Vo>> getMainActList(@RequestBody String p_u_id)throws Exception{
		
		logger.info("주요활동 리스트 가져오기.............................");

		ResponseEntity<List<MainAct_pofol_Impl_Vo>> entity = null;
						
		try {
			
			entity = new ResponseEntity<List<MainAct_pofol_Impl_Vo>>(pofolService.getMainActList(p_u_id), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<MainAct_pofol_Impl_Vo>>(HttpStatus.BAD_REQUEST);
		}

		return entity;

		
	}
	
	@RequestMapping(value = "/getQualifiList", method = RequestMethod.POST)
	public ResponseEntity<List<Qualifi_pofol_Impl_Vo>> getQualifiList(@RequestBody String p_u_id)throws Exception{
		
		logger.info("자격증 리스트 가져오기.............................");

		ResponseEntity<List<Qualifi_pofol_Impl_Vo>> entity = null;
						
		try {
			
			entity = new ResponseEntity<List<Qualifi_pofol_Impl_Vo>>(pofolService.getQualifiList(p_u_id), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<Qualifi_pofol_Impl_Vo>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
		
	}
	
	@RequestMapping(value = "/getLanguageList", method = RequestMethod.POST)
	public ResponseEntity<List<Language_pofol_Impl_Vo>> getLanguageList(@RequestBody String p_u_id)throws Exception{
		
		logger.info("어학 리스트 가져오기.............................");

		ResponseEntity<List<Language_pofol_Impl_Vo>> entity = null;
						
		try {
			
			entity = new ResponseEntity<List<Language_pofol_Impl_Vo>>(pofolService.getLanList(p_u_id), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<Language_pofol_Impl_Vo>>(HttpStatus.BAD_REQUEST);
		}

		return entity;

		
	}
	
	
	
	@RequestMapping(value = "/getMilitaryList", method = RequestMethod.POST)
	public ResponseEntity<List<Military_pofol_Impl_Vo>> getMilitaryList(@RequestBody String p_u_id)throws Exception{
		
		logger.info("군경력  리스트 가져오기.............................");

		ResponseEntity<List<Military_pofol_Impl_Vo>> entity = null;
						
		try {
			
			entity = new ResponseEntity<List<Military_pofol_Impl_Vo>>(pofolService.getMilitaryList(p_u_id), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<Military_pofol_Impl_Vo>>(HttpStatus.BAD_REQUEST);
		}

		return entity;

		
	}
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------
	
	
	@RequestMapping(value = "/deletePofol", method = RequestMethod.POST)
	public ResponseEntity<String> deletePofol(@RequestBody int p_no)throws Exception{
		
		logger.info("학력리스트 가져오기.............................");

		ResponseEntity<String> entity = null;
						
		try {
			pofolService.deletePofol(p_no);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

		return entity;

		
	}
	
	
	//-----------------------------------------------------
	
	
	@RequestMapping(value = "/updateEduPofol", method = RequestMethod.POST)
	public ResponseEntity<String> updateEduPofol(@RequestBody Edu_pofol_Impl_Vo vo) throws Exception {

		logger.info("학력정보 변경.............................");

		ResponseEntity<String> entity = null;
						
		try {
			pofolService.updateEdu_pofol(vo);	
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

		return entity;

	}
	
	@RequestMapping(value = "/updateAwardPofol", method = RequestMethod.POST)
	public ResponseEntity<String> updateAwardPofol(@RequestBody Award_pofol_Impl_Vo vo) throws Exception {

		logger.info("수상 경력 변경.............................");

		ResponseEntity<String> entity = null;
						
		try {
			pofolService.updateAward_pofol(vo);	
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

		return entity;

	}
		
	@RequestMapping(value = "/updateMainActPofol", method = RequestMethod.POST)
	public ResponseEntity<String> updateMainActPofol(@RequestBody MainAct_pofol_Impl_Vo vo) throws Exception {

		logger.info("주요활동정보 변경.............................");

		ResponseEntity<String> entity = null;
						
		try {
			pofolService.updateMainAct_pofol(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

		return entity;

	}
	
	@RequestMapping(value = "/updateQualifiPofol", method = RequestMethod.POST)
	public ResponseEntity<String> updateQualifiPofol(@RequestBody Qualifi_pofol_Impl_Vo vo) throws Exception {

		logger.info("자격증 정보 변경.............................");

		ResponseEntity<String> entity = null;
						
		try {
			pofolService.updateQualifi_pofol(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

		return entity;

	}
	
	@RequestMapping(value = "/updateLanguagePofol", method = RequestMethod.POST)
	public ResponseEntity<String> updateLanguagePofol(@RequestBody Language_pofol_Impl_Vo vo) throws Exception {

		logger.info("어학 정보 변경.............................");

		ResponseEntity<String> entity = null;
						
		try {
			pofolService.updateLanguage_pofol(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

		return entity;

	}
	
	
	@RequestMapping(value = "/updateMilitaryPofol", method = RequestMethod.POST)
	public ResponseEntity<String> updateMilitaryPofol(@RequestBody Military_pofol_Impl_Vo vo) throws Exception {

		logger.info("군경력 정보 변경.............................");

		ResponseEntity<String> entity = null;
						
		try {
			pofolService.updateMilitary_pofol(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

		return entity;

	}
	
	
	
	
	
	
}
