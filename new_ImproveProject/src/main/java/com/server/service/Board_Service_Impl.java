package com.server.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.server.dao.Board_DAO_IF;
import com.server.domain.Board_Vo;
import com.server.domain.Board_log_Info_Vo;
import com.server.domain.Criteria;
import com.server.domain.Criteria_BoardList;
import com.server.domain.SearchCriteria;
import com.server.dto.HashTagDTO;

@Service
public class Board_Service_Impl implements Board_Service_IF {

	@Inject
	Board_DAO_IF boardDao;

	@Transactional
	@Override
	public void registBoard(Board_Vo vo) throws Exception {
		// TODO Auto-generated method stub
		boardDao.create(vo);
		Board_Vo voGet = boardDao.getLastCreate();
		List<String> hashList = vo.getHashTagList();

		for (int i = 0; i < hashList.size(); i++) {
			boardDao.registHashTag(voGet.getB_no(), hashList.get(i));
		}

		if (vo.getB_title()== ""||vo.getB_title()==null) {
			Board_log_Info_Vo logVo = new Board_log_Info_Vo();
			Board_Vo getVo = boardDao.get2(vo.getB_parent_no());
			if (getVo.getB_title()!= null){}
				else{
					getVo=boardDao.get2(getVo.getB_parent_no());
				}
			
			logVo.setB_log_recipient(getVo.getB_writer()); // 댓글이 달린 게시물 의 작성자
			logVo.createBoardLog(vo.getB_writer()); // 댓글 작성자
			boardDao.createBoardLog(logVo);
		}

	}

	@Override
	public void createBoardLog(Board_log_Info_Vo vo) throws Exception {
		// TODO Auto-generated method stub
		boardDao.createBoardLog(vo);
	}

	@Override
	public void readBoardLog(String b_log_recipient) throws Exception {
		// TODO Auto-generated method stub
		boardDao.readBoardLog(b_log_recipient);
	}
	@Override
	public List<Board_log_Info_Vo> getBoardLog(String b_log_recipient) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.getBoardLog(b_log_recipient);
	}
	
	
	
	
	
	

	@Override
	public void updateBoard(Board_Vo vo) throws Exception {
		// TODO Auto-generated method stub
		boardDao.update(vo);
	}

	@Override
	public Board_Vo readBoard(Integer bno) throws Exception {
		// TODO Auto-generated met hod stub
		return null;
	}

	@Override
	public void removeBoard(Integer b_no) throws Exception {
		// TODO Auto-generated method stub
		boardDao.delete(b_no);
	}

	@Override
	public List<Board_Vo> listPage(int page) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.listPage(page);
	}

	@Override
	public List<Board_Vo> listCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		List<Integer> list = boardDao.getHashTagList(cri.getHashtag());

		Criteria_BoardList cri_bl = new Criteria_BoardList();
		cri_bl.setList(list);
		cri_bl.setHashtag(cri.getHashtag());
		cri_bl.setPage(cri.getPage());
		cri_bl.setPerPageNum(cri.getPerPageNum());

		List<Board_Vo> boardList = boardDao.listCriteria(cri_bl);
		
		for(Board_Vo vo:boardList){
			vo.setB_regDate(vo.getB_regDate().replace(".0", ""));
		}

		//HashTagDTO hDto=new HashTagDTO();
		
		

		for (Board_Vo vo : boardList) {
			vo.setHashTagList(boardDao.getHashTagListForBoard(vo.getB_no()));
		}
		
		
		for (Board_Vo vo : boardList) {
			vo.setLikeList(boardDao.getLikeList(vo.getB_no()));
		}

		return boardList;
	}

	@Override
	public List<Board_Vo> getMyBoardList(String b_u_id) throws Exception {
		// TODO Auto-generated method stub
		List<Board_Vo> boardList = boardDao.getMyBoardList(b_u_id);

		for (Board_Vo vo : boardList) {
			vo.setLikeList(boardDao.getLikeList(vo.getB_no()));
		}

		return boardList;
	}

	@Override
	public List<Board_Vo> getListReply(int b_parent_no) throws Exception {
		// TODO Auto-generated method stub
		List<Board_Vo> boardList=boardDao.getReplyList(b_parent_no);
		for(Board_Vo vo:boardList){
			vo.setB_regDate(vo.getB_regDate().replace(".0", ""));
		}
		return boardList;
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Board_Vo> listSearchCriteria(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void increaseLikeCnt(Integer b_no, String likedId) throws Exception {
		// TODO Auto-generated method stub
		boardDao.likeplus(b_no, likedId);
	}

	@Override
	public int getTotalBoardCount(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.countPaging(cri);
	}

	@Override
	public List<HashTagDTO> getBoardHashList() throws Exception {
		// TODO Auto-generated method stub
		return boardDao.getBoardHashList();
	}

	

}
