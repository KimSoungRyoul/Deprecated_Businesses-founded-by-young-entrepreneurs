package com.server.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.server.dao.Attach_DAO_IF;
import com.server.dao.Military_pofol_DAO_IF;
import com.server.dao.Pofol_DAO_IF;
import com.server.dao.User_Info_DAO_IF;
import com.server.domain.AttachVo;
import com.server.domain.User_Info_Vo;
import com.server.domain.pofol.Military_pofol_Impl_Vo;
import com.server.dto.LoginDTO;

@Service
public class User_Info_Service_Impl implements User_Info_Service_IF {

	@Inject
	User_Info_DAO_IF userDao;

	
	@Inject
	Military_pofol_DAO_IF miliDao;
	
	@Inject
	Attach_DAO_IF attachDao;

	@Override
	public void SignUp(User_Info_Vo userVo) throws Exception {
		// TODO Auto-generated method stub
		userDao.add(userVo);
		
		Military_pofol_Impl_Vo mVo=new Military_pofol_Impl_Vo();
		mVo.setP_u_id(userVo.getU_id());
		
		
		miliDao.add(mVo);
		
		/*
		 * if(userVo.getU_profilePhoto()==null){
		 * 
		 * }else{ attachDao.add(userVo.getU_profilePhoto()); }
		 */

	}

	@Override
	public void RegistProfilePhoto(AttachVo pPhoto) throws Exception {
		// TODO Auto-generated method stub
		attachDao.add(pPhoto);
	}

	@Override
	public User_Info_Vo Login(LoginDTO dto) throws Exception {
		// TODO Auto-generated method stub
		User_Info_Vo userVo = userDao.get(dto.getU_id(), dto.getU_pw());
		List<AttachVo> u_profilePhotoList = attachDao.getByA_u_id(userVo.getU_id());
		if (u_profilePhotoList.size() > 0)
			userVo.setU_profilePhoto(u_profilePhotoList.get(0));

		return userVo;

	}

	@Override
	public void UpdateUser_Info(User_Info_Vo vo) throws Exception {
		// TODO Auto-generated method stub
		userDao.update(vo);
	}

	@Transactional
	@Override
	public void UpdateProfilePhoto(AttachVo profilePhoto) throws Exception {
		// TODO Auto-generated method stub
		attachDao.deleteProfilePhoto(profilePhoto.getA_u_id());
		attachDao.add(profilePhoto);
		// 프로필 사진 파일 저장 메서드 한개더 추가하기
	}

	@Override
	public List<User_Info_Vo> getUser_InfoByEmail(String u_email) {
		// TODO Auto-generated method stub
		return userDao.getByEmail(u_email);
	}

	/*
	 * @Inject Pofol_DAO_IF pofolDao;
	 * 
	 * @Inject Board_DAO_IF boardDao;
	 */

	@Override
	public void withdrawUser(String u_id) throws Exception {
		// TODO Auto-generated method stub
		// user_Info pofol-->attachedFile -->boardDao
		userDao.delete(u_id);
		// pofolDao.deleteById(u_id);
		// boardDao.deleteById(u_id);
		// attachDao.deleteById(u_id);

	}

	@Override
	public String IsDuplicated(String u_id) {
		// TODO Auto-generated method stub
		return userDao.IsDuplicated(u_id);
	}

}
