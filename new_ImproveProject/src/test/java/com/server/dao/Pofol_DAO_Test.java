package com.server.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.server.domain.AttachVo;
import com.server.domain.pofol.Award_pofol_Impl_Vo;
import com.server.domain.pofol.Edu_pofol_Impl_Vo;
import com.server.domain.pofol.Language_pofol_Impl_Vo;
import com.server.domain.pofol.MainAct_pofol_Impl_Vo;
import com.server.domain.pofol.Qualifi_pofol_Impl_Vo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
@Transactional
public class Pofol_DAO_Test {

	@Inject
	Edu_pofol_DAO_IF eduDAO;
	
	@Inject
	MainAct_pofol_DAO_IF mainActDAO;
	
	@Inject
	Award_pofol_DAO_IF awardDAO;
	
	@Inject
	Language_pofol_DAO_IF lanDAO;
	
	@Inject
	Qualifi_pofol_DAO_IF qualiDAO;
	
	

	private Edu_pofol_Impl_Vo eduPofol;
	private MainAct_pofol_Impl_Vo mainPofol;
	private Award_pofol_Impl_Vo awardPofol;
	private Language_pofol_Impl_Vo languPofol;
	private Qualifi_pofol_Impl_Vo qualiPofol;
	
	

	@Before
	public void setUp() {
		eduPofol = new Edu_pofol_Impl_Vo();
		mainPofol = new MainAct_pofol_Impl_Vo();
		awardPofol = new Award_pofol_Impl_Vo();
		languPofol = new Language_pofol_Impl_Vo();
		qualiPofol = new Qualifi_pofol_Impl_Vo();

		List<AttachVo> aList = new ArrayList<AttachVo>();
		AttachVo vo = new AttachVo(32, "asdf", "asdf", "asdf", 43, 12);
		aList.add(vo);
		aList.add(vo);

		//eduPofol.setP_no(45);
		eduPofol.setP_u_id("sky5367");
		//eduPofol.setP_regDate("2016-08-11 12:32:22");
		eduPofol.setP_title("한국산업기술대학교");
		eduPofol.setP_startDate("2012-03-01");
		eduPofol.setP_endDate("2018-03-01");
		eduPofol.setP_major("땔깜 공학과");
		eduPofol.setP_completeType("수료");
		eduPofol.setP_attachFileList(aList);
		eduPofol.setP_actcontent("아 데이터 추가되서 전부다시 테스트함 ㅂㄷㅂㄷ contents추가");

		//mainPofol.setP_no(33);
		mainPofol.setP_u_id("sky5367");
		//mainPofol.setP_regDate("2016-08-11 12:32:22");
		mainPofol.setP_title("연평해전 참전 ");
		mainPofol.setP_startDate("2014-12-01");
		mainPofol.setP_endDate("2015-06-12");
		mainPofol.setP_actcontent("박격포 지원 가능합니다 활동내용 ");
		mainPofol.setP_organizer("744특수임무 부대");
		mainPofol.setP_attachFileList(aList);
		mainPofol.setP_actcontent("아 데이터 추가되서 전부다시 테스트함 ㅂㄷㅂㄷ contents추가");
		
		//awardPofol.setP_no(15);
		awardPofol.setP_u_id("sky5367");
		//awardPofol.setP_regDate("2016-08-11 12:32:22");
		awardPofol.setP_title("국제 공인 마약 제조 대회 최우수상 ");
		awardPofol.setP_startDate("2014-12-01");
		awardPofol.setP_organizer("2015-06-12");
		awardPofol.setP_attachFileList(aList);
		awardPofol.setP_actcontent("아 데이터 추가되서 전부다시 테스트함 ㅂㄷㅂㄷ contents추가");

		//languPofol.setP_no(56);
		languPofol.setP_u_id("sky5367");
		//languPofol.setP_regDate("2016-08-11 12:32:22");
		languPofol.setP_title("토익  신토익이궁금해");
		languPofol.setP_startDate("2016-02-11");
		languPofol.setP_organizer("한국 영어 협회");
		languPofol.setP_examScore("문자열 점수 992");
		languPofol.setP_language("English");
		languPofol.setP_attachFileList(aList);
		languPofol.setP_actcontent("아 데이터 추가되서 전부다시 테스트함 ㅂㄷㅂㄷ contents추가");

		//qualiPofol.setP_no(46);
		qualiPofol.setP_u_id("sky5367");
		//qualiPofol.setP_regDate("2016-08-11 12:32:22");
		qualiPofol.setP_title("폭발물취급 1급자격증");
		qualiPofol.setP_startDate("2016-02-11");
		qualiPofol.setP_organizer("한국산업공단");
		qualiPofol.setP_actcontent("아 데이터 추가되서 전부다시 테스트함 ㅂㄷㅂㄷ contents추가");
		qualiPofol.setP_attachFileList(aList);

	}
	
	// DAO를 통해 모든 포트폴리오 데이터를 가져와서 하나의 List안에 모든 데이터를 묶고 지우는 테스트
	@Test
	public void DAOTest()throws Exception{
		eduDAO.DeleteAll();
		
		
		eduDAO.add(eduPofol);
		mainActDAO.add(mainPofol);
		awardDAO.add(awardPofol);
		lanDAO.add(languPofol);
		qualiDAO.add(qualiPofol);
		
		List<Edu_pofol_Impl_Vo> eList=eduDAO.getAllById(eduPofol.getP_u_id());
		List<MainAct_pofol_Impl_Vo> mList=mainActDAO.getAllById(mainPofol.getP_u_id());
		List<Award_pofol_Impl_Vo> aList=awardDAO.getAllById(awardPofol.getP_u_id());
		List<Language_pofol_Impl_Vo> lList=lanDAO.getAllById(languPofol.getP_u_id());
		List<Qualifi_pofol_Impl_Vo> qList=qualiDAO.getAllById(qualiPofol.getP_u_id());
		
		
		eList.get(0).setP_major("전공변경함");
		mList.get(0).setP_actcontent("주요활동내역 변경");
		aList.get(0).setP_organizer("상장 인증기관 변경");
		qList.get(0).setP_title("자격사항 제목 변경");
		lList.get(0).setP_examScore("어학능력 점수 변경");
		
		eduDAO.update(eList.get(0));
		mainActDAO.update(mList.get(0));
		awardDAO.update(aList.get(0));
		qualiDAO.update(qList.get(0));
		lanDAO.update(lList.get(0));
		
		
		
		
		
		
		for(Edu_pofol_Impl_Vo eduVO:eList){
			System.out.println(eduVO.parseTOJSON()+"\n");
		}
		for(MainAct_pofol_Impl_Vo mVO:mList){
			System.out.println(mVO.parseTOJSON()+"\n");
		}
		for(Award_pofol_Impl_Vo aVO:aList){
			System.out.println(aVO.parseTOJSON()+"\n");
		}		
		for(Language_pofol_Impl_Vo lVO:lList){
			System.out.println(lVO.parseTOJSON()+"\n");
		}
		for(Qualifi_pofol_Impl_Vo qVO:qList){
			System.out.println(qVO.parseTOJSON()+"\n");
		}
		
		
		eduDAO.delete(eList.get(0).getP_no());
		mainActDAO.delete(mList.get(0).getP_no());
		awardDAO.delete(aList.get(0).getP_no());
		lanDAO.delete(lList.get(0).getP_no());
		qualiDAO.delete(qList.get(0).getP_no());
				
	}
	
	

}
