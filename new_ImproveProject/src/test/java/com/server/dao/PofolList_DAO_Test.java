package com.server.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.server.domain.pofol.Edu_pofol_Impl_Vo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class PofolList_DAO_Test {

	@Autowired
	Pdf_PofolListDAO_IF pdfListDao;
	
	private String uniqueResumeKey;
	
	@Before
	public void setup(){
		uniqueResumeKey="qawsedrf";
		
		
	}
	
	@Test
	public void Testget()throws Exception{
		
		List<Edu_pofol_Impl_Vo> eduList=pdfListDao.getEduList(uniqueResumeKey);
		
		
	}
	
	
	
	
}
