package com.server.controller;

import java.util.List;
import java.util.Properties;

import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.server.domain.User_Info_Vo;
import com.server.dto.LoginDTO;
import com.server.service.User_Info_Service_IF;

@Controller
@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	private User_Info_Service_IF userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<User_Info_Vo> Login(@RequestBody LoginDTO dto) throws Exception {

		logger.info("로그인 시도 확인.............................");

		ResponseEntity<User_Info_Vo> entity = null;

		try {

			entity = new ResponseEntity<User_Info_Vo>(userService.Login(dto), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			User_Info_Vo vo = new User_Info_Vo();
			entity = new ResponseEntity<User_Info_Vo>(vo, HttpStatus.BAD_REQUEST);
			return entity;
		}

		return entity;

	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> SignUp(@RequestBody User_Info_Vo userVo) throws Exception {

		logger.info("회원가입요청  .............................");

		ResponseEntity<String> entity = null;

		try {
			userService.SignUp(userVo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;

	}

	@RequestMapping(value = "/IsDuplicated", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> IsDuplicated(@RequestBody String u_id) throws Exception {

		logger.info("아이디 중복 체크요청  .............................");

		ResponseEntity<String> entity = null;

		try {
			entity = new ResponseEntity<String>(userService.IsDuplicated(u_id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;

	}

	
	
	@RequestMapping(value = "/modifiedUser_Info", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> modifiedUser_Info(@RequestBody User_Info_Vo userVo) throws Exception {

		logger.info("회원 정보 수정 요청  .............................");

		ResponseEntity<String> entity = null;

		try {
			userService.UpdateUser_Info(userVo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;

	}

	@RequestMapping(value = "/withdrawUser", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> withdrawUser(@RequestBody LoginDTO dto) throws Exception {

		logger.info("탈퇴 시도....not clear.........................");

		ResponseEntity<String> entity = null;

		try {

			userService.withdrawUser(dto.getU_id());
			
			entity=new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;

	}

	@RequestMapping(value = "/findAccount", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> findAccount(@RequestBody String u_email) throws Exception {

		logger.info("계정 찾기 시도... 이메일 발송...........................");

		ResponseEntity<String> entity = null;

		try {
			List<User_Info_Vo> userList = userService.getUser_InfoByEmail(u_email);
			String bodycontent="";
			for(int i=0;i<userList.size();i++){
				bodycontent="안녕하세요 임프로브입니다.\n\n아이디 :"+ userList.get(0).getU_id()+"\n비밀번호 :"+userList.get(0).getU_pw()+"\n\n아이디, 비밀번호가 일치하지 않는다면 카카오톡 옐로아이디 혹은 페이스북를 통해 문의 부탁드립니다.\n보안 관계상 비밀번호를 꼭 변경해주세요.\n항상 노력하는 임프로브가 되겠습니다. 감사합니다.";
				sendMail(bodycontent,u_email);
			}
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;

	}
	
	
	
	private void sendMail(String bodycontent,String u_email)throws Exception{
		
		String host = "smtp.gmail.com";
		final String username = "kzkzsskz@gmail.com";
		final String password = "1q2w3e4r!@";
		int port = 587;

		
		
		
		
		String recipient=u_email;
		String subject = "자신을 향상시키다 -ImProve PDF이력서  ";
		String body = bodycontent;
		
		Properties props = System.getProperties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				  });
			
		/*// properties 설정
		Properties props = new Properties();
		props.put("mail.smtps.auth", "true");
		// 메일 세션
		Session session = Session.getDefaultInstance(props);*/
		MimeMessage msg = new MimeMessage(session);

		// 메일 관련
		msg.setSubject(subject);
		msg.setText(body);
		msg.setFrom(new InternetAddress(username));
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

		// 발송 처리
		Transport transport = session.getTransport("smtps");
		transport.connect(host, username, password);
		transport.sendMessage(msg, msg.getAllRecipients());
		transport.close();

		
		
	}
	
	
	
	
	
	
	
	
	

}