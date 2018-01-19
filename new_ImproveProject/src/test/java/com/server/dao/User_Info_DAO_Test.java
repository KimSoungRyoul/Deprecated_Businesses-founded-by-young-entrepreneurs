package com.server.dao;

/*import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
*/
import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.server.domain.AttachVo;
import com.server.domain.User_Info_Vo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class User_Info_DAO_Test {

	@Inject
	User_Info_DAO_IF userDao;

	
	@Inject
	Attach_DAO_IF attachDao;
	
	private User_Info_Vo user1=new User_Info_Vo(); 
	
	private AttachVo attach1=new AttachVo();
	
	@Before
	public void setUp() {
		

		//user1.setU_no(23);
		user1.setU_name("김성렬");
		user1.setU_id("jkh6e62f2qw3");
		user1.setU_pw("123456");
		user1.setU_pnum("010-7237-6602");
		user1.setU_email("rlatjduf510@naver.com");
		//user1.setU_military("PASS");
		user1.setU_sex("woman");
		user1.setU_birthDate("1993-08-23");
		//user1.setU_regDate("2016-08-11 12:32:22");
		
		attach1=new AttachVo(32, "asdesdff", "asdefsdf", "asdf", 43, 12);
		user1.setU_profilePhoto(attach1);
						
		
	}
	
	
	
	@Test
	public void AddGetDelete() throws Exception{
		userDao.add(user1);
		User_Info_Vo getUser= userDao.get(user1.getU_id(),user1.getU_pw());
				
		AttachVo vo=new AttachVo(32, "asdfdf", "afdfsdf", "2016-03-21", 43, 12);
		getUser.setU_profilePhoto(vo);
		
		user1=userDao.get(user1.getU_id(), user1.getU_pw());
		user1.setU_email("이메일 변경");
		user1.setU_pnum("전화번호변경");
		
		userDao.update(user1);
		System.out.println(getUser.parseTOJSON());
		userDao.delete(user1.getU_id());
		
		
	}
	
	@Test
	public void attachVoTest()throws Exception{
		
		attachDao.add(attach1);
		
		
	}
	
	

}
