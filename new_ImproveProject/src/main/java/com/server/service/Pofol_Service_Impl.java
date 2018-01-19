package com.server.service;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.server.dao.Attach_DAO_IF;
import com.server.dao.Award_pofol_DAO_IF;
import com.server.dao.Edu_pofol_DAO_IF;
import com.server.dao.Language_pofol_DAO_IF;
import com.server.dao.MainAct_pofol_DAO_IF;
import com.server.dao.Military_pofol_DAO_IF;
import com.server.dao.Multi_Media_DAO_IF;
import com.server.dao.Qualifi_pofol_DAO_IF;
import com.server.domain.AttachVo;
import com.server.domain.Multi_Media_VO;
import com.server.domain.pofol.Award_pofol_Impl_Vo;
import com.server.domain.pofol.Edu_pofol_Impl_Vo;
import com.server.domain.pofol.Language_pofol_Impl_Vo;
import com.server.domain.pofol.MainAct_pofol_Impl_Vo;
import com.server.domain.pofol.Military_pofol_Impl_Vo;
import com.server.domain.pofol.Qualifi_pofol_Impl_Vo;
import com.server.util.UploadFileUtils;

@Repository
public class Pofol_Service_Impl implements Pofol_Service_IF {

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
	Attach_DAO_IF attachDao;

	@Inject
	Multi_Media_DAO_IF multiFileDao;

	@Inject
	Military_pofol_DAO_IF militaryDao;

	@Override
	public int RegistEdu_pofol(Edu_pofol_Impl_Vo vo) throws Exception {
		// TODO Auto-generated method stub
		eduDao.add(vo);
		List<Edu_pofol_Impl_Vo> eList = eduDao.get(vo);

		return eList.get(0).getP_no();

	}

	@Override
	public int RegistLanguage_pofol(Language_pofol_Impl_Vo vo) throws Exception {
		// TODO Auto-generated method stub
		lanDao.add(vo);

		List<Language_pofol_Impl_Vo> langList = lanDao.get(vo);

		return langList.get(0).getP_no();

	}

	@Override
	public int RegistMainAct_pofol(MainAct_pofol_Impl_Vo vo) throws Exception {
		// TODO Auto-generated method stub
		mActDao.add(vo);

		List<MainAct_pofol_Impl_Vo> mList = mActDao.get(vo);

		return mList.get(0).getP_no();
	}

	@Override
	public int RegistQualifi_pofol(Qualifi_pofol_Impl_Vo vo) throws Exception {
		// TODO Auto-generated method stub
		qualiDao.add(vo);

		List<Qualifi_pofol_Impl_Vo> qList = qualiDao.get(vo);

		return qList.get(0).getP_no();

	}

	@Override
	public int RegistAward_pofol(Award_pofol_Impl_Vo vo) throws Exception {
		// TODO Auto-generated method stub
		awardDao.add(vo);

		List<Award_pofol_Impl_Vo> aList = awardDao.get(vo);

		return aList.get(0).getP_no();

	}

	@Override
	public int RegistMilitary_pofol(Military_pofol_Impl_Vo vo) throws Exception {
		// TODO Auto-generated method stub
		militaryDao.add(vo);

		List<Military_pofol_Impl_Vo> mList = militaryDao.get(vo);

		return mList.get(0).getP_no();

	}

	@Override
	public List<Integer> getP_noList(String p_u_id) throws Exception {
		// TODO Auto-generated method stub
		return eduDao.getP_noList(p_u_id);
	}

	@Override
	public List<Edu_pofol_Impl_Vo> getEduList(String p_u_id) throws Exception {
		// TODO Auto-generated method stub
		List<Edu_pofol_Impl_Vo> eduList = eduDao.getAllById(p_u_id);
		List<AttachVo> attachedList = new LinkedList<AttachVo>();

		List<Multi_Media_VO> mediaList = new LinkedList<Multi_Media_VO>();

		for (Edu_pofol_Impl_Vo vo : eduList) {
			attachedList = attachDao.getByA_p_no(vo.getP_no());
			vo.setP_attachFileList(attachedList);

			mediaList = multiFileDao.select(vo.getP_no());
			vo.setP_mAttachFileList(mediaList);

		}
		return eduList;
	}

	@Override
	public List<Language_pofol_Impl_Vo> getLanList(String p_u_id) throws Exception {
		// TODO Auto-generated method stub
		List<Language_pofol_Impl_Vo> lanList = lanDao.getAllById(p_u_id);
		List<AttachVo> attachedList = new LinkedList<AttachVo>();

		List<Multi_Media_VO> mediaList = new LinkedList<Multi_Media_VO>();

		for (Language_pofol_Impl_Vo vo : lanList) {
			attachedList = attachDao.getByA_p_no(vo.getP_no());
			vo.setP_attachFileList(attachedList);

			mediaList = multiFileDao.select(vo.getP_no());
			vo.setP_mAttachFileList(mediaList);
		}

		return lanList;
	}

	@Override
	public List<MainAct_pofol_Impl_Vo> getMainActList(String p_u_id) throws Exception {
		// TODO Auto-generated method stub
		List<MainAct_pofol_Impl_Vo> mainActList = mActDao.getAllById(p_u_id);
		List<AttachVo> attachedList = new LinkedList<AttachVo>();

		List<Multi_Media_VO> mediaList = new LinkedList<Multi_Media_VO>();

		for (MainAct_pofol_Impl_Vo vo : mainActList) {
			attachedList = attachDao.getByA_p_no(vo.getP_no());
			vo.setP_attachFileList(attachedList);

			mediaList = multiFileDao.select(vo.getP_no());
			vo.setP_mAttachFileList(mediaList);
		}

		return mainActList;
	}

	@Override
	public List<Qualifi_pofol_Impl_Vo> getQualifiList(String p_u_id) throws Exception {
		// TODO Auto-generated method stub
		List<Qualifi_pofol_Impl_Vo> qualiList = qualiDao.getAllById(p_u_id);
		List<AttachVo> attachedList = new LinkedList<AttachVo>();

		List<Multi_Media_VO> mediaList = new LinkedList<Multi_Media_VO>();

		for (Qualifi_pofol_Impl_Vo vo : qualiList) {
			attachedList = attachDao.getByA_p_no(vo.getP_no());
			vo.setP_attachFileList(attachedList);

			mediaList = multiFileDao.select(vo.getP_no());
			vo.setP_mAttachFileList(mediaList);
		}

		return qualiList;
	}

	@Override
	public List<Award_pofol_Impl_Vo> getAwardList(String p_u_id) throws Exception {
		// TODO Auto-generated method stub
		List<Award_pofol_Impl_Vo> awardList = awardDao.getAllById(p_u_id);
		List<AttachVo> attachedList = new LinkedList<AttachVo>();

		List<Multi_Media_VO> mediaList = new LinkedList<Multi_Media_VO>();

		for (Award_pofol_Impl_Vo vo : awardList) {
			attachedList = attachDao.getByA_p_no(vo.getP_no());
			vo.setP_attachFileList(attachedList);

			mediaList = multiFileDao.select(vo.getP_no());
			vo.setP_mAttachFileList(mediaList);
		}
		return awardList;
	}

	@Override
	public List<Military_pofol_Impl_Vo> getMilitaryList(String p_u_id) throws Exception {
		// TODO Auto-generated method stub
		List<Military_pofol_Impl_Vo> militaryList = militaryDao.getAllById(p_u_id);
		List<AttachVo> attachedList = new LinkedList<AttachVo>();

		List<Multi_Media_VO> mediaList = new LinkedList<Multi_Media_VO>();

		for (Military_pofol_Impl_Vo vo : militaryList) {
			attachedList = attachDao.getByA_p_no(vo.getP_no());
			vo.setP_attachFileList(attachedList);

			mediaList = multiFileDao.select(vo.getP_no());
			vo.setP_mAttachFileList(mediaList);
		}

		return militaryList;
	}

	@Override
	public void deletePofol(int p_no) throws Exception {
		// TODO Auto-generated method stub
		eduDao.delete(p_no);
	}

	@Override
	public void updateEdu_pofol(Edu_pofol_Impl_Vo vo) throws Exception {
		// TODO Auto-generated method stub
		eduDao.update(vo);
	}

	@Override
	public void updateLanguage_pofol(Language_pofol_Impl_Vo vo) throws Exception {
		// TODO Auto-generated method stub
		lanDao.update(vo);
	}

	@Override
	public void updateMainAct_pofol(MainAct_pofol_Impl_Vo vo) throws Exception {
		// TODO Auto-generated method stub
		mActDao.update(vo);
	}

	@Override
	public void updateQualifi_pofol(Qualifi_pofol_Impl_Vo vo) throws Exception {
		// TODO Auto-generated method stub
		qualiDao.update(vo);
	}

	@Override
	public void updateAward_pofol(Award_pofol_Impl_Vo vo) throws Exception {
		// TODO Auto-generated method stub
		awardDao.update(vo);
	}

	@Override
	public void updateMilitary_pofol(Military_pofol_Impl_Vo vo) throws Exception {
		// TODO Auto-generated method stub
		List<Military_pofol_Impl_Vo> mList = militaryDao.get(vo);

		if (mList.isEmpty()) {
			militaryDao.add(vo);

		} else {
			militaryDao.update(vo);
		}

	}

	//// ---------------------------------첨부파일 관련 서비스---------------------------
	@Override
	public String attachFile(AttachVo vo, MultipartFile file, String uploadPath) throws Exception {
		// TODO Auto-generated method stub

		String a_fullname = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());

		vo.setA_filePath(a_fullname);
		attachDao.add(vo);

		return a_fullname;

	}

	@Override
	public void deleteFileByP_no(int p_no) throws Exception {
		// TODO Auto-generated method stub
		attachDao.deleteByP_no(p_no);
	}

	@Override
	public List<AttachVo> getAttached_PofolFileList(Integer a_p_no) throws Exception {
		// TODO Auto-generated method stub
		return attachDao.getByA_p_no(a_p_no);
	}

	@Override
	public void deleteFileByName(String a_filePath) throws Exception {
		// TODO Auto-generated method stub
		attachDao.deleteByName(a_filePath);
	}

	@Override
	public String MediaAttachFile(Multi_Media_VO vo, MultipartFile file, String uploadPath) throws Exception {
		// TODO Auto-generated method stub
		String a_fullname = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());

		vo.setM_filePath(a_fullname);
		multiFileDao.add(vo);

		return a_fullname;
	}

	@Override
	public List<Multi_Media_VO> getMediaAttached_PofolFileList(Integer m_p_no) throws Exception {
		// TODO Auto-generated method stub
		return multiFileDao.select(m_p_no);
	}

	@Override
	public void deleteMediaFileByFileName(String fileName) throws Exception {
		// TODO Auto-generated method stub
		multiFileDao.delete(fileName);
	}

}
