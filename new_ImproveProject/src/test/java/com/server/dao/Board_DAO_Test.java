package com.server.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.server.domain.Board_Vo;
import com.server.domain.Board_log_Info_Vo;
import com.server.domain.Criteria;
import com.server.domain.Criteria_BoardList;
import com.server.dto.HashTagDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class Board_DAO_Test {

	@Inject
	Board_DAO_IF boardDao;

	private Board_Vo board1;
	private Board_Vo board2;
	private Board_Vo board3;
	
	private Board_log_Info_Vo logVo;

	@Before
	public void setUp() {
		board1 = new Board_Vo();// 글 title =not null b_parent_no=null

		// board1.setB_parent_no();
		board1.setB_title("게시물");
		board1.setB_writer("sky5367");
		board1.setB_content("게시물 컨텐츠 컨텐츠 아아아아아아");

		List<String> hList = new LinkedList<String>();
		hList.add("과외 구합니다");
		hList.add("아몰랑 해쉬태그");
		hList.add("엘젤리너스!빠워해쉬");
		board1.setHashTagList(hList);

		List<String> likeList = new LinkedList<String>();
		likeList.add("sky5367");
		likeList.add("jkh662");
		likeList.add("문제점 없는 id도 좋아요가됨 ....");
		board1.setLikeList(likeList);

		// -------------------------------------------------
		
		logVo=new Board_log_Info_Vo();
		logVo.createBoardLog("jkh662");
		logVo.setB_log_recipient("sky5367");

	}
/*
	@Test
	public void TestRegistBoardAndReply() throws Exception {
		boardDao.deleteAll();

		boardDao.create(board1);

		addReply(boardDao.get(board1.getB_title()).getB_no());

		// addReply(boarDao.get());
		
		 * board1 ㄴ---> board2(reply) ㄴ---> board3(reply) ㄴ---> board2(reply)
		 * ㄴ---> board2(reply)
		 

		List<Board_Vo> replyList = boardDao.getReplyList(boardDao.get(board1.getB_title()).getB_no());
		System.out.println(replyList.toString());

	}*/

/*	@Test
	public void ViewPlusAndLikePlus() throws Exception {
		boardDao.deleteAll();

		boardDao.create(board1);

		int b_no = boardDao.get(board1.getB_title()).getB_no();

		boardDao.likeplus(b_no, "jkh662");
		boardDao.likeplus(b_no, "rlatjduf510");
		boardDao.likeplus(b_no, "jkgasdf223");
		List<String> likeList = boardDao.getLikeList(b_no);
		assertThat(likeList.size(), is(3));

		boardDao.viewplus(b_no);
		boardDao.viewplus(b_no);

		int viewcnt = boardDao.get(board1.getB_title()).getB_viewcnt();

		assertThat(viewcnt, is(2));
	}

	@Test
	public void UpdateTest() throws Exception {
		boardDao.deleteAll();

		boardDao.create(board1);
		int b_no = boardDao.get(board1.getB_title()).getB_no();

		// addReply(boardDao.get(board1.getB_title()).getB_no());

		board1.setB_content("내용변경");
		board1.setB_no(b_no);
		boardDao.update(board1);

		assertThat(boardDao.get(board1.getB_title()).getB_content(), is("내용변경"));

	}*/

	
	/*
	@Test
	public void getListCount()throws Exception{
		Criteria cri=new Criteria();
		cri.setHashtag("과외구함니다");
		cri.setPage(1);
		
		
		
		System.out.println(boardDao.countPaging(cri));
		
		
	}
	
	@Test
	public void getHashTagList()throws Exception{
		String hashTag="과외구함니다";
		
		Criteria_BoardList cri_bl=new Criteria_BoardList();
		cri_bl.setHashtag("과외구함니다");
		cri_bl.setPage(4);
		
		List<Integer> b_noList=boardDao.getHashTagList(hashTag);
		
		cri_bl.setList(b_noList);
		System.out.println(b_noList.toString());
		System.out.println(b_noList.size());
		
		//List<Board_Vo> bList=boardDao.listCriteria(cri_bl);
		
		List<Board_Vo> list=boardDao.listCriteria(cri_bl);
		
		
		System.out.println(list.toString());		
	}*/
	
	
	/*@Test
	public void getHashTagDTO() throws Exception{
		
		List<HashTagDTO> htDto=boardDao.getBoardHashList();
		
		System.out.println(htDto.get(0).parseTOJSON());		
		
	}*/
	
	@Test
	public void readBoardLog()throws Exception{
		
		boardDao.readBoardLog("sky5367");
		
		
	}
	
	@Test
	public void createBoardLog()throws Exception{
		
		boardDao.createBoardLog(logVo);
		
	}
	
	
	
	
	//-----------test 메서드 분리
	private void addReply(int b_parent_no) throws Exception {

		board2 = new Board_Vo();// 댓글 //title null b_parent_no= null
		board3 = new Board_Vo();// 댓글의 댓글 title null b_parent_no= not null

		board2.setB_title("reply");
		board2.setB_parent_no(b_parent_no);
		board2.setB_writer("sky5367");
		board2.setB_content("댓글 댓글댓글");

		List<String> likeList2 = new LinkedList<String>();
		likeList2.add("sky5367");
		likeList2.add("jkh662");
		likeList2.add("sadfsaf");
		board1.setLikeList(likeList2);

		// ---------------------------------------------
		board3.setB_title("reply");
		board3.setB_parent_no(b_parent_no);
		board3.setB_writer("sky5367");
		board3.setB_content("댓글 파워 달린다 ");

		/*
		 * List<String> likeList3 = new LinkedList<String>();
		 * likeList3.add("sky5367"); likeList3.add("jkh662"); likeList3.add(
		 * "아이디 아이디 좋아요 누른아이디");
		 */
		// board1.setLikeList(likeList3);

		boardDao.create(board2);
		boardDao.create(board3);
	}
}
