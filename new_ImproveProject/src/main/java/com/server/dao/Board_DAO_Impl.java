package com.server.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.server.domain.Board_Vo;
import com.server.domain.Board_log_Info_Vo;
import com.server.domain.Criteria;
import com.server.domain.Criteria_BoardList;
import com.server.domain.SearchCriteria;
import com.server.dto.HashTagDTO;


@Repository
public class Board_DAO_Impl implements Board_DAO_IF {

	@Inject
	SqlSession session;
	
	private static String namespace="com.server.mapper.boardMapper";
	
	
	
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".deleteAll");
	}
	
	
	
	
	@Override
	public void createBoardLog(Board_log_Info_Vo vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".createBoardLog", vo);
	}
	@Override
	public void readBoardLog(String b_log_recipient) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".readBoardLog", b_log_recipient);
	}
	@Override
	public List<Board_log_Info_Vo> getBoardLog(String b_log_recipient) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".getBoardLog", b_log_recipient);
	}
	
	
	
	
	
	@Override
	public void create(Board_Vo vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".create", vo);
	}
	
	@Override
	public List<String> getLikeList(int b_no) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".getLikeList", b_no);
	}
	
	@Override
	public List<Board_Vo> getReplyList(Integer b_no) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".getReplyList", b_no);
	}
	
	
	@Override
	public void registHashTag(Integer h_b_no,String h_tagname) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> param=new HashMap<String,Object>();
		param.put("h_b_no", h_b_no);
		param.put("h_tagname",h_tagname);
		
		session.insert(namespace+".registHashTag", param);
	}
	
	

	@Override
	public Board_Vo get(String b_title) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".get",b_title);
	}
	@Override
	public Board_Vo get2(int b_no) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".get2", b_no);
	}
	
	
	@Override
	public void update(Board_Vo vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".update", vo);
	}

	@Override
	public void delete(Integer b_no) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".delete", b_no);
	}
	
	@Override
	public void deleteById(String u_id) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	
	@Override
	public List<Board_Vo> listPage(int page) throws Exception {
		// TODO Auto-generated method stub
		if (page <= 0) {
			page = 1;
		}

		page = (page - 1) * 10;
		
		return session.selectList(namespace+".listpage", page);
	}

	@Override
	public List<Board_Vo> listCriteria(Criteria_BoardList cri_bl) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".listCriteria",cri_bl );
	}

	@Override
	public List<Board_Vo> getMyBoardList(String b_u_id) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".getMyBoardList", b_u_id);
	}

	
	
	
	
	
	@Override
	public void viewplus(Integer b_no) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".viewplus", b_no);
	}

	@Override
	public void likeplus(int lb_b_no,String lb_u_id) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> param=new HashMap<String,Object>();
		param.put("lb_u_id", lb_u_id);
		param.put("lb_b_no",lb_b_no);
		
		session.selectList(namespace+".likeplus", param);
	}

	@Override
	public List<Board_Vo> listSearch(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateReplyCnt(Integer b_no, int amount) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int countPaging(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".countPaging", cri);
	}

	
	



	@Override
	public List<Integer> getHashTagList(String hashtag) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".getHashTagList", hashtag);
	}

	@Override
	public List<HashTagDTO> getBoardHashList() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".getBoardHashList");
	}




	@Override
	public Board_Vo getLastCreate() throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".getLastCreate");
	}

	@Override
	public List<String> getHashTagListForBoard(int h_b_no) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".getHashTagListForBoard", h_b_no);
	}

	

	

	

	




	



	



	

	

	

	

}
