package com.server.dao;


import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.server.domain.AttachVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class Attach_DAO_Test {
	
	@Inject
	Attach_DAO_IF attachDao;
	
	
	private AttachVo attachVo1;
	private AttachVo attachVo2;
	private AttachVo attachVo3;
	
	
	@Before
	public void setUp()throws Exception{
		attachVo1=new AttachVo();
		attachVo2=new AttachVo();
		attachVo3=new AttachVo();
		
		attachVo1.setA_filePath("파일경로1");
		attachVo1.setA_u_id("sky5367");
		attachVo1.setA_p_no(13); 
		//attachVo1.setA_b_no(22); 
		
		//게시판 첨부파일
		attachVo2.setA_filePath("파일경로2");
		//attachVo2.setA_u_id("sky5367");
		//attachVo2.setA_p_no(9); 
		attachVo2.setA_b_no(32); 
		
		attachVo3.setA_filePath("파일경로3");
		attachVo3.setA_u_id("sky5367");
		attachVo3.setA_p_no(4); 
		//attachVo3.setA_b_no(23); 
	}
	
	
	@Test 
	public void AddGetAndDelete()throws Exception{
		
		
		attachDao.add(attachVo1);
		attachDao.add(attachVo2);
		attachDao.add(attachVo3);
		
		List<AttachVo> profilephoteList=attachDao.getByA_u_id(attachVo1.getA_u_id());
		
		List<AttachVo> aList2=attachDao.getByA_b_no(attachVo2.getA_b_no());
		
		List<AttachVo> aList3=attachDao.getByA_p_no(attachVo3.getA_p_no());
		
		System.out.println(profilephoteList.get(0).parseTOJSON());
		
		System.out.println(aList2.get(0).parseTOJSON());
		
		System.out.println(aList3.get(0).parseTOJSON());
		
		/*attachDao.delete(attachVo1.getA_no());
		attachDao.delete(attachVo2.getA_no());
		attachDao.delete(attachVo3.getA_no());*/
		
	}
}
