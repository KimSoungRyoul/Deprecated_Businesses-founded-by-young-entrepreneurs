package com.server.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.server.dao.Attach_DAO_IF;
import com.server.dao.Award_pofol_DAO_IF;
import com.server.dao.Edu_pofol_DAO_IF;
import com.server.dao.Language_pofol_DAO_IF;
import com.server.dao.MainAct_pofol_DAO_IF;
import com.server.dao.Military_pofol_DAO_IF;
import com.server.dao.Pdf_PofolListDAO_IF;
import com.server.dao.Qualifi_pofol_DAO_IF;
import com.server.dao.User_Info_DAO_IF;
import com.server.domain.AttachVo;
import com.server.domain.User_Info_Vo;
import com.server.domain.pofol.Award_pofol_Impl_Vo;
import com.server.domain.pofol.Edu_pofol_Impl_Vo;
import com.server.domain.pofol.Language_pofol_Impl_Vo;
import com.server.domain.pofol.MainAct_pofol_Impl_Vo;
import com.server.domain.pofol.Military_pofol_Impl_Vo;
import com.server.domain.pofol.Qualifi_pofol_Impl_Vo;
import com.server.dto.PofolListInPdfDTO;

@Service
public class Pdf_PofolListService_Impl implements Pdf_PofolListService_IF{

	@Inject
	User_Info_DAO_IF userDao;
		
	@Inject
	Pdf_PofolListDAO_IF ppDao;
	
	@Inject
	Edu_pofol_DAO_IF eduDao;

	@Inject
	Language_pofol_DAO_IF lanDao;

	@Inject
	MainAct_pofol_DAO_IF mActDao;

	@Inject
	Qualifi_pofol_DAO_IF qualiDao;

	@Inject
	Award_pofol_DAO_IF awardDao;

	@Inject
	Military_pofol_DAO_IF militaryDao;
	
	
	@Inject
	Attach_DAO_IF attachDao;
	
	
	
	@Override
	public PofolListInPdfDTO getPofolList(String p_u_id) throws Exception {
		// TODO Auto-generated method stub
 		
		/*List<Integer> eduList_I= ppDao.getEduList(p_u_id);
		List<Integer> langList_I=ppDao.getLangList(p_u_id);
		List<Integer> mainActList_I=ppDao.getMainActList(p_u_id);
		List<Integer> awardList_I=ppDao.getAwardList(p_u_id);
		List<Integer> qualifiList_I=ppDao.getQualifiList(p_u_id);
		List<Integer> militaryList_I=ppDao.getMilitaryList(p_u_id);*/
		
		
		User_Info_Vo userVo=userDao.get2(p_u_id);
		List<AttachVo> u_profilePhotoList = attachDao.getByA_u_id(userVo.getU_id());
		if (u_profilePhotoList.size() > 0)
			userVo.setU_profilePhoto(u_profilePhotoList.get(0));
		
		
		
		List<Edu_pofol_Impl_Vo> eduList =eduDao.getAllById(p_u_id);
		List<Award_pofol_Impl_Vo> awardList=awardDao.getAllById(p_u_id);
		List<Language_pofol_Impl_Vo> languageList=lanDao.getAllById(p_u_id);
		List<MainAct_pofol_Impl_Vo> mainActList=mActDao.getAllById(p_u_id);
		List<Military_pofol_Impl_Vo> militaryList=militaryDao.getAllById(p_u_id);
		List<Qualifi_pofol_Impl_Vo> qualifiList=qualiDao.getAllById(p_u_id);
		
				
		
		
		PofolListInPdfDTO pListDto=new PofolListInPdfDTO();
		
		pListDto.setUserVo(userVo);
		pListDto.setEduList(eduList);
		pListDto.setAwardList(awardList);
		pListDto.setLanguageList(languageList);
		pListDto.setMainActList(mainActList);
		pListDto.setQualifiList(qualifiList);
		pListDto.setMilitaryList(militaryList);
		
				
		return pListDto;
	}

	
	
	public void deletePofolAboutUser(PofolListInPdfDTO plDto)throws Exception{
				
		//ppDao.deleteEdu(p_no);
		
		
	}
}
