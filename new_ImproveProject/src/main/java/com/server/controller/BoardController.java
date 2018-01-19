package com.server.controller;

import java.util.List;

import javax.inject.Inject;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.server.domain.Board_Vo;
import com.server.domain.Board_log_Info_Vo;
import com.server.domain.Criteria;
import com.server.domain.PageMaker;
import com.server.dto.BoardDTO;
import com.server.dto.HashTagDTO;
import com.server.service.Board_Service_IF;

@Controller
@RequestMapping("/board")
public class BoardController {

	//private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	Board_Service_IF boardService;
	
	
	@RequestMapping(value = "/registBoard", method = RequestMethod.POST)
	public ResponseEntity<String> registBoard(@RequestBody Board_Vo vo) throws Exception {

		//logger.info("게시판 정보 등록.............................");

		ResponseEntity<String> entity = null;
						
		try {
			boardService.registBoard(vo);			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

		return entity;

	}
	
	
	@RequestMapping(value = "/updateBoard", method = RequestMethod.POST)
	public ResponseEntity<String> updateBoard(@RequestBody Board_Vo vo) throws Exception {
		ResponseEntity<String> entity = null;
		
		try {
			boardService.updateBoard(vo);		
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
	
	@RequestMapping(value = "/deleteBoard", method = RequestMethod.POST)
	public ResponseEntity<String> deleteBoard(@RequestBody Integer b_no) throws Exception {
		ResponseEntity<String> entity = null;
	
		try {
			boardService.removeBoard(b_no);			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value = "/getHashBoardList", method = RequestMethod.POST)
	public ResponseEntity<List<HashTagDTO>> getHashBoardList() throws Exception {
		ResponseEntity<List<HashTagDTO>> entity = null;
	
		try {
			entity = new ResponseEntity<List<HashTagDTO>>(boardService.getBoardHashList(), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<HashTagDTO>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
	
	
	@RequestMapping(value = "/getBoardList", method = RequestMethod.POST)
	public ResponseEntity<List<Board_Vo>> getBoardList(@RequestBody Criteria cri) throws Exception {
		ResponseEntity<List<Board_Vo>> entity = null;
	
		try {
			entity = new ResponseEntity<List<Board_Vo>>(boardService.listCriteria(cri), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<Board_Vo>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value = "/getMyBoardList", method = RequestMethod.POST)
	public ResponseEntity<List<Board_Vo>> getMyBoardList(@RequestBody String b_u_id) throws Exception {
		ResponseEntity<List<Board_Vo>> entity = null;
	
		try {
			entity = new ResponseEntity<List<Board_Vo>>(boardService.getMyBoardList(b_u_id), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<Board_Vo>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
	
	
	
	@RequestMapping(value = "/getReplyList", method = RequestMethod.POST)
	public ResponseEntity<List<Board_Vo>> getReplyList(@RequestBody Integer b_parent_no) throws Exception {
		
		ResponseEntity<List<Board_Vo>> entity = null;
	
		try {
			
			entity = new ResponseEntity<List<Board_Vo>>(boardService.getListReply(b_parent_no), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<Board_Vo>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	//PageMaker 불러오기	
	@RequestMapping(value = "/getPageViewer", method = RequestMethod.POST)
	public ResponseEntity<PageMaker> getPageViewer(@RequestBody Criteria cri) throws Exception {
		ResponseEntity<PageMaker> entity = null;
		PageMaker pageMaker=new PageMaker();
		
		
		try {
		
			pageMaker.setCri(cri);
			
			pageMaker.setTotalCount(boardService.getTotalBoardCount(cri));
			
			//System.out.println(pageMaker.toString());
			
			entity = new ResponseEntity<PageMaker>(pageMaker, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<PageMaker>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
	@RequestMapping(value="/plusLike", method=RequestMethod.POST)
	public ResponseEntity<String> plusLike(@RequestBody BoardDTO dto)throws Exception{
		
		ResponseEntity<String> entity=null;
		
		try{
			boardService.increaseLikeCnt(dto.getB_no(), dto.getLike_id());
			entity= new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
			
		}catch(Exception e){
			e.printStackTrace();
			entity= new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		
		return entity;
	}
	
	
	@RequestMapping(value="/readBoardLog", method=RequestMethod.POST)
	public ResponseEntity<String> readBoardLog(@RequestBody String b_log_recipient)throws Exception{
		
		ResponseEntity<String> entity=null;
		
		try{
			boardService.readBoardLog(b_log_recipient);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			
		}catch(Exception e){
			e.printStackTrace();
			entity= new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		
		return entity;
	}
	
	@RequestMapping(value="/getBoardLog", method=RequestMethod.POST)
	public ResponseEntity<List<Board_log_Info_Vo>> getBoardLog(@RequestBody String b_log_recipient)throws Exception{
		
		ResponseEntity<List<Board_log_Info_Vo>> entity=null;
		
		try{
			entity=new ResponseEntity<List<Board_log_Info_Vo>>(boardService.getBoardLog(b_log_recipient),HttpStatus.OK);
			
		}catch(Exception e){
			e.printStackTrace();
			entity= new ResponseEntity<List<Board_log_Info_Vo>>(HttpStatus.BAD_REQUEST);
		}
		
		
		return entity;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
