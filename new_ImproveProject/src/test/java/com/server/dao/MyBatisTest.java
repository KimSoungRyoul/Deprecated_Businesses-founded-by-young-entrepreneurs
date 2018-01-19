package com.server.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.server.domain.pofol.Edu_pofol_Impl_Vo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class MyBatisTest {
	
	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Inject
	private Pdf_PofolListDAO_IF plDao;
	
	@Inject
	private Edu_pofol_DAO_IF eduDao;
	
	@Test
	public void testFactory(){
		System.out.println(sqlFactory);
	}
	
	@Test
	public void testSession()throws Exception{
		
		try(SqlSession session=sqlFactory.openSession()) {
			System.out.println(session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	@Test
	public void TestPdf_PofolAdd()throws Exception{
		
		
		//plDao.addEdu(999, "sky5367");
		//plDao.deleteEdu(999);
		
		
	}
	
	
}
