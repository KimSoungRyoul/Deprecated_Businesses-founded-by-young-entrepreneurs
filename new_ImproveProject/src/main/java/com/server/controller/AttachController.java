package com.server.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.server.domain.AttachVo;
import com.server.domain.Multi_Media_VO;
import com.server.dto.UploadFileDTO;
import com.server.service.Pofol_Service_IF;
import com.server.util.MediaUtils;
import com.server.util.MultipartFileSender;

@Controller
@RequestMapping("/attach")
public class AttachController {

	private static final Logger logger = LoggerFactory.getLogger(AttachController.class);

	//@Resource(name = "uploadPath")
	private String uploadPath=System.getenv("uploadPath");

	@Inject
	Pofol_Service_IF pofolService;
	
	
	
	
	@RequestMapping(value = "/uploadForm", method = RequestMethod.GET)
	public void uploadForm(@RequestParam("a_p_no") int a_p_no, @RequestParam("a_u_id") String a_u_id) {
		logger.info("이미지 전송페이지 열기.....");
	}
	
	
	@RequestMapping(value = "/uploadAttachedFile", method = RequestMethod.POST, produces = "multipart/form-data;charset=UTF-8")
	public ResponseEntity<String> uploadAttach(MultipartFile file, @RequestParam("a_p_no")Integer a_p_no, @RequestParam("a_u_id")String a_u_id) throws Exception {

		logger.info("[uploadAttach] 이미지서버로 Form형식에서 전송!!!하기.....");
		logger.info("originalName: " + file.getOriginalFilename());
		logger.info("size: " + file.getSize());
		logger.info("contentType: " + file.getContentType());
		
		AttachVo vo = new AttachVo();
		// String a_fullname = UploadFileUtils.uploadFile(uploadPath,
		// file.getOriginalFilename(), file.getBytes());
		// vo.setA_filePath(a_fullname);
		vo.setA_p_no(a_p_no);
		vo.setA_u_id(a_u_id);

		String a_fullname = pofolService.attachFile(vo, file, uploadPath);

		logger.info("데이터베이스 이미지 파일 이름: " + a_fullname);

		return new ResponseEntity<String>(a_fullname, HttpStatus.CREATED);
	}
	
	//produces = "multipart/form-data;charset=UTF-8"
	@ResponseBody
	@RequestMapping(value = "/uploadMedaiAttachedFile", method = RequestMethod.POST, produces = "multipart/form-data;charset=UTF-8" )
	public ResponseEntity<String> uploadMediaAttach(MultipartFile file, @RequestParam("a_p_no")Integer a_p_no) throws Exception {

		logger.info("[uploadMediaAttach] 동영상서버로 Form형식에서 전송!!!하기.....");
		logger.info("originalName: " + file.getOriginalFilename());
		logger.info("size: " + file.getSize());
		logger.info("contentType: " + file.getContentType());
		
		Multi_Media_VO mediaVo=new Multi_Media_VO();
		// String a_fullname = UploadFileUtils.uploadFile(uploadPath,
		// file.getOriginalFilename(), file.getBytes());
		// vo.setA_filePath(a_fullname);
		mediaVo.setM_p_no(a_p_no);
		

		String a_fullname = pofolService.MediaAttachFile(mediaVo, file, uploadPath);

		logger.info("데이터베이스 동영상파일 이름: " + a_fullname);

		return new ResponseEntity<String>(a_fullname, HttpStatus.CREATED);
	}
	
	
		
	@ResponseBody
	@RequestMapping(value = "/uploadAttachedFileByJSON", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResponseEntity<String> uploadAttachByJSON(@RequestBody UploadFileDTO fileDTO) throws Exception {

		logger.info("[uploadAttach] 이미지서버로 Form형식에서 전송!!!하기.....");
		logger.info("originalName: " + fileDTO.getFile().getOriginalFilename());
		logger.info("size: " + fileDTO.getFile().getSize());
		logger.info("contentType: " + fileDTO.getFile().getContentType());
		

		AttachVo vo = new AttachVo();
		// String a_fullname = UploadFileUtils.uploadFile(uploadPath,
		// file.getOriginalFilename(), file.getBytes());
		// vo.setA_filePath(a_fullname);
		vo.setA_p_no(fileDTO.getA_p_no());
		vo.setA_u_id(fileDTO.getA_u_id());

		String a_fullname = pofolService.attachFile(vo, fileDTO.getFile(), uploadPath);

		logger.info("데이터베이스 이미지 파일 이름: " + a_fullname);

		return new ResponseEntity<String>(a_fullname, HttpStatus.CREATED);
	}
	
	
	
	
	
	
	
	
	///////////////////////////////////////////////////////////
	@RequestMapping(value = "/uploadOnlyAttachedFile", method = RequestMethod.POST)
	public ResponseEntity<String> uploadOnlyAttach(MultipartFile file) throws Exception {

		logger.info("[uploadAttach] 이미지서버로 Form형식에서 전송!!!하기.....");
		logger.info("originalName: " + file.getOriginalFilename());
		logger.info("size: " + file.getSize());
		logger.info("contentType: " + file.getContentType());
		

		AttachVo vo = new AttachVo();
		// String a_fullname = UploadFileUtils.uploadFile(uploadPath,
		// file.getOriginalFilename(), file.getBytes());
		// vo.setA_filePath(a_fullname);
		vo.setA_p_no(1);
		vo.setA_u_id(null);

		String a_fullname = pofolService.attachFile(vo, file, uploadPath);

		logger.info("데이터베이스 이미지 파일 이름: " + a_fullname);

		return new ResponseEntity<String>(a_fullname, HttpStatus.CREATED);
	}
	
	/////////////////////////////////////////////////////////////
	
	
	
	
	

	// 1개 의 첨부 파일을 불러온다
	@ResponseBody
	@RequestMapping("/getAttachedFile")
	public ResponseEntity<byte[]> getAttachedFile(String fileName) throws Exception {

		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		logger.info("서버에서 사진을 불러온다 디스플레이.....................");
		logger.info("File NAME: " + fileName);

		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

			MediaType mType = MediaUtils.getMediaType(formatName);

			HttpHeaders headers = new HttpHeaders();

			in = new FileInputStream(uploadPath + fileName);

			if (mType != null) {
				headers.setContentType(mType);
			} else {

				fileName = fileName.substring(fileName.indexOf("_") + 1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attachment; filename=\""
						+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1").replaceAll("\\+", "%20") + "\"");
			}

			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}

	@ResponseBody  //attach
	@RequestMapping(value = "/video", method = RequestMethod.GET)
	  public void getVideo(HttpServletRequest req, HttpServletResponse res, @RequestParam String fileName) {
	    
	    
	    // 데이터 조회
	   // FileModel fileModel = fileService.getFileInfo(Integer.parseInt(id));
	    
	    	    
	    logger.info("동영상 스트리밍 요청 : " + uploadPath + fileName);
	    
	    File getFile = new File(uploadPath +fileName);
	    
	    try {
	      // 미디어 처리
	      MultipartFileSender
	        .fromFile(getFile)
	        .with(req)
	        .with(res)
	        .serveResource();
	      
	    } catch (Exception e) {
	      // 사용자 취소 Exception 은 콘솔 출력 제외
	      if (!e.getClass().getName().equals("org.apache.catalina.connector.ClientAbortException")) e.printStackTrace();
	    }
	  }
	
	
	@ResponseBody
	@RequestMapping(value = "/getAttachListByPofolNum", method = RequestMethod.GET)
	public ResponseEntity<List<AttachVo>> getAttachListByPofolNum(Integer a_p_no) throws Exception {

		logger.info("해당 경력(c_no)에 일치하는 AttachList 요청...........................");

		ResponseEntity<List<AttachVo>> entity = null;

		try {
			entity = new ResponseEntity<List<AttachVo>>(pofolService.getAttached_PofolFileList(a_p_no), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<AttachVo>>(HttpStatus.BAD_REQUEST);
		}
		
		
		return entity;

	}
	
	@RequestMapping(value = "/deleteMediaFile", method = RequestMethod.POST)
	public ResponseEntity<String> deleteMediaFile(@RequestBody String fileName) throws Exception {

		logger.info("delete file: " + fileName);

		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

		MediaType mType = MediaUtils.getMediaType(formatName);

		if (mType != null) {

			String front = fileName.substring(0, 12);
			String end = fileName.substring(14);
			new File(uploadPath + (front + end).replace('/', File.separatorChar)).delete();
		}

		new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();

		pofolService.deleteMediaFileByFileName(fileName);

		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
	public ResponseEntity<String> deleteFile(@RequestBody String fileName) throws Exception {

		logger.info("delete file: " + fileName);

		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

		MediaType mType = MediaUtils.getMediaType(formatName);

		if (mType != null) {

			String front = fileName.substring(0, 12);
			String end = fileName.substring(14);
			new File(uploadPath + (front + end).replace('/', File.separatorChar)).delete();
		}

		new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();

		pofolService.deleteFileByName(fileName);

		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

	// 포트폴리오 지울때 관련 첨부파일도 전부 지울때 사용
	@RequestMapping(value = "/deleteAllFilesInPofol", method = RequestMethod.POST)
	public ResponseEntity<String> deleteAllFileInPofol(int p_no) throws Exception {

		List<AttachVo> aList = pofolService.getAttached_PofolFileList(p_no);

		logger.info("delete all files: " + aList);

		if (aList == null || aList.size() == 0) {
			return new ResponseEntity<String>("deleted", HttpStatus.OK);
		}

		for (AttachVo file : aList) {
			String fileName = file.getA_filePath();
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

			MediaType mType = MediaUtils.getMediaType(formatName);

			if (mType != null) {

				String front = fileName.substring(0, 12);
				String end = fileName.substring(14);
				new File(uploadPath + (front + end).replace('/', File.separatorChar)).delete();
			}

			new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();

		}

		pofolService.deleteFileByP_no(p_no);

		return new ResponseEntity<String>("DELETEDALL", HttpStatus.OK);
	}

}
