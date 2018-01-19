package com.server.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.server.domain.AttachVo;
import com.server.domain.Multi_Media_VO;
import com.server.domain.pofol.Award_pofol_Impl_Vo;
import com.server.domain.pofol.Edu_pofol_Impl_Vo;
import com.server.domain.pofol.Language_pofol_Impl_Vo;
import com.server.domain.pofol.MainAct_pofol_Impl_Vo;
import com.server.domain.pofol.Military_pofol_Impl_Vo;
import com.server.domain.pofol.Qualifi_pofol_Impl_Vo;

public interface Pofol_Service_IF {
	//전략 패턴으로 각 포폴별로 Impl 로 분류하기
	public int RegistEdu_pofol(Edu_pofol_Impl_Vo vo)throws Exception;
	public int RegistLanguage_pofol(Language_pofol_Impl_Vo vo)throws Exception;
	public int RegistMainAct_pofol(MainAct_pofol_Impl_Vo vo)throws Exception;
	public int RegistQualifi_pofol(Qualifi_pofol_Impl_Vo vo)throws Exception;
	public int RegistAward_pofol(Award_pofol_Impl_Vo vo)throws Exception;
	public int RegistMilitary_pofol(Military_pofol_Impl_Vo vo)throws Exception;
	
	
	public List<Integer> getP_noList(String p_u_id)throws Exception;
	
	public List<Edu_pofol_Impl_Vo> getEduList(String p_u_id)throws Exception;
	public List<Language_pofol_Impl_Vo> getLanList(String p_u_id)throws Exception;
	public List<MainAct_pofol_Impl_Vo> getMainActList(String p_u_id)throws Exception;
	public List<Qualifi_pofol_Impl_Vo> getQualifiList(String p_u_id)throws Exception;
	public List<Award_pofol_Impl_Vo> getAwardList(String p_u_id)throws Exception;
	public List<Military_pofol_Impl_Vo> getMilitaryList(String p_u_id)throws Exception;
	
	
	public void deletePofol(int p_no)throws Exception;
	
	
	public void updateEdu_pofol(Edu_pofol_Impl_Vo vo)throws Exception;
	public void updateLanguage_pofol(Language_pofol_Impl_Vo vo)throws Exception;
	public void updateMainAct_pofol(MainAct_pofol_Impl_Vo vo)throws Exception;
	public void updateQualifi_pofol(Qualifi_pofol_Impl_Vo vo)throws Exception;
	public void updateAward_pofol(Award_pofol_Impl_Vo vo)throws Exception;
	public void updateMilitary_pofol(Military_pofol_Impl_Vo vo)throws Exception;
	
	
	
	
	public String attachFile(AttachVo vo,MultipartFile file,String uploadPath) throws Exception;
	public void deleteFileByP_no(int p_no)throws Exception;
	public List<AttachVo> getAttached_PofolFileList(Integer a_p_no)throws Exception;
	public void deleteFileByName(String a_filePath)throws Exception;
	
	
	public String MediaAttachFile(Multi_Media_VO vo,MultipartFile file,String uploadPath)throws Exception;
	public List<Multi_Media_VO> getMediaAttached_PofolFileList(Integer m_p_no)throws Exception;
	public void deleteMediaFileByFileName(String fileName)throws Exception;
	
	
}
