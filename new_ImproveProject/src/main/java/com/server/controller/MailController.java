package com.server.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.Properties;
import java.util.UUID;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.inject.Inject;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.server.domain.pofol.Edu_pofol_Impl_Vo;
import com.server.domain.pofol.Language_pofol_Impl_Vo;
import com.server.domain.pofol.MainAct_pofol_Impl_Vo;
import com.server.domain.pofol.Military_pofol_Impl_Vo;
import com.server.domain.pofol.Qualifi_pofol_Impl_Vo;
import com.server.dto.PofolListInPdfDTO;

import com.server.service.Pdf_PofolListService_IF;
import com.server.service.Pdf_Service;
import com.server.service.Pofol_Service_IF;
import com.server.service.ResumeService;
import com.server.service.User_Info_Service_IF;

@Controller
@RequestMapping("/mail")
public class MailController {

	@Inject
	User_Info_Service_IF userService;

	@Inject
	Pofol_Service_IF pofolService;

	@Inject
	Pdf_PofolListService_IF pdf_PofolListService;

	@Autowired
	ResumeService resumeService;

	private String host = "smtp.gmail.com";
	private final String username = "kzkzsskz@gmail.com";
	private final String password = "1q2w3e4r!@";
	//private int port = 465;
	
	private int port=587;
	
	private String subject = "자신을 향상시키다 -ImProve PDF이력서  ";

	private String body = "안녕하십니까, 고객 만족에 최선을 다하는 improve 입니다.\n"
			+ " 보내드리는 PDF파일 내 주민번호 등 개인정보는 서버에 일체 저장하지 않으며 수집하고 있지 않습니다.\n" + " 안심하시고 귀하의 발전을 응원합니다!\n"
			+ "improve 올림 불편하신 점이나 문의사항에 대해서는 카카오톡 yellow ID : improve 로 연락주시면 친절히 상담해드리겠습니다.\n" + " 감사합니다.";

	@RequestMapping(value = "/sendPdfMail", method = RequestMethod.POST)
	public ResponseEntity<String> sendMail(@RequestBody PofolListInPdfDTO plDto) throws Exception {

		ResponseEntity<String> entity = null;

		// User_Info_Vo userVo = userService.Login(dto);
		String uniqueResumeKey = UUID.randomUUID().toString().replace("-", "");
		
		
		//String fileName = "C:\\zzz\\upload\\2016\\08\\22\\"+plDto.getUserVo().getU_id()+".pdf";
		String fileName = "/pdfFolder/" + plDto.getUserVo().getU_id()+"_"+uniqueResumeKey+ ".pdf";

		
		/*if(plDto.getEduList().isEmpty()){
			plDto.setEduList(new LinkedList<Edu_pofol_Impl_Vo>());
		}
		if(plDto.getLanguageList().isEmpty()){
			plDto.setLanguageList(new LinkedList<Language_pofol_Impl_Vo>());
		}
		if(plDto.getMainActList().isEmpty()){
			plDto.setMainActList(new LinkedList<MainAct_pofol_Impl_Vo>());
		}
		if(plDto.getQualifiList().isEmpty()){
			plDto.setQualifiList(new LinkedList<Qualifi_pofol_Impl_Vo>());
		}
		if(plDto.getMilitaryList().isEmpty()){
			plDto.setMilitaryList(new LinkedList<Military_pofol_Impl_Vo>());
		}
		*/
		
		
		
		
		

		// pdf 생성 안됨 개짜증남
		Pdf_Service pdfService = new Pdf_Service(plDto);
		pdfService.createPdf(fileName, uniqueResumeKey);

		resumeService.registResume(plDto, uniqueResumeKey);

		String recipient = plDto.getUserVo().getU_email();

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
			
		
		
		/*props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", host);

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			String un = username;
			String pw = password;

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(un, pw);
			}
		});*/
		
		
		//session.setDebug(true); // for debug

		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(username));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient, plDto.getUserVo().getU_name()));

		msg.setSubject(subject);
		msg.setSentDate(new Date());

		// 파일첨부를 위한 Multipart
		Multipart multipart = new MimeMultipart();

		// BodyPart를 생성
		BodyPart bodyPart = new MimeBodyPart();
		// bodyPart.setText(body);

		// 1. Multipart에 BodyPart를 붙인다.
		multipart.addBodyPart(bodyPart);

		// 2.attach file

		// pdfService.createPdf(filename);

		DataSource source = new FileDataSource(fileName);
		bodyPart.setDataHandler(new DataHandler(source));
		bodyPart.setFileName("ImproveResume.pdf");

		bodyPart = new MimeBodyPart();
		// text/plain 이지만 어짜피 나중에 html로 작성해야되니까 걍둔다
		bodyPart.setContent(body, "text/html;charset=UTF-8");
		multipart.addBodyPart(bodyPart);

		// 이메일 메시지의 내용에 Multipart를 붙인다.
		msg.setContent(multipart);
		Transport.send(msg);

		entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		return entity;
	}

}
