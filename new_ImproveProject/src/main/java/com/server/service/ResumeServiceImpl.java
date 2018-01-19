package com.server.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.dao.Pdf_PofolListDAO_IF;
import com.server.dao.Resume_DAO_IF;
import com.server.domain.Resume;
import com.server.domain.pofol.Award_pofol_Impl_Vo;
import com.server.domain.pofol.Edu_pofol_Impl_Vo;
import com.server.domain.pofol.Language_pofol_Impl_Vo;
import com.server.domain.pofol.MainAct_pofol_Impl_Vo;
import com.server.domain.pofol.Military_pofol_Impl_Vo;
import com.server.domain.pofol.Qualifi_pofol_Impl_Vo;
import com.server.dto.PofolListInPdfDTO;
import com.server.dto.ResumeDTO;

@Service
public class ResumeServiceImpl implements ResumeService {

	@Autowired
	Resume_DAO_IF resumeDao;

	@Autowired
	Pdf_PofolListDAO_IF pdf_pofolDao;

	@Override
	public void registResume(PofolListInPdfDTO pldto, String uniqueResumeKey) throws Exception {
		// TODO Auto-generated method stub
		ResumeDTO resumeDto = new ResumeDTO();
		resumeDto.setUniqueResumeKey(uniqueResumeKey);

		// uniqueResumeKey is Auto Created with ResumeDTO Constructor
		resumeDto.setU_id(pldto.getUserVo().getU_id());

		if (pldto.getEduList() == null) {
			resumeDto.setEduNoList(new LinkedList<Integer>());
		} else {
			resumeDto.setEduNoList(this.<Edu_pofol_Impl_Vo> extractP_no(pldto.getEduList()));
			Map<String, Object> pofolParamEdu = new HashMap<String, Object>();
			pofolParamEdu.put("uniqueResumeKey", resumeDto.getUniqueResumeKey());
			pofolParamEdu.put("p_noList", resumeDto.getEduNoList());

			pdf_pofolDao.addEdu(pofolParamEdu);
		}

		if (pldto.getAwardList() == null) {
			resumeDto.setAwardNoList(new LinkedList<Integer>());
		} else {
			resumeDto.setAwardNoList(this.<Award_pofol_Impl_Vo> extractP_no(pldto.getAwardList()));
			Map<String, Object> pofolParamAward = new HashMap<String, Object>();
			pofolParamAward.put("uniqueResumeKey", resumeDto.getUniqueResumeKey());
			pofolParamAward.put("p_noList", resumeDto.getAwardNoList());

			pdf_pofolDao.addAward(pofolParamAward);
		}

		if (pldto.getLanguageList() == null) {
			resumeDto.setLangNoList(new LinkedList<Integer>());
		} else {
			resumeDto.setLangNoList(this.<Language_pofol_Impl_Vo> extractP_no(pldto.getLanguageList()));

			Map<String, Object> pofolParamLang = new HashMap<String, Object>();
			pofolParamLang.put("uniqueResumeKey", resumeDto.getUniqueResumeKey());
			pofolParamLang.put("p_noList", resumeDto.getLangNoList());

			pdf_pofolDao.addLang(pofolParamLang);
		}

		if (pldto.getMainActList() == null) {
			resumeDto.setMainActNoList(new LinkedList<Integer>());
		} else {
			resumeDto.setMainActNoList(this.<MainAct_pofol_Impl_Vo> extractP_no(pldto.getMainActList()));

			Map<String, Object> pofolParamMainAct = new HashMap<String, Object>();
			pofolParamMainAct.put("uniqueResumeKey", resumeDto.getUniqueResumeKey());
			pofolParamMainAct.put("p_noList", resumeDto.getMainActNoList());

			pdf_pofolDao.addMainAct(pofolParamMainAct);
		}

		if (pldto.getQualifiList() == null) {
			resumeDto.setQualifiNoList(new LinkedList<Integer>());
		} else {
			resumeDto.setQualifiNoList(this.<Qualifi_pofol_Impl_Vo> extractP_no(pldto.getQualifiList()));

			Map<String, Object> pofolParamQualifi = new HashMap<String, Object>();
			pofolParamQualifi.put("uniqueResumeKey", resumeDto.getUniqueResumeKey());
			pofolParamQualifi.put("p_noList", resumeDto.getQualifiNoList());

			pdf_pofolDao.addQualifi(pofolParamQualifi);
		}

		if (pldto.getMilitaryList() == null) {
			resumeDto.setMilitaryNoList(new LinkedList<Integer>());
		} else {
			resumeDto.setMilitaryNoList(this.<Military_pofol_Impl_Vo> extractP_no(pldto.getMilitaryList()));
			Map<String, Object> pofolParamMilitary = new HashMap<String, Object>();
			pofolParamMilitary.put("uniqueResumeKey", resumeDto.getUniqueResumeKey());
			pofolParamMilitary.put("p_noList", resumeDto.getMilitaryNoList());

			pdf_pofolDao.addMilitary(pofolParamMilitary);
		}

		Map<String, String> param = new HashMap<String, String>();
		param.put("uniqueResumeKey", resumeDto.getUniqueResumeKey());
		param.put("rs_u_id", resumeDto.getU_id());

		resumeDao.add(param);

	}

	@Override
	public Resume getResume(String u_id, String uniqueResumeKey) throws Exception {
		// TODO Auto-generated method stub

		Map<String, String> param = new HashMap<String, String>();
		param.put("rs_u_id", u_id);
		param.put("uniqueResumeKey", uniqueResumeKey);

		return resumeDao.select(param);
	}

	@Override
	public void deleteResume(String uniqueResumeKey) throws Exception {
		// TODO Auto-generated method stub

	}

	private <T> List<Integer> extractP_no(List<T> pofolList) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		List<Integer> p_noList = new ArrayList<Integer>();

		if (pofolList.isEmpty()) {
			p_noList.add(0);
			return p_noList;
		}

		Class<? extends Object> cl = pofolList.get(0).getClass();
		Method method = cl.getMethod("getP_no");

		for (T pofol : pofolList) {

			Object retobj = method.invoke(pofol, null);

			Integer p_no = (Integer) retobj;
			p_noList.add(p_no);
		}

		if (pofolList.isEmpty()) {
			p_noList.add(0);
			return p_noList;
		}

		return p_noList;
	}

}
