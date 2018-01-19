package com.server.dao;

import java.util.List;

import com.server.domain.Board_Vo;
import com.server.domain.Board_log_Info_Vo;
import com.server.domain.Criteria;
import com.server.domain.Criteria_BoardList;
import com.server.domain.SearchCriteria;
import com.server.dto.HashTagDTO;


public interface Board_DAO_IF {
	
	public void deleteAll()throws Exception;
	
	public void create(Board_Vo vo) throws Exception;

	public void registHashTag(Integer h_b_no,String h_tagname) throws Exception ;
	
	public List<Board_Vo> getReplyList(Integer b_no)throws Exception;
	
	public Board_Vo get(String b_title) throws Exception;
	public Board_Vo get2(int b_no)throws Exception;

	public void update(Board_Vo vo) throws Exception;

	public void delete(Integer b_no) throws Exception;
	
	//----------테스트 완료 success
	
	//게시판 로그 DAO메서드
	public void createBoardLog(Board_log_Info_Vo vo)throws Exception;
	public void readBoardLog(String b_log_recipient)throws Exception;
	public List<Board_log_Info_Vo> getBoardLog(String b_log_recipient)throws Exception;
	
	
	public Board_Vo getLastCreate()throws Exception;
	
	
	
	public List<Board_Vo> listPage(int page)throws Exception;
	
	public List<Board_Vo> listCriteria(Criteria_BoardList cri)throws Exception;
	
	public int countPaging(Criteria cri)throws Exception;
	
	
	public List<HashTagDTO> getBoardHashList()throws Exception;
	public List<Integer> getHashTagList(String hashtag)throws Exception;
	
	public void viewplus(Integer b_no)throws Exception;
	
	public void likeplus(int b_no,String likedId)throws Exception;
	
	
	public List<Board_Vo> listSearch(SearchCriteria cri)throws Exception;
	
	public int listSearchCount(SearchCriteria cri)throws Exception;
	
	public void updateReplyCnt(Integer b_no,int amount)throws Exception;

	public List<String> getLikeList(int b_no)throws Exception;

	public List<Board_Vo> getMyBoardList(String b_u_id);

	public void deleteById(String u_id)throws Exception;
	
	
	
	public List<String> getHashTagListForBoard(int h_b_no)throws Exception;
	
		
}
