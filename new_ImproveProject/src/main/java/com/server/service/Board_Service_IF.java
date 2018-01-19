package com.server.service;

import java.util.List;

import com.server.domain.Board_Vo;
import com.server.domain.Board_log_Info_Vo;
import com.server.domain.Criteria;
import com.server.domain.SearchCriteria;
import com.server.dto.HashTagDTO;

public interface Board_Service_IF {

	public void registBoard(Board_Vo vo) throws Exception;

	public void updateBoard(Board_Vo vo) throws Exception;

	public Board_Vo readBoard(Integer bno) throws Exception;

	public void removeBoard(Integer bno) throws Exception;
	
	public List<Board_Vo> listPage(int page)throws Exception;
	
	
	public List<HashTagDTO> getBoardHashList()throws Exception;
	public List<Board_Vo> listCriteria(Criteria cri_bl) throws Exception;
	public List<Board_Vo> getListReply(int b_parent_no)throws Exception;

	
	public int listCountCriteria(Criteria cri) throws Exception;

	public List<Board_Vo> listSearchCriteria(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

	public void increaseLikeCnt(Integer b_no,String likedId) throws Exception;

	public int getTotalBoardCount(Criteria cri)throws Exception;

	public List<Board_Vo> getMyBoardList(String b_u_id) throws Exception;
	
	public void createBoardLog(Board_log_Info_Vo vo)throws Exception;
	public void readBoardLog(String b_log_recipient)throws Exception;
	public List<Board_log_Info_Vo> getBoardLog(String b_log_recipient)throws Exception;
}
