package com.server.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.server.dao.Resume_DAO_IF;
import com.server.domain.AttachVo;
import com.server.domain.Multi_Media_VO;
import com.server.domain.Resume;
import com.server.domain.User_Info_Vo;
import com.server.domain.pofol.Award_pofol_Impl_Vo;
import com.server.domain.pofol.Edu_pofol_Impl_Vo;
import com.server.domain.pofol.Language_pofol_Impl_Vo;
import com.server.domain.pofol.MainAct_pofol_Impl_Vo;
import com.server.domain.pofol.Military_pofol_Impl_Vo;
import com.server.domain.pofol.Qualifi_pofol_Impl_Vo;
import com.server.dto.PofolListInPdfDTO;
import com.server.service.Pdf_Service;
import com.server.service.ResumeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class Resume_Service_Test {
	
	
	@Autowired
	ResumeService resumeService;
	
	@Autowired
	Resume_DAO_IF resumeDao;
	
	
	private PofolListInPdfDTO pofolDtoList;
	
	private String u_id="sky5367";
	private String uniqueResumeKey="63aaf619bb164f95a2a54a56f31cb572";
	
	
	@Before
	public void setup(){
		Edu_pofol_Impl_Vo asd = new Edu_pofol_Impl_Vo();
		asd.setP_no(0);
		asd.setP_u_id("sky5367");
		asd.setP_title("");

		System.out.println(asd.parseTOJSON());

		List<AttachVo> aList = new ArrayList<AttachVo>();
		AttachVo vo = new AttachVo(32, "\\2016\\09\\01\\improve_kaka.png", "asdf", "asdf", 43, 12);
		aList.add(vo);
		aList.add(vo);
		// C:\\zzz\\upload\\2016\\08\\22\\a81e4af0-b9da-46cf-bfb8-29c1f5c1094f_JSP.jpg

		System.out.println(vo.parseTOJSON());

		List<Multi_Media_VO> mList = new LinkedList<Multi_Media_VO>();
		Multi_Media_VO mVo = new Multi_Media_VO();
		mVo.setM_no(100);
		mVo.setM_filePath("asdfasdfs\\asdfsadfasdf\\asdfasdfsf\\asdfsdf\\wertet");
		mVo.setM_regDate("2016-09-24 22:15:49");
		mVo.setM_p_no(11);

		mList.add(mVo);
		mList.add(mVo);
		mList.add(mVo);
		mList.add(mVo);

		Military_pofol_Impl_Vo militaryPofol = new Military_pofol_Impl_Vo();

		militaryPofol.setP_no(18);
		militaryPofol.setP_u_id("sky5367");
		militaryPofol.setP_regDate("2016-08-11 12:32:22");
		militaryPofol.setP_title("해병대");
		militaryPofol.setP_startDate("2014-02-11");
		militaryPofol.setP_endDate("2016-12-09");
		militaryPofol.setP_organizer("준장");
		militaryPofol.setP_actcontent("군경력 주석");
	//	militaryPofol.setP_attachFileList(aList);
	//	militaryPofol.setP_mAttachFileList(mList);
//
	

		User_Info_Vo user1 = new User_Info_Vo();

		user1.setU_no(23);
		user1.setU_name("김성렬");
		user1.setU_id("sky5367");
		user1.setU_pw("123456");
		user1.setU_pnum("010-7237-6602");
		user1.setU_email("rlatjduf510@naver.com");
		user1.setU_sex("woman");
		user1.setU_birthDate("1993-08-23");
		user1.setU_regDate("2016-08-11 12:32:22");
		user1.setU_profilePhoto(vo);

		
		// --------------------------------------------------------------------------------------------
		User_Info_Vo uservo2 = user1.parseTOObject(user1.parseTOJSON());

		

		MainAct_pofol_Impl_Vo mainactVVVo = new MainAct_pofol_Impl_Vo();
		mainactVVVo.setP_u_id("sky5367");
		mainactVVVo.setP_title("");

		
		Edu_pofol_Impl_Vo eduPofol = new Edu_pofol_Impl_Vo();

		eduPofol.setP_no(45);
		eduPofol.setP_u_id("sky5367");
		eduPofol.setP_regDate("2016-08-11 12:32:22");
		eduPofol.setP_title("한국산업기술대학교");
		eduPofol.setP_startDate("2012-03-01");
		eduPofol.setP_endDate("2018-03-01");
		eduPofol.setP_major("땔깜 공학과");
		eduPofol.setP_actcontent("주석주석 컨텐츠");
		eduPofol.setP_completeType("수료");
		eduPofol.setP_attachFileList(aList);
		eduPofol.setP_mAttachFileList(mList);

		
		MainAct_pofol_Impl_Vo mainPofol = new MainAct_pofol_Impl_Vo();

		mainPofol.setP_no(33);
		mainPofol.setP_u_id("sky5367");
		mainPofol.setP_regDate("2016-08-11 12:32:22");
		mainPofol.setP_title("연평해전 참전 ");
		mainPofol.setP_startDate("2014-12-01");
		mainPofol.setP_endDate("2015-06-12");
		mainPofol.setP_actcontent("박격포 지원 가능합니다 활동내용 ");
		mainPofol.setP_organizer("744특수임무 부대");
		mainPofol.setP_attachFileList(aList);
		mainPofol.setP_mAttachFileList(mList);

		Award_pofol_Impl_Vo awardPofol = new Award_pofol_Impl_Vo();

		awardPofol.setP_no(15);
		awardPofol.setP_u_id("sky5367");
		awardPofol.setP_regDate("2016-08-11 12:32:22");
		awardPofol.setP_title("국제 공인 마약 제조 대회 최우수상 ");
		awardPofol.setP_startDate("2014-12-01");
		awardPofol.setP_organizer("상장 만들어준곳");
		awardPofol.setP_actcontent("상장 주석");
		awardPofol.setP_attachFileList(aList);
		awardPofol.setP_mAttachFileList(mList);

	
		Language_pofol_Impl_Vo languPofol = new Language_pofol_Impl_Vo();

		languPofol.setP_no(56);
		languPofol.setP_u_id("sky5367");
		languPofol.setP_regDate("2016-08-11 12:32:22");

		languPofol.setP_title("토익  신토익이궁금해");
		languPofol.setP_startDate("2016-02-11");
		languPofol.setP_organizer("한국 영어 협회");
		languPofol.setP_examScore("문자열 점수 992");
		languPofol.setP_language("English");
		languPofol.setP_actcontent("어학 능력 주석");
		languPofol.setP_attachFileList(aList);
		languPofol.setP_mAttachFileList(mList);

		
		Qualifi_pofol_Impl_Vo qualiPofol = new Qualifi_pofol_Impl_Vo();

		qualiPofol.setP_no(46);
		qualiPofol.setP_u_id("sky5367");
		qualiPofol.setP_regDate("2016-08-11 12:32:22");
		qualiPofol.setP_title("폭발물취급 1급자격증");
		qualiPofol.setP_startDate("2016-02-11");
		qualiPofol.setP_organizer("한국산업공단");
		qualiPofol.setP_actcontent("자격 주석");
		qualiPofol.setP_attachFileList(aList);
		qualiPofol.setP_mAttachFileList(mList);

	
	
		List<Edu_pofol_Impl_Vo> eduList = new LinkedList<Edu_pofol_Impl_Vo>();

		List<Award_pofol_Impl_Vo> awardList = new LinkedList<Award_pofol_Impl_Vo>();
		List<Language_pofol_Impl_Vo> languageList = new LinkedList<Language_pofol_Impl_Vo>();
		List<MainAct_pofol_Impl_Vo> mainActList = new LinkedList<MainAct_pofol_Impl_Vo>();
		List<Qualifi_pofol_Impl_Vo> qualifiList = new LinkedList<Qualifi_pofol_Impl_Vo>();
		List<Military_pofol_Impl_Vo> militaryList = new LinkedList<Military_pofol_Impl_Vo>();

		eduList.add(eduPofol);
		eduList.add(eduPofol);

		awardList.add(awardPofol);
		awardList.add(awardPofol);

		mainActList.add(mainPofol);
		mainActList.add(mainPofol);
		mainActList.add(mainPofol);
		mainActList.add(mainPofol);

		qualifiList.add(qualiPofol);
		qualifiList.add(qualiPofol);

		languageList.add(languPofol);
		languageList.add(languPofol);

		militaryList.add(militaryPofol);

		 
		pofolDtoList = new PofolListInPdfDTO();
		//pofolDtoList.setEduList(eduList);
		pofolDtoList.setAwardList(awardList);
		pofolDtoList.setLanguageList(languageList);
		pofolDtoList.setMainActList(mainActList);
		pofolDtoList.setMilitaryList(militaryList);
		pofolDtoList.setQualifiList(qualifiList);
		pofolDtoList.setUserVo(user1);
		pofolDtoList.setJuso("a정왕동 한국산업기술대학교 ㅁㄴㅇㄹ");
		
	}
	
	
	
	@Test
	public void Test() throws Exception{		
		
		Resume resume= resumeService.getResume(u_id, uniqueResumeKey);
		
		System.out.println(resume.toString());
	}
	

	@Test
	public void TestDao()throws Exception{
		
		
		
	}
	
	
	
}
