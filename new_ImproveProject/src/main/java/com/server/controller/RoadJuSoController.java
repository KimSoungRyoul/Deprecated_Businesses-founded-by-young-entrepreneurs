package com.server.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.server.dto.JuSoDTO;

@Controller
@RequestMapping("/RoadName_Address")
public class RoadJuSoController {

	private static final Logger logger = LoggerFactory.getLogger(RoadJuSoController.class);

	public static int INDENT_FACTOR = 4;

	@RequestMapping(value = "/apiSampleXML", method = RequestMethod.GET)
	public void GetJuSo(Model model) throws Exception {
		logger.info("jsp get...........");
	}

		
	@RequestMapping(value = "/getAddrApi.do", produces = "application/json;charset=UTF-8")
	public ResponseEntity<String> getAddrApi(@RequestBody JuSoDTO dto) throws Exception { // 요청변수
																							// //
																							// 설정
		ResponseEntity<String> entity = null;

		String currentPage = dto.getCurrentPage();
		String countPerPage = dto.getCountPerPage();
		String confmKey = dto.getConfmKey();
		String keyword = dto.getKeyword(); // OPEN API 호출 URL 정보 설정
		String apiUrl = "http://www.juso.go.kr/addrlink/addrLinkApi.do?currentPage=" + currentPage + "&countPerPage="
				+ countPerPage + "&keyword=" + URLEncoder.encode(keyword, "UTF-8") + "&confmKey=" + confmKey;

		logger.info(apiUrl);

		URL url = new URL(apiUrl);
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		StringBuffer sb = new StringBuffer();
		String tempStr = null;

		while (true) {
			tempStr = br.readLine();
			if (tempStr == null)
				break;
			sb.append(tempStr); // 응답결과 XML 저장
		}

		JSONObject xmlJSONObj = XML.toJSONObject(sb.toString());
		String jsonPrettyPrintString = xmlJSONObj.toString(INDENT_FACTOR);
		//System.out.println(jsonPrettyPrintString);
		
		
		int listPoint=jsonPrettyPrintString.indexOf("juso");
		String jsonJuSoListStr= jsonPrettyPrintString.substring(listPoint+6, jsonPrettyPrintString.length());
		
		/*
		JSONArray jusoArray = new JSONArray(jsonJuSoListStr);

		List<JuSo> jusoList = new LinkedList<JuSo>();
		JuSo juso = new JuSo();
		
		
		for (int n = 0; n < jusoArray.length(); n++) {
			JSONObject object = jusoArray.getJSONObject(n);
			juso = new JuSo();
			juso = juso.parseTOObject(object.toString());
			jusoList.add(juso);
		}*/

		//System.out.println(jusoList.toString());

		br.close();

		entity = new ResponseEntity<String>(jsonJuSoListStr, HttpStatus.OK);

		return entity;

	}

	// roadAddress jsp Test page
	@RequestMapping(value = "/getAddrApi2.do")
	public void getAddrApi(HttpServletRequest req, ModelMap model, HttpServletResponse response) throws Exception { // 요청변수
																													// //
																													// 설정
		String currentPage = req.getParameter("currentPage");
		String countPerPage = req.getParameter("countPerPage");
		String confmKey = req.getParameter("confmKey");
		String keyword = req.getParameter("keyword"); // OPEN API 호출 URL 정보 설정
		String apiUrl = "http://www.juso.go.kr/addrlink/addrLinkApi.do?currentPage=" + currentPage + "&countPerPage="
				+ countPerPage + "&keyword=" + URLEncoder.encode(keyword, "UTF-8") + "&confmKey=" + confmKey;

		logger.info(apiUrl);

		URL url = new URL(apiUrl);
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		StringBuffer sb = new StringBuffer();
		String tempStr = null;

		while (true)

		{
			tempStr = br.readLine();
			if (tempStr == null)
				break;
			sb.append(tempStr); // 응답결과 XML 저장 } br.close();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/xml");
			response.getWriter().write(sb.toString()); // 응답결과 반환 }

		}

	}

}
