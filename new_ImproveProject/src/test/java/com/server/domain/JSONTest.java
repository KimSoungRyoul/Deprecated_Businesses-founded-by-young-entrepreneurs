package com.server.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.server.domain.pofol.Award_pofol_Impl_Vo;
import com.server.domain.pofol.Edu_pofol_Impl_Vo;
import com.server.domain.pofol.Language_pofol_Impl_Vo;
import com.server.domain.pofol.MainAct_pofol_Impl_Vo;
import com.server.domain.pofol.Military_pofol_Impl_Vo;
import com.server.domain.pofol.Qualifi_pofol_Impl_Vo;
import com.server.dto.HashTagDTO;
import com.server.dto.JuSoDTO;
import com.server.dto.LoginDTO;
import com.server.dto.PofolListInPdfDTO;
import com.server.dto.ResumeDTO;
import com.server.service.Pdf_Service;



public class JSONTest {

	/*
	 * 각 vo 마다 toString 이 있는데 이건 데이터 전부 잘들어갔는지 볼려고 개인적으로 만든 toString()이다
	 * JSONObject.toString 하고 햇깔리지 말것 parseToJSON() 이 메서드를 써라
	 * 
	 */

	public static void main(String[] args) throws Exception {

		try {

			final String RESULT = "C:\\zzz\\upload\\2016\\08\\22\\hello2.pdf";

			LoginDTO loginDTO = new LoginDTO();

			loginDTO.setU_id("sky5367");
			loginDTO.setU_pw("aaaaaa");

			System.out.println(loginDTO.parseTOJSON());

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

			System.out.println("-----------------회원정보 JSON-----------------------------------");
			System.out.println(user1.parseTOJSON());
			System.out.println(user1.parseTOObject(user1.parseTOJSON())); // attachfileVo
																		// 가 잘
																		// 들어갔는
																		// 지
																		// tostring으로
																		// 출력해봄
			//System.out.println(user1.parseTOObject(user1.parseTOJSON()));
			System.out.println("--------------------------------------------------------------\n\n");

			// --------------------------------------------------------------------------------------------
			User_Info_Vo uservo2 = user1.parseTOObject(user1.parseTOJSON());

			

			MainAct_pofol_Impl_Vo mainactVVVo = new MainAct_pofol_Impl_Vo();
			mainactVVVo.setP_u_id("sky5367");
			mainactVVVo.setP_title("");

			System.out.println("--------------------------------------------------------------------------");
			System.out.println(mainactVVVo.parseTOJSON());

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

			System.out.println("-----------------학력 포트폴리오 JSON-----------------------------------");
			System.out.println(eduPofol.parseTOJSON());
			System.out.println(eduPofol.parseTOObject(eduPofol.parseTOJSON()));
			System.out.println("--------------------------------------------------------------\n\n");
			// --------------------------------------------------------------------------------------------

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

			System.out.println("-----------------주요 경력활동 포트폴리오 JSON-----------------------------------");
			System.out.println(mainPofol.parseTOJSON());
			System.out.println(mainPofol.parseTOObject(mainPofol.parseTOJSON()));
			System.out.println("----------------------------------------------------------------------\n\n");
			// --------------------------------------------------------------------------------------------

			Award_pofol_Impl_Vo awardPofol = new Award_pofol_Impl_Vo();

			awardPofol.setP_no(15);
			awardPofol.setP_u_id("sky5367");
			awardPofol.setP_regDate("2016-08-11 12:32:22");
			awardPofol.setP_title("국제 공인 마약 제조 대회 최우수상 ");
			awardPofol.setP_startDate("2014-12-01");
			awardPofol.setP_organizer("상장 만들어준곳");
			awardPofol.setP_actcontent("상장 주석");
			//awardPofol.setP_attachFileList(aList);
			//awardPofol.setP_mAttachFileList(mList);

			System.out.println("-----------------수상경력 포트폴리오 JSON-----------------------------------");
			System.out.println(awardPofol.parseTOJSON());
			System.out.println(awardPofol.parseTOObject(awardPofol.parseTOJSON()));
			System.out.println("----------------------------------------------------------------------\n\n");

			// System.out.println(awardPofol.parseTOObject(awardPofol.parseTOJSON()).toString());
			// --------------------------------------------------------------------------------------------

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

			System.out.println("-----------------어학능력 포트폴리오 JSON-----------------------------------");
			System.out.println(languPofol.parseTOJSON());
			System.out.println(languPofol.parseTOObject(languPofol.parseTOJSON()));
			System.out.println("----------------------------------------------------------------------\n\n");
			// --------------------------------------------------------------------------------------------

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

			System.out.println("-----------------자격사항 포트폴리오 JSON-----------------------------------");
			System.out.println(qualiPofol.parseTOJSON());
			System.out.println(qualiPofol.parseTOObject(qualiPofol.parseTOJSON()));
			System.out.println("----------------------------------------------------------------------\n\n");
			// --------------------------------------------------------------------------------------------

			System.out.println("-----------------병역 스펙 포트폴리오 JSON-----------------------------------");
			System.out.println(militaryPofol.parseTOJSON());
			System.out.println(militaryPofol.parseTOObject(militaryPofol.parseTOJSON()));
			System.out.println("----------------------------------------------------------------------\n\n");
			// --------------------------------------------------------------------------------------------

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

			Pdf_Service pdf = new Pdf_Service();

			pdf.setEduList(eduList);
			pdf.setAwardList(awardList);
			pdf.setLanguageList(languageList);
			pdf.setMainActList(mainActList);
			pdf.setMilitaryList(militaryList);
			pdf.setQualifiList(qualifiList);
			pdf.setUserVo(user1);
			pdf.setJuso("정왕동 저시지기ㅓㅁ나ㅣㅇ럼ㄴㅇ리");

			 pdf.createPdf("D:\\personalProject\\" +"hahagha" + ".pdf","asdfasdf");
		 
			PofolListInPdfDTO pofolDtoList = new PofolListInPdfDTO();
			pofolDtoList.setEduList(eduList);
			pofolDtoList.setAwardList(awardList);
			pofolDtoList.setLanguageList(languageList);
		//	pofolDtoList.setMainActList(mainActList);
			pofolDtoList.setMainActList(null);
			pofolDtoList.setMilitaryList(militaryList);
			pofolDtoList.setQualifiList(qualifiList);
			
			pofolDtoList.setUserVo(user1);
			pofolDtoList.setJuso("a정왕동 한국산업기술대학교 ㅁㄴㅇㄹ");
			
			
			System.out.println("-----------------pofolDTOList JSON-----------------------------------");

			String pofolDtoStr = new Gson().toJson(pofolDtoList, PofolListInPdfDTO.class);
			System.out.println(pofolDtoStr);

			PofolListInPdfDTO plDtoGet = new Gson().fromJson(pofolDtoStr, PofolListInPdfDTO.class);
			System.out.println(plDtoGet.toString());

			System.out.println("---------------------------------------------------------------------");

			System.out.println("---------------------------------------------------------------------");
			System.out.println(pofolDtoList.parseTOJSON());
			System.out.println(pofolDtoList.parseTOObject(pofolDtoList.parseTOJSON()));

			System.out.println("---------------------------------------------------------------------");

			Board_Vo boardVo = new Board_Vo();

			List<String> hashTagList = new LinkedList<String>();
			hashTagList.add("과외");
			hashTagList.add("취업");

			List<String> likeList = new LinkedList<String>();
			likeList.add("sky5367");
			likeList.add("jkh662");

			boardVo.setB_parent_no(12);
			boardVo.setB_regDate("2013-04-23");
			boardVo.setB_title("asdfasdf");
			boardVo.setB_writer("sky5367");
			boardVo.setB_content("qwerqwerqwerqwerqwer");
			boardVo.setHashTagList(hashTagList);
			boardVo.setLikeList(likeList);

			List<Board_Vo> replyList = new LinkedList<Board_Vo>();
			replyList.add(boardVo);
			replyList.add(boardVo);
			replyList.add(boardVo);
			replyList.add(boardVo);

			boardVo.setReplyList(replyList);

			System.out.println("-----------------게시물  JSON-----------------------------------");
			System.out.println(boardVo.parseTOJSON());
			// System.out.println(boardVo.parseTOObject(boardVo.parseTOJSON()).toString());
			System.out.println("----------------------------------------------------------------------\n\n");
			// --------------------------------------------------------------------------------------------

			Criteria cri = new Criteria();
			cri.setPage(6);
			cri.setHashtag("과외구함니다");
			System.out.println("-----------------Criteria  JSON-----------------------------------");
			System.out.println(cri.parseTOJSON());
			System.out.println(cri.parseTOObject(cri.parseTOJSON()));
			System.out.println("---------------------------------------------------");

			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(124);

			System.out.println("-----------------pageMaker  JSON-----------------------------------");
			System.out.println(pageMaker.parseTOJSON());
			System.out.println(pageMaker.parseTOObject(pageMaker.parseTOJSON()));
			System.out.println("-------------------------------------------------------------------");

			Criteria_BoardList cri_bl = new Criteria_BoardList();

			List<Integer> b_noList = new LinkedList<Integer>();

			b_noList.add(3);
			b_noList.add(23);
			b_noList.add(21);

			cri_bl.setList(b_noList);
			cri_bl.setHashtag("과외구함니다");

			System.out.println("-----------------Criteria_BoardList JSON-----------------------------------");
			System.out.println(cri_bl.parseTOJSON());
			System.out.println(cri_bl.parseTOObject(cri_bl.parseTOJSON()));
			System.out.println("----------------------------------------------------");

			HashTagDTO hashDTO = new HashTagDTO();

			hashDTO.setBoardCnt(34);
			hashDTO.setH_tagname("과외구함니다");

			System.out.println("-----------------HashTagDTO JSON-----------------------------------");
			System.out.println(hashDTO.parseTOJSON());
			System.out.println(hashDTO.parseTOObject(hashDTO.parseTOJSON()).toString());
			System.out.println("----------------------------------------------------");

			JuSoDTO juso = new JuSoDTO();
			juso.setCountPerPage("10");
			juso.setCurrentPage("1");
			juso.setConfmKey("U01TX0FVVEgyMDE2MDkxMjIyNDUyOTE1MjE0");
			juso.setKeyword("오동마을로");

			System.out.println("-----------------JuSoDTO JSON-----------------------------------");
			System.out.println(juso.parseTOJSON());
			System.out.println(juso.parseTOObject(juso.parseTOJSON()).toString());
			System.out.println("----------------------------------------------------");
			
			
			
			
			

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
}
