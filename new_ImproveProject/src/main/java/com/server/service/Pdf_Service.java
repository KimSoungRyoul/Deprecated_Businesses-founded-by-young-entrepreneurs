package com.server.service;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.imageio.ImageIO;

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.server.domain.User_Info_Vo;
import com.server.domain.pofol.Award_pofol_Impl_Vo;
import com.server.domain.pofol.Edu_pofol_Impl_Vo;
import com.server.domain.pofol.Language_pofol_Impl_Vo;
import com.server.domain.pofol.MainAct_pofol_Impl_Vo;
import com.server.domain.pofol.Military_pofol_Impl_Vo;
import com.server.domain.pofol.Qualifi_pofol_Impl_Vo;
import com.server.dto.PofolListInPdfDTO;

public class Pdf_Service {

	private String juso;
	private User_Info_Vo userVo;
	private List<Edu_pofol_Impl_Vo> eduList;
	private List<Award_pofol_Impl_Vo> awardList;
	private List<Language_pofol_Impl_Vo> languageList;
	private List<MainAct_pofol_Impl_Vo> mainActList;
	private List<Qualifi_pofol_Impl_Vo> qualifiList;
	private List<Military_pofol_Impl_Vo> militaryList;

	//private static String uploadPath="C:\\Users\\jjc10\\Desktop\\improve";
		
	private static String uploadPath = System.getenv("uploadPath");
	

	private static String fontPath="C:\\zzz\\font\\";
	//private static String fontPath= "";
	
	//private static String fontPath = "";

			
	public Pdf_Service() {
		// TODO Auto-generated constructor stub

	}

	public Pdf_Service(User_Info_Vo userVo, List<Edu_pofol_Impl_Vo> eduList, List<Award_pofol_Impl_Vo> awardList,
			List<Language_pofol_Impl_Vo> languageList, List<MainAct_pofol_Impl_Vo> mainActList,
			List<Qualifi_pofol_Impl_Vo> qualifiList, List<Military_pofol_Impl_Vo> militaryList) {
		super();
		this.userVo = userVo;
		this.eduList = eduList;
		this.awardList = awardList;
		this.languageList = languageList;
		this.mainActList = mainActList;
		this.qualifiList = qualifiList;
		this.militaryList = militaryList;
	}

	public Pdf_Service(PofolListInPdfDTO plDto) {
		// TODO Auto-generated constructor stub

		this.userVo = plDto.getUserVo();
		this.eduList = plDto.getEduList();
		this.awardList = plDto.getAwardList();
		this.languageList = plDto.getLanguageList();
		this.mainActList = plDto.getMainActList();
		this.qualifiList = plDto.getQualifiList();
		this.militaryList = plDto.getMilitaryList();
		this.juso = plDto.getJuso();

	}

	public void createPdf(String filepath ,String uniqueResumeKey) throws Exception {

		BaseFont NanumMyeongjoFontKey = BaseFont.createFont(fontPath+"font\\NanumMyeongjo.ttf", BaseFont.IDENTITY_H,BaseFont.EMBEDDED);
		BaseFont batangFontKey = BaseFont.createFont(fontPath+"font/HBATANG.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		
		
		BaseFont NanumGothicFontKey = BaseFont.createFont(fontPath+"font\\NanumGothic.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		BaseFont NanumGothicBoldFontKey = BaseFont.createFont(fontPath+"font/NanumGothicBold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

		
		/*
		BaseFont NanumMyeongjoFontKey = BaseFont.createFont(fontPath + "NanumMyeongjo.ttf", BaseFont.IDENTITY_H,
				BaseFont.EMBEDDED);
		BaseFont batangFontKey = BaseFont.createFont(fontPath + "HBATANG.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

		BaseFont NanumGothicFontKey = BaseFont.createFont(fontPath + "NanumGothic.ttf", BaseFont.IDENTITY_H,
				BaseFont.EMBEDDED);
		BaseFont NanumGothicBoldFontKey = BaseFont.createFont(fontPath + "NanumGothicBold.ttf", BaseFont.IDENTITY_H,
				BaseFont.EMBEDDED);
*/

		String urlSource = "www.improve.kr/"+this.getUserVo().getU_id()+"?uniqueResumeKey="+uniqueResumeKey;


		Image qrcodeImage;
		if (urlSource != null) {
			BarcodeQRCode qrcode = new BarcodeQRCode(urlSource.trim(), 1, 1, null);
			qrcodeImage = qrcode.getImage();
		} else
			qrcodeImage = null;

		// step 1
		Document document = new Document(PageSize.A4, 30f, 30f, 25f, 25f);
		// step 2
		PdfWriter.getInstance(document, new FileOutputStream(filepath));
		// step 3
		document.open();

		fillOut_Intro(document, qrcodeImage, NanumMyeongjoFontKey, batangFontKey);

		fillOut_User_Info(document, userVo, this.getMilitaryList(), this.getJuso(), NanumGothicFontKey,
				NanumGothicBoldFontKey);

		if (eduList == null)
			fillOut_EduList(document, eduList, NanumGothicFontKey, NanumGothicBoldFontKey);
		else {
			switch (eduList.size()) {
			
			case 0:
				fillOut_EduList(document,eduList, NanumGothicFontKey, NanumGothicBoldFontKey);
				break;
			case 1:
				fillOut_EduList(document, eduList, 0, NanumGothicFontKey, NanumGothicBoldFontKey);
				break;
			case 2:
				fillOut_EduList(document, eduList, 0, 1, NanumGothicFontKey, NanumGothicBoldFontKey);
				break;
			default :
				fillOut_EduList(document, eduList, eduList.size()-2, eduList.size()-1, NanumGothicFontKey, NanumGothicBoldFontKey);
				
			}
		}

		if (mainActList == null)
			fillOut_MainActivityList(document, mainActList, NanumGothicFontKey, NanumGothicBoldFontKey);
		else {
			switch (mainActList.size()) {
			case 1:
				fillOut_MainActivityList(document, mainActList, 0, NanumGothicFontKey, NanumGothicBoldFontKey);
				break;
			case 2:
				fillOut_MainActivityList(document, mainActList, 0, 1, NanumGothicFontKey, NanumGothicBoldFontKey);
				break;
			case 3:
				fillOut_MainActivityList(document, mainActList, 0, 1, 2, NanumGothicFontKey, NanumGothicBoldFontKey);
				break;
			case 4:
				System.out.println(mainActList.size());
				fillOut_MainActivityList(document, mainActList, 0, 1, 2, 3, NanumGothicFontKey, NanumGothicBoldFontKey);
				break;
			}
		}

		if (awardList == null)
			fillOut_AwardsList(document, awardList, NanumGothicFontKey, NanumGothicBoldFontKey);
		else {
			switch (awardList.size()) {
			case 1:
				fillOut_AwardsList(document, awardList, 0, NanumGothicFontKey, NanumGothicBoldFontKey);
				break;
			case 2:
				fillOut_AwardsList(document, awardList, 0, 1, NanumGothicFontKey, NanumGothicBoldFontKey);
				break;
			}
		}

		if (qualifiList == null)
			fillOut_QualifiList(document, qualifiList, NanumGothicFontKey, NanumGothicBoldFontKey);
		else {
			switch (qualifiList.size()) {
			case 1:
				fillOut_QualifiList(document, qualifiList, 0, NanumGothicFontKey, NanumGothicBoldFontKey);
				break;
			case 2:
				fillOut_QualifiList(document, qualifiList, 0, 1, NanumGothicFontKey, NanumGothicBoldFontKey);
				break;
			}
		}

		if (languageList == null)
			fillOut_LanguageList(document, languageList, NanumGothicFontKey, NanumGothicBoldFontKey);
		else {
			switch (languageList.size()) {
			case 1:
				fillOut_LanguageList(document, languageList, 0, NanumGothicFontKey, NanumGothicBoldFontKey);
				break;
			case 2:
				fillOut_LanguageList(document, languageList, 0, 1, NanumGothicFontKey, NanumGothicBoldFontKey);
				break;
			}
		}

		if (militaryList.size() ==0)
			fillOut_MilitaryList(document, militaryList, NanumGothicFontKey, NanumGothicBoldFontKey);
		else
			fillOut_MilitaryList(document, militaryList, 0, NanumGothicFontKey, NanumGothicBoldFontKey);

		fillOut_Final(document, NanumMyeongjoFontKey, batangFontKey);

		document.close();

	}

	private void fillOut_Intro(Document document, Image qrcode, BaseFont font, BaseFont font2)
			throws DocumentException, IOException {
		// TODO Auto-generated method stub

		Font NanumMyeongjoFont = new Font(font, 25);
		Font batangFont = new Font(font2, 7);

		// title table
		float[] title_widths = { 0.3f, 0.6f, 0.1f };
		PdfPTable title_table = new PdfPTable(title_widths);
		title_table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
		// table total width MAX : 600
		title_table.setTotalWidth(540f);
		title_table.setWidthPercentage(100f);
		title_table.setLockedWidth(true);

		Paragraph title = new Paragraph("이  력  서", NanumMyeongjoFont);
		title.setAlignment(Element.ALIGN_TOP);
		PdfPCell title_cell = new PdfPCell(new Phrase("title"));
		title_cell.setRowspan(5);
		title_cell.addElement(title);
		title_cell.setBorder(PdfPCell.NO_BORDER);
		title_table.addCell(title_cell);

		PdfPCell null1 = new PdfPCell(new Phrase(" "));
		null1.setBorder(PdfPCell.NO_BORDER);
		title_table.addCell(null1);

		PdfPCell cell_image = new PdfPCell(new Phrase("cell1"));
		cell_image.setVerticalAlignment(Element.ALIGN_MIDDLE);

		cell_image.setRowspan(5);
		cell_image.addElement(qrcode);
		cell_image.setBorder(PdfPCell.NO_BORDER);
		title_table.addCell(cell_image);

		PdfPCell null3 = new PdfPCell(new Paragraph("본 이력서는 Improve 앱에서 작성되었습니다.", batangFont));
		null3.setHorizontalAlignment(Element.ALIGN_RIGHT);
		null3.setBorder(PdfPCell.NO_BORDER);
		title_table.addCell(null3);

		PdfPCell null4 = new PdfPCell(new Paragraph("우측 QR코드를 통해 사진·동영상 등 포트폴리오를 확인하실 수 있습니다.", batangFont));
		null4.setHorizontalAlignment(Element.ALIGN_RIGHT);
		null4.setBorder(Rectangle.OUT_TOP);
		null4.setBorder(PdfPCell.NO_BORDER);
		title_table.addCell(null4);

		PdfPCell null2 = new PdfPCell(new Phrase(" "));
		null2.setBorder(PdfPCell.NO_BORDER);
		title_table.addCell(null2);

		document.add(title_table);
	}

	private void fillOut_ProfilePhoto(PdfPTable table, String a_filePath)
			throws BadElementException, MalformedURLException, IOException {
		Image jpg = Image.getInstance(a_filePath);
		jpg.scaleAbsoluteHeight(400f);
		jpg.scaleAbsoluteWidth(500f);
		if (jpg != null) {
			PdfPCell profile_photo = new PdfPCell(jpg, true);
			profile_photo.setRowspan(12);
			profile_photo.setVerticalAlignment(Element.ALIGN_MIDDLE);
			profile_photo.setBorder(PdfPCell.NO_BORDER);
			table.addCell(profile_photo);
		}
	}

	private void fillOut_User_Info(Document document, User_Info_Vo userVo, List<Military_pofol_Impl_Vo> Militarylist,
			String address, BaseFont font, BaseFont font2) throws DocumentException, IOException {
		// TODO Auto-generated method stub

		Font NanumGothicFont = new Font(font, 9);
		Font NanumGothicBoldFont = new Font(font2, 9);

		// personal_info
		Paragraph personal_info = new Paragraph("인적사항", NanumGothicBoldFont);
		personal_info.setSpacingBefore(10);
		personal_info.setSpacingAfter(5);
		document.add(personal_info);

		// draw line
		LineSeparator sep = new LineSeparator();
		sep.setLineWidth(2);
		document.add(sep);

		// profile_table
		float[] profile_table_widths = { 0.22f, 0.05f, 0.16f, 0.55f };
		PdfPTable profile_table = new PdfPTable(profile_table_widths);
		profile_table.setTotalWidth(540f); // 540

		profile_table.setWidthPercentage(100f);
		profile_table.setLockedWidth(true);
		profile_table.setSpacingBefore(10);

		// 순서 중요 순서 건들면 안됨
		if(this.getUserVo().getU_profilePhoto().getA_filePath().isEmpty()){
			fillOut_ProfilePhoto(profile_table, uploadPath + "/defaultProfilePhoto.png");
		}
		else if (this.getUserVo().getU_profilePhoto().getA_filePath() != null) {
			fillOut_ProfilePhoto(profile_table,uploadPath+ "/"+this.getUserVo().getU_profilePhoto().getA_filePath());			
		} else{
			fillOut_ProfilePhoto(profile_table, uploadPath + "/defaultProfilePhoto.png");
		}
			

		PdfPCell nullSpace = new PdfPCell(new Phrase(" "));
		nullSpace.setRowspan(30);
		nullSpace.setBorder(PdfPCell.NO_BORDER);
		profile_table.addCell(nullSpace);

		if (this.getUserVo().getU_name() != null) {
			insertDataInTable(profile_table, "성명", this.getUserVo().getU_name(), NanumGothicFont);
		} else
			insertDataInTable(profile_table, "성명", this.getUserVo().getU_name(), NanumGothicFont);
		insertDataInTable(profile_table, "  ", "  ", NanumGothicFont);
		if (this.getUserVo().getU_sex().equalsIgnoreCase("man")) {
			insertDataInTable(profile_table, "성별", "남성", NanumGothicFont);
		} else
			insertDataInTable(profile_table, "성별", "여성", NanumGothicFont);
		insertDataInTable(profile_table, "  ", "  ", NanumGothicFont);
		if (address != null) {
			insertDataInTable(profile_table, "주소", address, NanumGothicFont);
		} else
			insertDataInTable(profile_table, "주소", "                                  ", NanumGothicFont);
		insertDataInTable(profile_table, "  ", "  ", NanumGothicFont);
		if (this.getUserVo().getU_pnum() != null) {
			insertDataInTable(profile_table, "휴대전화", this.getUserVo().getU_pnum(), NanumGothicFont);
		} else
			insertDataInTable(profile_table, "휴대전화", this.getUserVo().getU_pnum(), NanumGothicFont);
		insertDataInTable(profile_table, "  ", "  ", NanumGothicFont);
		if (this.getUserVo().getU_email() != null) {
			insertDataInTable(profile_table, "E-mail", this.getUserVo().getU_email(), NanumGothicFont);
		} else
			insertDataInTable(profile_table, "E-mail", this.getUserVo().getU_email(), NanumGothicFont);
		insertDataInTable(profile_table, "  ", "  ", NanumGothicFont);
		if(Militarylist.size() == 0){
			insertDataInTable(profile_table, "병역사항", "미필", NanumGothicFont);
		}else if(Militarylist.get(Militarylist.size()-1).getP_title() != null) {
			insertDataInTable(profile_table, "병역사항", "필", NanumGothicFont);
		}else
			insertDataInTable(profile_table, "병역사항", "미필", NanumGothicFont);
		insertDataInTable(profile_table, "  ", "  ", NanumGothicFont);

		profile_table.setSpacingAfter(50f);
		document.add(profile_table);
	}

	private void fillOut_EduList(Document document, List<Edu_pofol_Impl_Vo> edList, BaseFont font, BaseFont font2)
			throws DocumentException, IOException {

		Font NanumGothicFont = new Font(font, 9);

		Font NanumGothicBoldFont = new Font(font2, 9);

		Paragraph education_history = new Paragraph("학력사항", NanumGothicBoldFont);
		education_history.setSpacingAfter(10);

		// draw line

		PdfPTable line_table = new PdfPTable(1);
		line_table.setTotalWidth(540f);
		line_table.setWidthPercentage(100f);
		line_table.setLockedWidth(true);
		PdfPCell line = new PdfPCell(education_history);
		line.setBorder(PdfPCell.BOTTOM);

		// line.setBorderWidth(1);
		line_table.addCell(line);
		document.add(line_table);

		float[] education_table_widths = { 1f };
		PdfPTable education_table = new PdfPTable(education_table_widths);
		education_table.setTotalWidth(540f);
		education_table.setWidthPercentage(100f);
		education_table.setLockedWidth(true);
		education_table.setSpacingBefore(10);

		String education_total_date1 = "         " + " " + "         " + " " + "    ";
		String education_total_title1 = "         " + " " + "         " + " " + "    ";

		for (int i = 0; i < 2; i++) {
			insertDataInTable(education_table, education_total_date1, NanumGothicFont);
			insertDataInTable(education_table, education_total_title1, NanumGothicFont);
			insertDataInTable(education_table, " ", NanumGothicFont);
			insertDataInTable(education_table, " ", NanumGothicFont);

		}

		education_table.setSpacingAfter(10f);
		document.add(education_table);

	}

	private void fillOut_EduList(Document document, List<Edu_pofol_Impl_Vo> edList, int first, BaseFont font,
			BaseFont font2) throws DocumentException, IOException {

		Font NanumGothicFont = new Font(font, 9);

		Font NanumGothicBoldFont = new Font(font2, 9);

		Paragraph education_history = new Paragraph("학력사항", NanumGothicBoldFont);
		education_history.setSpacingAfter(10);

		// draw line

		PdfPTable line_table = new PdfPTable(1);
		line_table.setTotalWidth(540f);
		line_table.setWidthPercentage(100f);
		line_table.setLockedWidth(true);
		PdfPCell line = new PdfPCell(education_history);
		line.setBorder(PdfPCell.BOTTOM);

		// line.setBorderWidth(1);
		line_table.addCell(line);
		document.add(line_table);

		float[] education_table_widths = { 1f };
		PdfPTable education_table = new PdfPTable(education_table_widths);
		education_table.setTotalWidth(540f);
		education_table.setWidthPercentage(100f);
		education_table.setLockedWidth(true);
		education_table.setSpacingBefore(10);

		String education_total_date1 = "         " + " " + "         " + " " + "    ";
		String education_total_title1 = "         " + " " + "         " + " " + "    ";

		if (this.getEduList().get(first).getP_title() != null || this.getEduList().get(first).getP_title() != "") {
			education_total_date1 = this.getEduList().get(first).getP_startDate() + " ~ "
					+ this.getEduList().get(first).getP_endDate() + " (기간)";
			education_total_title1 = this.getEduList().get(first).getP_title() + " "
					+ this.getEduList().get(first).getP_major() + " "
					+ this.getEduList().get(first).getP_completeType();
		}

		String education_total_date2 = "         " + " " + "         " + " " + "    ";
		String education_total_title2 = "         " + " " + "         " + " " + "    ";

		insertDataInTable(education_table, education_total_date1, NanumGothicFont);
		insertDataInTable(education_table, education_total_title1, NanumGothicFont);
		insertDataInTable(education_table, " ", NanumGothicFont);
		insertDataInTable(education_table, " ", NanumGothicFont);
		insertDataInTable(education_table, education_total_date2, NanumGothicFont);
		insertDataInTable(education_table, education_total_title2, NanumGothicFont);

		education_table.setSpacingAfter(30f);
		document.add(education_table);

	}

	private void fillOut_EduList(Document document, List<Edu_pofol_Impl_Vo> edList, int first, int second,
			BaseFont font, BaseFont font2) throws DocumentException, IOException {

		Font NanumGothicFont = new Font(font, 9);

		Font NanumGothicBoldFont = new Font(font2, 9);

		Paragraph education_history = new Paragraph("학력사항", NanumGothicBoldFont);

		// draw line

		PdfPTable line_table = new PdfPTable(1);
		line_table.setTotalWidth(540f);
		line_table.setWidthPercentage(100f);
		line_table.setLockedWidth(true);
		PdfPCell line = new PdfPCell(education_history);
		line.setBorder(PdfPCell.BOTTOM);

		// line.setBorderWidth(1);
		line_table.addCell(line);
		document.add(line_table);

		float[] education_table_widths = { 1f };
		PdfPTable education_table = new PdfPTable(education_table_widths);
		education_table.setTotalWidth(540f);
		education_table.setWidthPercentage(100f);
		education_table.setLockedWidth(true);
		education_table.setSpacingBefore(10);

		String education_total_date1 = "         " + " " + "         " + " " + "    ";
		String education_total_title1 = "         " + " " + "         " + " " + "    ";

		if (this.getEduList().get(first).getP_title() != null || this.getEduList().get(first).getP_title() != "") {
			education_total_date1 = this.getEduList().get(first).getP_startDate() + " ~ "
					+ this.getEduList().get(first).getP_endDate() + " (기간)";
			education_total_title1 = this.getEduList().get(first).getP_title() + " "
					+ this.getEduList().get(first).getP_major() + " " + this.getEduList().get(first).getP_completeType();
		}

		String education_total_date2 = "         " + " " + "         " + " " + "    ";
		String education_total_title2 = "         " + " " + "         " + " " + "    ";

		if (this.getEduList().get(second).getP_title() != null || this.getEduList().get(second).getP_title() != "") {
			education_total_date2 = this.getEduList().get(second).getP_startDate() + " ~ "
					+ this.getEduList().get(second).getP_endDate() + " (기간)";
			education_total_title2 = this.getEduList().get(second).getP_title() + " "
					+ this.getEduList().get(second).getP_major() + " " + this.getEduList().get(second).getP_completeType();
		}

		insertDataInTable(education_table, education_total_date1, NanumGothicFont);
		insertDataInTable(education_table, education_total_title1, NanumGothicFont);
		insertDataInTable(education_table, " ", NanumGothicFont);
		insertDataInTable(education_table, " ", NanumGothicFont);
		insertDataInTable(education_table, education_total_date2, NanumGothicFont);
		insertDataInTable(education_table, education_total_title2, NanumGothicFont);

		education_table.setSpacingAfter(30f);
		document.add(education_table);

	}

	private void fillOut_MainActivityList(Document document, List<MainAct_pofol_Impl_Vo> list, BaseFont font,
			BaseFont font2) throws DocumentException, IOException {

		Font NanumGothicFont = new Font(font, 9);

		Font NanumGothicBoldFont = new Font(font2, 9);

		Paragraph main_activity = new Paragraph("주요활동", NanumGothicBoldFont);
		main_activity.setSpacingBefore(10);
		main_activity.setSpacingAfter(5);
		document.add(main_activity);

		// draw line
		LineSeparator sep = new LineSeparator();
		sep.setLineWidth(2);
		document.add(sep);

		// activity_table
		float[] activity_table_widths = { 0.14f, 0.85f };
		PdfPTable activity_table = new PdfPTable(activity_table_widths);
		activity_table.setTotalWidth(540f);
		activity_table.setWidthPercentage(100f);
		activity_table.setLockedWidth(true);
		activity_table.setSpacingBefore(10);

		String activity_total_date_value2 = "         " + " " + "         " + " " + "    ";
		String activity_place_value2 = "                 ";
		String activity_title_value2 = "                    ";
		String activity_act_content_value2 = "\n\n\n\n";

		for (int i = 0; i < 4; i++) {
			insertDataInTable(activity_table, "기간", activity_total_date_value2, NanumGothicFont);
			insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
			insertDataInTable(activity_table, "장소", activity_place_value2, NanumGothicFont);
			insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
			insertDataInTable(activity_table, "활동내용", activity_title_value2, NanumGothicFont);
			insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
			insertDataInTable(activity_table, "세부내용", activity_act_content_value2, NanumGothicFont);
			
			
			insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
			insertLineInTable(activity_table);
			insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
			insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		}
		activity_table.setSpacingAfter(10f);
		document.add(activity_table);

	}

	private void fillOut_MainActivityList(Document document, List<MainAct_pofol_Impl_Vo> list, int first, BaseFont font,
			BaseFont font2) throws DocumentException, IOException {

		Font NanumGothicFont = new Font(font, 9);

		Font NanumGothicBoldFont = new Font(font2, 9);

		Paragraph main_activity = new Paragraph("주요활동", NanumGothicBoldFont);
		main_activity.setSpacingBefore(10);
		main_activity.setSpacingAfter(5);
		document.add(main_activity);

		// draw line
		LineSeparator sep = new LineSeparator();
		sep.setLineWidth(2);
		document.add(sep);

		// activity_table
		float[] activity_table_widths = { 0.14f, 0.85f };
		PdfPTable activity_table = new PdfPTable(activity_table_widths);
		activity_table.setTotalWidth(540f);
		activity_table.setWidthPercentage(100f);
		activity_table.setLockedWidth(true);
		activity_table.setSpacingBefore(10);

		String activity_total_date_value1 = "         " + " " + "         " + " " + "    ";
		String activity_place_value1 = "                 ";
		String activity_title_value1 = "                    ";
		String activity_act_content_value1 = "\n\n\n\n";


		if (this.getMainActList().get(first).getP_title() != null
				|| this.getMainActList().get(first).getP_title() != "") {
			activity_total_date_value1 = this.getMainActList().get(first).getP_startDate() + " ~ "
					+ this.getMainActList().get(first).getP_endDate() + " (기간)";
			activity_place_value1 = this.getMainActList().get(first).getP_organizer();
			activity_title_value1 = this.getMainActList().get(first).getP_title();			
			activity_act_content_value1 = this.getMainActList().get(first).getP_actcontent() ;
		}

		
		if(this.getMainActList().get(first).getP_actcontent().length() < 93)
			activity_act_content_value1 += "\n\n\n\n";
		else if(this.getMainActList().get(first).getP_actcontent().length() < 186)
			activity_act_content_value1 += "\n\n\n";
		else if(this.getMainActList().get(first).getP_actcontent().length() < 279)
			activity_act_content_value1 += "\n\n";
		else if(this.getMainActList().get(first).getP_actcontent().length() < 372)
			activity_act_content_value1 += "\n";


		insertDataInTable(activity_table, "기간", activity_total_date_value1, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "장소", activity_place_value1, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "활동내용", activity_title_value1, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "세부내용", activity_act_content_value1, NanumGothicFont);

		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);				
		insertLineInTable(activity_table);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		
		
		String activity_total_date_value2 = "         " + " " + "         " + " " + "    ";
		String activity_place_value2 = "                 ";
		String activity_title_value2 = "                    ";
		String activity_act_content_value2 = "\n\n\n\n";

		for (int i = 0; i < 3; i++) {
			insertDataInTable(activity_table, "기간", activity_total_date_value2, NanumGothicFont);
			insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
			insertDataInTable(activity_table, "장소", activity_place_value2, NanumGothicFont);
			insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
			insertDataInTable(activity_table, "활동내용", activity_title_value2, NanumGothicFont);
			insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
			insertDataInTable(activity_table, "세부내용", activity_act_content_value2, NanumGothicFont);

			insertDataInTable(activity_table, "           ", "          ", NanumGothicFont);
			insertDataInTable(activity_table, "           ", "          ", NanumGothicFont);
			insertLineInTable(activity_table);
			insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
			
		}
		activity_table.setSpacingAfter(10f);
		document.add(activity_table);

	}

	private void fillOut_MainActivityList(Document document, List<MainAct_pofol_Impl_Vo> list, int first, int second,
		BaseFont font, BaseFont font2) throws DocumentException, IOException {

		Font NanumGothicFont = new Font(font, 9);
		Font NanumGothicBoldFont = new Font(font2, 9);

		Paragraph main_activity = new Paragraph("주요활동", NanumGothicBoldFont);
		main_activity.setSpacingBefore(10);
		main_activity.setSpacingAfter(5);
		document.add(main_activity);

		// draw line
		LineSeparator sep = new LineSeparator();
		sep.setLineWidth(2);
		document.add(sep);

		// activity_table
		float[] activity_table_widths = { 0.14f, 0.85f };
		PdfPTable activity_table = new PdfPTable(activity_table_widths);
		activity_table.setTotalWidth(540f);
		activity_table.setWidthPercentage(100f);
		activity_table.setLockedWidth(true);
		activity_table.setSpacingBefore(10);

		String activity_total_date_value1 = "         " + " " + "         " + " " + "    ";
		String activity_place_value1 = "                 ";
		String activity_title_value1 = "                    ";
		String activity_act_content_value1 = "\n\n\n\n";
						
		if (this.getMainActList().get(first).getP_title() != null
				|| this.getMainActList().get(first).getP_title() != "") {
			activity_total_date_value1 = this.getMainActList().get(first).getP_startDate() + " ~ "
					+ this.getMainActList().get(first).getP_endDate() + " (기간)";
			activity_place_value1 = this.getMainActList().get(first).getP_organizer();
			activity_title_value1 = this.getMainActList().get(first).getP_title();
			activity_act_content_value1 = this.getMainActList().get(first).getP_actcontent();
		}

		if(this.getMainActList().get(first).getP_actcontent().length() < 93)
			activity_act_content_value1 += "\n\n\n\n";
		else if(this.getMainActList().get(first).getP_actcontent().length() < 186)
			activity_act_content_value1 += "\n\n\n";
		else if(this.getMainActList().get(first).getP_actcontent().length() < 279)
			activity_act_content_value1 += "\n\n";
		else if(this.getMainActList().get(first).getP_actcontent().length() < 372)
			activity_act_content_value1 += "\n";
				
		
		
		String activity_total_date_value2 = "         " + " " + "         " + " " + "    ";
		String activity_place_value2 = "                 ";
		String activity_title_value2 = "                    ";
		String activity_act_content_value2 = "\n\n\n\n";
		
		
		if (this.getMainActList().get(second).getP_title() != null
				|| this.getMainActList().get(second).getP_title() != "") {
			activity_total_date_value2 = this.getMainActList().get(second).getP_startDate() + " ~ "
					+ this.getMainActList().get(second).getP_endDate() + " (기간)";
			activity_place_value2 = this.getMainActList().get(second).getP_organizer();
			activity_title_value2 = this.getMainActList().get(second).getP_title();
			activity_act_content_value2 = this.getMainActList().get(second).getP_actcontent();
		}
		
		if(this.getMainActList().get(second).getP_actcontent().length() < 93)
			activity_act_content_value2 += "\n\n\n\n";
		else if(this.getMainActList().get(second).getP_actcontent().length() < 186)
			activity_act_content_value2 += "\n\n\n";
		else if(this.getMainActList().get(second).getP_actcontent().length() < 279)
			activity_act_content_value2 += "\n\n";
		else if(this.getMainActList().get(second).getP_actcontent().length() < 372)
			activity_act_content_value2 += "\n";
				
		
		String activity_total_date_value3 = "         " + " " + "         " + " " + "    ";
		String activity_place_value3 = "                 ";
		String activity_title_value3 = "                    ";
		String activity_act_content_value3 = "\n\n\n\n";


		insertDataInTable(activity_table, "기간", activity_total_date_value1, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "장소", activity_place_value1, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "활동내용", activity_title_value1, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "세부내용", activity_act_content_value1, NanumGothicFont);

		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertLineInTable(activity_table);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);

		insertDataInTable(activity_table, "기간", activity_total_date_value2, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "장소", activity_place_value2, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "활동내용", activity_title_value2, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "세부내용", activity_act_content_value2, NanumGothicFont);
		
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertLineInTable(activity_table);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);

		for (int i = 0; i < 2; i++) {			
			insertDataInTable(activity_table, "기간", activity_total_date_value3, NanumGothicFont);
			insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
			insertDataInTable(activity_table, "장소", activity_place_value3, NanumGothicFont);
			insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
			insertDataInTable(activity_table, "활동내용", activity_title_value3, NanumGothicFont);
			insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
			insertDataInTable(activity_table, "세부내용", activity_act_content_value3, NanumGothicFont);
			
			insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
			insertDataInTable(activity_table, "           ", "          ", NanumGothicFont);
			insertLineInTable(activity_table);
			insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
			insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);

		}

		activity_table.setSpacingAfter(10f);
		document.add(activity_table);

	}

	private void fillOut_MainActivityList(Document document, List<MainAct_pofol_Impl_Vo> list, int first, int second,
			int third, BaseFont font, BaseFont font2) throws DocumentException, IOException {

		Font NanumGothicFont = new Font(font, 9);
		Font NanumGothicBoldFont = new Font(font2, 9);

		Paragraph main_activity = new Paragraph("주요활동", NanumGothicBoldFont);
		main_activity.setSpacingBefore(10);
		main_activity.setSpacingAfter(5);
		document.add(main_activity);

		// draw line
		LineSeparator sep = new LineSeparator();
		sep.setLineWidth(2);
		document.add(sep);

		// activity_table
		float[] activity_table_widths = { 0.14f, 0.85f };
		PdfPTable activity_table = new PdfPTable(activity_table_widths);
		activity_table.setTotalWidth(540f);
		activity_table.setWidthPercentage(100f);
		activity_table.setLockedWidth(true);
		activity_table.setSpacingBefore(10);

		String activity_total_date_value1 = "         " + " " + "         " + " " + "    ";
		String activity_place_value1 = "                 ";
		String activity_title_value1 = "                    ";
		String activity_act_content_value1 = "\n\n\n\n";

		if (this.getMainActList().get(first).getP_title() != null
				|| this.getMainActList().get(first).getP_title() != "") {
			activity_total_date_value1 = this.getMainActList().get(first).getP_startDate() + " ~ "
					+ this.getMainActList().get(first).getP_endDate() + " (기간)";
			activity_place_value1 = this.getMainActList().get(first).getP_organizer();
			activity_title_value1 = this.getMainActList().get(first).getP_title();
			activity_act_content_value1 = this.getMainActList().get(first).getP_actcontent();
		}
		
		if(this.getMainActList().get(first).getP_actcontent().length() < 93)
			activity_act_content_value1 += "\n\n\n\n";
		else if(this.getMainActList().get(first).getP_actcontent().length() < 186)
			activity_act_content_value1 += "\n\n\n";
		else if(this.getMainActList().get(first).getP_actcontent().length() < 279)
			activity_act_content_value1 += "\n\n";
		else if(this.getMainActList().get(first).getP_actcontent().length() < 372)
			activity_act_content_value1 += "\n";


		String activity_total_date_value2 = "         " + " " + "         " + " " + "    ";
		String activity_place_value2 = "                 ";
		String activity_title_value2 = "                    ";
		String activity_act_content_value2 = "\n\n\n\n";

		if (this.getMainActList().get(second).getP_title() != null
				|| this.getMainActList().get(second).getP_title() != "") {
			activity_total_date_value2 = this.getMainActList().get(second).getP_startDate() + " ~ "
					+ this.getMainActList().get(second).getP_endDate() + " (기간)";
			activity_place_value2 = this.getMainActList().get(second).getP_organizer();
			activity_title_value2 = this.getMainActList().get(second).getP_title();
			activity_act_content_value2 = this.getMainActList().get(second).getP_actcontent();
		}
		
		if(this.getMainActList().get(second).getP_actcontent().length() < 93)
			activity_act_content_value2 += "\n\n\n\n";
		else if(this.getMainActList().get(second).getP_actcontent().length() < 186)
			activity_act_content_value2 += "\n\n\n";
		else if(this.getMainActList().get(second).getP_actcontent().length() < 279)
			activity_act_content_value2 += "\n\n";
		else if(this.getMainActList().get(second).getP_actcontent().length() < 372)
			activity_act_content_value2 += "\n";
		

		String activity_total_date_value3 = "         " + " " + "         " + " " + "    ";
		String activity_place_value3 = "                 ";
		String activity_title_value3 = "                    ";
		String activity_act_content_value3 = "\n\n\n\n";

		if (this.getMainActList().get(third).getP_title() != null
				|| this.getMainActList().get(third).getP_title() != "") {
			activity_total_date_value3 = this.getMainActList().get(third).getP_startDate() + " ~ "
					+ this.getMainActList().get(third).getP_endDate() + " (기간)";
			activity_place_value3 = this.getMainActList().get(third).getP_organizer();
			activity_title_value3 = this.getMainActList().get(third).getP_title();
			activity_act_content_value3 = this.getMainActList().get(third).getP_actcontent();
		}
		
		if(this.getMainActList().get(third).getP_actcontent().length() < 93)
			activity_act_content_value3 += "\n\n\n\n";
		else if(this.getMainActList().get(third).getP_actcontent().length() < 186)
			activity_act_content_value3 += "\n\n\n";
		else if(this.getMainActList().get(third).getP_actcontent().length() < 279)
			activity_act_content_value3 += "\n\n";
		else if(this.getMainActList().get(third).getP_actcontent().length() < 372)
			activity_act_content_value3 += "\n";
		
		

		String activity_total_date_value4 = "         " + " " + "         " + " " + "    ";
		String activity_place_value4 = "                 ";
		String activity_title_value4 = "                    ";
		String activity_act_content_value4 = "\n\n\n\n";

		insertDataInTable(activity_table, "기간", activity_total_date_value1, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "장소", activity_place_value1, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "활동내용", activity_title_value1, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "세부내용", activity_act_content_value1, NanumGothicFont);


		insertDataInTable(activity_table, "           ", "          ", NanumGothicFont);
		insertLineInTable(activity_table);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);

		insertDataInTable(activity_table, "기간", activity_total_date_value2, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "장소", activity_place_value2, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "활동내용", activity_title_value2, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "세부내용", activity_act_content_value2, NanumGothicFont);


		insertDataInTable(activity_table, "           ", "          ", NanumGothicFont);
		insertLineInTable(activity_table);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);

		insertDataInTable(activity_table, "기간", activity_total_date_value3, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "장소", activity_place_value3, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "활동내용", activity_title_value3, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "세부내용", activity_act_content_value3, NanumGothicFont);


		insertDataInTable(activity_table, "           ", "          ", NanumGothicFont);
		insertLineInTable(activity_table);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);

		insertDataInTable(activity_table, "기간", activity_total_date_value4, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "장소", activity_place_value4, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "활동내용", activity_title_value4, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "세부내용", activity_act_content_value4, NanumGothicFont);
		
		insertDataInTable(activity_table, "           ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "           ", "          ", NanumGothicFont);
		insertLineInTable(activity_table);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);

		activity_table.setSpacingAfter(10f);
		document.add(activity_table);

	}

	private void fillOut_MainActivityList(Document document, List<MainAct_pofol_Impl_Vo> list, int first, int second,
			int third, int fourth, BaseFont font, BaseFont font2) throws DocumentException, IOException {

		Font NanumGothicFont = new Font(font, 9);
		Font NanumGothicBoldFont = new Font(font2, 9);

		Paragraph main_activity = new Paragraph("주요활동", NanumGothicBoldFont);
		main_activity.setSpacingBefore(10);
		main_activity.setSpacingAfter(5);
		document.add(main_activity);

		// draw line
		LineSeparator sep = new LineSeparator();
		sep.setLineWidth(2);
		document.add(sep);

		// activity_table
		float[] activity_table_widths = { 0.14f, 0.85f };
		PdfPTable activity_table = new PdfPTable(activity_table_widths);
		activity_table.setTotalWidth(540f);
		activity_table.setWidthPercentage(100f);
		activity_table.setLockedWidth(true);
		activity_table.setSpacingBefore(10);

		String activity_total_date_value1 = "         " + " " + "         " + " " + "    ";
		String activity_place_value1 = "                 ";
		String activity_title_value1 = "                    ";
		String activity_act_content_value1 = "\n \n \n\n ";

		if (this.getMainActList().get(first).getP_title() != null
				|| this.getMainActList().get(first).getP_title() != "") {
			activity_total_date_value1 = this.getMainActList().get(first).getP_startDate() + " ~ "
					+ this.getMainActList().get(first).getP_endDate() + " (기간)";
			activity_place_value1 = this.getMainActList().get(first).getP_organizer();
			activity_title_value1 = this.getMainActList().get(first).getP_title();
			activity_act_content_value1 = this.getMainActList().get(first).getP_actcontent();
		}
		
		if(this.getMainActList().get(first).getP_actcontent().length() < 93)
			activity_act_content_value1 += "\n\n\n\n";
		else if(this.getMainActList().get(first).getP_actcontent().length() < 186)
			activity_act_content_value1 += "\n\n\n";
		else if(this.getMainActList().get(first).getP_actcontent().length() < 279)
			activity_act_content_value1 += "\n\n";
		else if(this.getMainActList().get(first).getP_actcontent().length() < 372)
			activity_act_content_value1 += "\n";
		

		String activity_total_date_value2 = "         " + " " + "         " + " " + "    ";
		String activity_place_value2 = "                 ";
		String activity_title_value2 = "                    ";
		String activity_act_content_value2 = "\n \n \n\n ";

		if (this.getMainActList().get(second).getP_title() != null
				|| this.getMainActList().get(second).getP_title() != "") {
			activity_total_date_value2 = this.getMainActList().get(second).getP_startDate() + " ~ "
					+ this.getMainActList().get(second).getP_endDate() + " (기간)";
			activity_place_value2 = this.getMainActList().get(second).getP_organizer();
			activity_title_value2 = this.getMainActList().get(second).getP_title();
			activity_act_content_value2 = this.getMainActList().get(second).getP_actcontent();
		}
		
		if(this.getMainActList().get(second).getP_actcontent().length() < 93)
			activity_act_content_value2 += "\n\n\n\n";
		else if(this.getMainActList().get(second).getP_actcontent().length() < 186)
			activity_act_content_value2 += "\n\n\n";
		else if(this.getMainActList().get(second).getP_actcontent().length() < 279)
			activity_act_content_value2 += "\n\n";
		else if(this.getMainActList().get(second).getP_actcontent().length() < 372)
			activity_act_content_value2 += "\n";
		

		String activity_total_date_value3 = "         " + " " + "         " + " " + "    ";
		String activity_place_value3 = "                 ";
		String activity_title_value3 = "                    ";
		String activity_act_content_value3 = "\n \n \n \n";

		if (this.getMainActList().get(third).getP_title() != null
				|| this.getMainActList().get(third).getP_title() != "") {
			activity_total_date_value3 = this.getMainActList().get(third).getP_startDate() + " ~ "
					+ this.getMainActList().get(third).getP_endDate() + " (기간)";
			activity_place_value3 = this.getMainActList().get(third).getP_organizer();
			activity_title_value3 = this.getMainActList().get(third).getP_title();
			activity_act_content_value3 = this.getMainActList().get(third).getP_actcontent();
		}
		
		if(this.getMainActList().get(third).getP_actcontent().length() < 93)
			activity_act_content_value3 += "\n\n\n\n";
		else if(this.getMainActList().get(third).getP_actcontent().length() < 186)
			activity_act_content_value3 += "\n\n\n";
		else if(this.getMainActList().get(third).getP_actcontent().length() < 279)
			activity_act_content_value3 += "\n\n";
		else if(this.getMainActList().get(third).getP_actcontent().length() < 372)
			activity_act_content_value3 += "\n";
		

		String activity_total_date_value4 = "         " + " " + "         " + " " + "    ";
		String activity_place_value4 = "                 ";
		String activity_title_value4 = "                    ";
		String activity_act_content_value4 = "\n\n\n\n";

		if (this.getMainActList().get(fourth).getP_title() != null
				|| this.getMainActList().get(fourth).getP_title() != "") {
			activity_total_date_value4 = this.getMainActList().get(fourth).getP_startDate() + " ~ "
					+ this.getMainActList().get(fourth).getP_endDate() + " (기간)";
			activity_place_value4 = this.getMainActList().get(fourth).getP_organizer();
			activity_title_value4 = this.getMainActList().get(fourth).getP_title();
			activity_act_content_value4 = this.getMainActList().get(fourth).getP_actcontent();
		}
		
		if(this.getMainActList().get(fourth).getP_actcontent().length() < 93)
			activity_act_content_value4 += "\n\n\n\n";
		else if(this.getMainActList().get(fourth).getP_actcontent().length() < 186)
			activity_act_content_value4 += "\n\n\n";
		else if(this.getMainActList().get(fourth).getP_actcontent().length() < 279)
			activity_act_content_value4 += "\n\n";
		else if(this.getMainActList().get(fourth).getP_actcontent().length() < 372)
			activity_act_content_value4 += "\n";
		
		
		insertDataInTable(activity_table, "기간", activity_total_date_value1, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "장소", activity_place_value1, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "활동내용", activity_title_value1, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "세부내용", activity_act_content_value1, NanumGothicFont);


		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertLineInTable(activity_table);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);

		insertDataInTable(activity_table, "기간", activity_total_date_value2, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "장소", activity_place_value2, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "활동내용", activity_title_value2, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "세부내용", activity_act_content_value2, NanumGothicFont);

		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertLineInTable(activity_table);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);

		insertDataInTable(activity_table, "기간", activity_total_date_value3, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "장소", activity_place_value3, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "활동내용", activity_title_value3, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "세부내용", activity_act_content_value3, NanumGothicFont);


		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertLineInTable(activity_table);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);

		insertDataInTable(activity_table, "기간", activity_total_date_value4, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "장소", activity_place_value4, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "활동내용", activity_title_value4, NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "세부내용", activity_act_content_value4, NanumGothicFont);
		
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertLineInTable(activity_table);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		insertDataInTable(activity_table, "            ", "          ", NanumGothicFont);
		
		activity_table.setSpacingAfter(10f);
		document.add(activity_table);

	}

	private void fillOut_AwardsList(Document document, List<Award_pofol_Impl_Vo> awardList, BaseFont font,
			BaseFont font2) throws DocumentException, IOException {

		Font NanumGothicFont = new Font(font, 9);

		Font NanumGothicBoldFont = new Font(font2, 9);

		// awards content
		Paragraph awards_content = new Paragraph("수상내용", NanumGothicBoldFont);
		awards_content.setSpacingBefore(10);
		awards_content.setSpacingAfter(5);
		document.add(awards_content);

		// draw line
		LineSeparator sep = new LineSeparator();
		sep.setLineWidth(2);
		document.add(sep);

		// awards_table
		float[] awards_table_widths = { 0.33f, 0.33f, 0.33f };
		PdfPTable awards_table = new PdfPTable(awards_table_widths);
		awards_table.setTotalWidth(540f);
		awards_table.setWidthPercentage(100f);
		awards_table.setLockedWidth(true);
		awards_table.setSpacingBefore(10);

		String awardDate_value1 = "          ";
		String awardTitle_value1 = "             ";
		String awardDetail_value1 = "                        ";

		for (int i = 0; i < 2; i++) {
			insertDataInTable(awards_table, awardDate_value1, NanumGothicFont);
			insertDataInTable(awards_table, awardTitle_value1, NanumGothicFont);
			insertDataInTable(awards_table, awardDetail_value1, NanumGothicFont);
			insertDataInTable(awards_table, "     ", "      ", NanumGothicFont);
			insertDataInTable(awards_table, "     ", NanumGothicFont);
		}

		awards_table.setSpacingAfter(15f);
		document.add(awards_table);

	}

	private void fillOut_AwardsList(Document document, List<Award_pofol_Impl_Vo> awardList, int first, BaseFont font,
			BaseFont font2) throws DocumentException, IOException {

		Font NanumGothicFont = new Font(font, 9);

		Font NanumGothicBoldFont = new Font(font2, 9);

		// awards content
		Paragraph awards_content = new Paragraph("수상내용", NanumGothicBoldFont);
		awards_content.setSpacingBefore(10);
		awards_content.setSpacingAfter(5);
		document.add(awards_content);

		// draw line
		LineSeparator sep = new LineSeparator();
		sep.setLineWidth(2);
		document.add(sep);

		// awards_table
		float[] awards_table_widths = { 0.33f, 0.33f, 0.33f };
		PdfPTable awards_table = new PdfPTable(awards_table_widths);
		awards_table.setTotalWidth(540f);
		awards_table.setWidthPercentage(100f);
		awards_table.setLockedWidth(true);
		awards_table.setSpacingBefore(10);

		String awardDate_value1 = "          ";
		String awardTitle_value1 = "             ";
		String awardDetail_value1 = "                        ";

		if (this.getAwardList().get(first).getP_title() != null || this.getAwardList().get(first).getP_title() != "") {
			awardDate_value1 = this.getAwardList().get(first).getP_startDate();
			awardTitle_value1 = this.getAwardList().get(first).getP_title();
			awardDetail_value1 = this.getAwardList().get(first).getP_organizer();
		}
		insertDataInTable(awards_table, awardDate_value1, NanumGothicFont);
		insertDataInTable(awards_table, awardTitle_value1, NanumGothicFont);
		insertDataInTable(awards_table, awardDetail_value1, NanumGothicFont);
		insertDataInTable(awards_table, "     ", "      ", NanumGothicFont);
		insertDataInTable(awards_table, "     ", NanumGothicFont);

		String awardDate_value2 = "          ";
		String awardTitle_value2 = "             ";
		String awardDetail_value2 = "                        ";

		insertDataInTable(awards_table, awardDate_value2, NanumGothicFont);
		insertDataInTable(awards_table, awardTitle_value2, NanumGothicFont);
		insertDataInTable(awards_table, awardDetail_value2, NanumGothicFont);
		insertDataInTable(awards_table, "     ", "      ", NanumGothicFont);
		insertDataInTable(awards_table, "     ", NanumGothicFont);

		awards_table.setSpacingAfter(15f);
		document.add(awards_table);

	}

	private void fillOut_AwardsList(Document document, List<Award_pofol_Impl_Vo> awardList, int first, int second,
			BaseFont font, BaseFont font2) throws DocumentException, IOException {

		Font NanumGothicFont = new Font(font, 9);

		Font NanumGothicBoldFont = new Font(font2, 9);

		// awards content
		Paragraph awards_content = new Paragraph("수상내용", NanumGothicBoldFont);
		awards_content.setSpacingBefore(10);
		awards_content.setSpacingAfter(5);
		document.add(awards_content);

		// draw line
		LineSeparator sep = new LineSeparator();
		sep.setLineWidth(2);
		document.add(sep);

		// awards_table
		float[] awards_table_widths = { 0.33f, 0.33f, 0.33f };
		PdfPTable awards_table = new PdfPTable(awards_table_widths);
		awards_table.setTotalWidth(540f);
		awards_table.setWidthPercentage(100f);
		awards_table.setLockedWidth(true);
		awards_table.setSpacingBefore(10);

		String awardDate_value1 = "          ";
		String awardTitle_value1 = "             ";
		String awardDetail_value1 = "                        ";

		if (this.getAwardList().get(first).getP_title() != null || this.getAwardList().get(first).getP_title() != "") {
			awardDate_value1 = this.getAwardList().get(first).getP_startDate();
			awardTitle_value1 = this.getAwardList().get(first).getP_title();
			awardDetail_value1 = this.getAwardList().get(first).getP_organizer();
		}
		insertDataInTable(awards_table, awardDate_value1, NanumGothicFont);
		insertDataInTable(awards_table, awardTitle_value1, NanumGothicFont);
		insertDataInTable(awards_table, awardDetail_value1, NanumGothicFont);
		insertDataInTable(awards_table, "     ", "      ", NanumGothicFont);
		insertDataInTable(awards_table, "     ", NanumGothicFont);

		String awardDate_value2 = "          ";
		String awardTitle_value2 = "             ";
		String awardDetail_value2 = "                        ";

		if (this.getAwardList().get(second).getP_title() != null
				|| this.getAwardList().get(second).getP_title() != "") {
			awardDate_value2 = this.getAwardList().get(second).getP_startDate();
			awardTitle_value2 = this.getAwardList().get(second).getP_title();
			awardDetail_value2 = this.getAwardList().get(second).getP_organizer();
		}

		insertDataInTable(awards_table, awardDate_value2, NanumGothicFont);
		insertDataInTable(awards_table, awardTitle_value2, NanumGothicFont);
		insertDataInTable(awards_table, awardDetail_value2, NanumGothicFont);
		insertDataInTable(awards_table, "     ", "      ", NanumGothicFont);
		insertDataInTable(awards_table, "     ", NanumGothicFont);

		awards_table.setSpacingAfter(15f);
		document.add(awards_table);

	}

	private void fillOut_QualifiList(Document document, List<Qualifi_pofol_Impl_Vo> qualifiList, BaseFont font,
			BaseFont font2) throws DocumentException, IOException {

		Font NanumGothicFont = new Font(font, 9);
		Font NanumGothicBoldFont = new Font(font2, 9);

		// certificate content
		Paragraph certificate_content = new Paragraph("자격사항", NanumGothicBoldFont);
		certificate_content.setSpacingBefore(10);
		certificate_content.setSpacingAfter(5);
		document.add(certificate_content);

		// draw line
		LineSeparator sep = new LineSeparator();
		sep.setLineWidth(2);
		document.add(sep);

		// certificate_table
		float[] certificate_table_widths = { 0.33f, 0.33f, 0.33f };
		PdfPTable certificate_table = new PdfPTable(certificate_table_widths);
		certificate_table.setTotalWidth(540f);
		certificate_table.setWidthPercentage(100f);
		certificate_table.setLockedWidth(true);
		certificate_table.setSpacingBefore(10);

		for (int i = 0; i < 2; i++) {
			String certificateDate_value1 = "          ";
			String certificateTitle_value1 = "             ";
			String certificateDetail_vlaue1 = "                        ";

			insertDataInTable(certificate_table, certificateDate_value1, NanumGothicFont);
			insertDataInTable(certificate_table, certificateTitle_value1, NanumGothicFont);
			insertDataInTable(certificate_table, certificateDetail_vlaue1, NanumGothicFont);
			insertDataInTable(certificate_table, "     ", "      ", NanumGothicFont);
			insertDataInTable(certificate_table, "     ", NanumGothicFont);
		}

		certificate_table.setSpacingAfter(15f);
		document.add(certificate_table);

	}

	private void fillOut_QualifiList(Document document, List<Qualifi_pofol_Impl_Vo> qualifiList, int first,
			BaseFont font, BaseFont font2) throws DocumentException, IOException {

		Font NanumGothicFont = new Font(font, 9);
		Font NanumGothicBoldFont = new Font(font2, 9);

		// certificate content
		Paragraph certificate_content = new Paragraph("자격사항", NanumGothicBoldFont);
		certificate_content.setSpacingBefore(10);
		certificate_content.setSpacingAfter(5);
		document.add(certificate_content);

		// draw line
		LineSeparator sep = new LineSeparator();
		sep.setLineWidth(2);
		document.add(sep);

		// certificate_table
		float[] certificate_table_widths = { 0.33f, 0.33f, 0.33f };
		PdfPTable certificate_table = new PdfPTable(certificate_table_widths);
		certificate_table.setTotalWidth(540f);
		certificate_table.setWidthPercentage(100f);
		certificate_table.setLockedWidth(true);
		certificate_table.setSpacingBefore(10);

		String certificateDate_value1 = "          ";
		String certificateTitle_value1 = "             ";
		String certificateDetail_vlaue1 = "                        ";

		if (this.getQualifiList().get(first).getP_title() != null
				|| this.getAwardList().get(first).getP_title() != "") {
			certificateDate_value1 = this.getQualifiList().get(first).getP_startDate();
			certificateTitle_value1 = this.getQualifiList().get(first).getP_title();
			certificateDetail_vlaue1 = this.getQualifiList().get(first).getP_organizer();

		}

		insertDataInTable(certificate_table, certificateDate_value1, NanumGothicFont);
		insertDataInTable(certificate_table, certificateTitle_value1, NanumGothicFont);
		insertDataInTable(certificate_table, certificateDetail_vlaue1, NanumGothicFont);
		insertDataInTable(certificate_table, "     ", "      ", NanumGothicFont);
		insertDataInTable(certificate_table, "     ", NanumGothicFont);

		String certificateDate_value2 = "          ";
		String certificateTitle_value2 = "             ";
		String certificateDetail_vlaue2 = "                        ";

		insertDataInTable(certificate_table, certificateDate_value2, NanumGothicFont);
		insertDataInTable(certificate_table, certificateTitle_value2, NanumGothicFont);
		insertDataInTable(certificate_table, certificateDetail_vlaue2, NanumGothicFont);
		insertDataInTable(certificate_table, "     ", "      ", NanumGothicFont);
		insertDataInTable(certificate_table, "     ", NanumGothicFont);

		certificate_table.setSpacingAfter(15f);
		document.add(certificate_table);

	}

	private void fillOut_QualifiList(Document document, List<Qualifi_pofol_Impl_Vo> qualifiList, int first, int second,
			BaseFont font, BaseFont font2) throws DocumentException, IOException {

		Font NanumGothicFont = new Font(font, 9);
		Font NanumGothicBoldFont = new Font(font2, 9);

		// certificate content
		Paragraph certificate_content = new Paragraph("자격사항", NanumGothicBoldFont);
		certificate_content.setSpacingBefore(10);
		certificate_content.setSpacingAfter(5);
		document.add(certificate_content);

		// draw line
		LineSeparator sep = new LineSeparator();
		sep.setLineWidth(2);
		document.add(sep);

		// certificate_table
		float[] certificate_table_widths = { 0.33f, 0.33f, 0.33f };
		PdfPTable certificate_table = new PdfPTable(certificate_table_widths);
		certificate_table.setTotalWidth(540f);
		certificate_table.setWidthPercentage(100f);
		certificate_table.setLockedWidth(true);
		certificate_table.setSpacingBefore(10);

		String certificateDate_value1 = "          ";
		String certificateTitle_value1 = "             ";
		String certificateDetail_vlaue1 = "                        ";

		if (this.getQualifiList().get(first).getP_title() != null
				|| this.getAwardList().get(first).getP_title() != "") {
			certificateDate_value1 = this.getQualifiList().get(first).getP_startDate();
			certificateTitle_value1 = this.getQualifiList().get(first).getP_title();
			certificateDetail_vlaue1 = this.getQualifiList().get(first).getP_organizer();

		}

		insertDataInTable(certificate_table, certificateDate_value1, NanumGothicFont);
		insertDataInTable(certificate_table, certificateTitle_value1, NanumGothicFont);
		insertDataInTable(certificate_table, certificateDetail_vlaue1, NanumGothicFont);
		insertDataInTable(certificate_table, "     ", "      ", NanumGothicFont);
		insertDataInTable(certificate_table, "     ", NanumGothicFont);

		String certificateDate_value2 = "          ";
		String certificateTitle_value2 = "             ";
		String certificateDetail_vlaue2 = "                        ";

		if (this.getQualifiList().get(second).getP_title() != null
				|| this.getAwardList().get(second).getP_title() != "") {
			certificateDate_value2 = this.getQualifiList().get(second).getP_startDate();
			certificateTitle_value2 = this.getQualifiList().get(second).getP_title();
			certificateDetail_vlaue2 = this.getQualifiList().get(second).getP_organizer();

		}

		insertDataInTable(certificate_table, certificateDate_value2, NanumGothicFont);
		insertDataInTable(certificate_table, certificateTitle_value2, NanumGothicFont);
		insertDataInTable(certificate_table, certificateDetail_vlaue2, NanumGothicFont);
		insertDataInTable(certificate_table, "     ", "      ", NanumGothicFont);
		insertDataInTable(certificate_table, "     ", NanumGothicFont);

		certificate_table.setSpacingAfter(15f);
		document.add(certificate_table);

	}

	private void fillOut_LanguageList(Document document, List<Language_pofol_Impl_Vo> languageList, BaseFont font,
			BaseFont font2) throws DocumentException, IOException {

		Font NanumGothicFont = new Font(font, 9);

		Font NanumGothicBoldFont = new Font(font2, 9);

		// language content
		Paragraph language_content = new Paragraph("어학능력", NanumGothicBoldFont);
		language_content.setSpacingBefore(10);
		language_content.setSpacingAfter(5);
		document.add(language_content);

		// draw line
		LineSeparator sep = new LineSeparator();
		sep.setLineWidth(2);
		document.add(sep);

		// language_table
		float[] language_table_widths = { 0.25f, 0.25f, 0.25f, 0.25f };
		PdfPTable language_table = new PdfPTable(language_table_widths);
		language_table.setTotalWidth(540f);
		language_table.setWidthPercentage(100f);
		language_table.setLockedWidth(true);
		language_table.setSpacingBefore(10);

		for (int i = 0; i < 2; i++) {
			
			String languageDate_value1 = "               ";
			String languageTitle_value1 = "              ";
			String languageScore_value1 = "              ";
			String languageDetail_vlaue1 = "             ";

			insertDataInTable(language_table, languageScore_value1, NanumGothicFont);
			insertDataInTable(language_table, languageDate_value1, NanumGothicFont);
			insertDataInTable(language_table, languageTitle_value1, NanumGothicFont);
			insertDataInTable(language_table, languageDetail_vlaue1, NanumGothicFont);
			insertDataInTable(language_table, "     ", "      ", NanumGothicFont);
			insertDataInTable(language_table, "     ", "      ", NanumGothicFont);
		}

		language_table.setSpacingAfter(15f);
		document.add(language_table);

	}

	private void fillOut_LanguageList(Document document, List<Language_pofol_Impl_Vo> languageList, int first,
			BaseFont font, BaseFont font2) throws DocumentException, IOException {

		Font NanumGothicFont = new Font(font, 9);

		Font NanumGothicBoldFont = new Font(font2, 9);

		// language content
		Paragraph language_content = new Paragraph("어학능력", NanumGothicBoldFont);
		language_content.setSpacingBefore(10);
		language_content.setSpacingAfter(5);
		document.add(language_content);

		// draw line
		LineSeparator sep = new LineSeparator();
		sep.setLineWidth(2);
		document.add(sep);

		// language_table
		float[] language_table_widths = { 0.25f, 0.25f, 0.25f, 0.25f };
		PdfPTable language_table = new PdfPTable(language_table_widths);
		language_table.setTotalWidth(540f);
		language_table.setWidthPercentage(100f);
		language_table.setLockedWidth(true);
		language_table.setSpacingBefore(10);

		String languageDate_value1 = "               ";
		String languageTitle_value1 = "              ";
		String languageScore_value1 = "              ";
		String languageDetail_vlaue1 = "             ";
		
		
		if (this.getLanguageList().get(first).getP_title() != null
				|| this.getAwardList().get(first).getP_title() != "") {
			
			languageTitle_value1 = this.getLanguageList().get(first).getP_title();
			languageDate_value1 = this.getLanguageList().get(first).getP_startDate();
			languageScore_value1 = this.getLanguageList().get(first).getP_examScore();
			languageDetail_vlaue1 = this.getLanguageList().get(first).getP_organizer();

		}

		insertDataInTable(language_table, languageTitle_value1, NanumGothicFont);
		insertDataInTable(language_table, languageDate_value1, NanumGothicFont);
		insertDataInTable(language_table, languageScore_value1, NanumGothicFont);
		insertDataInTable(language_table, languageDetail_vlaue1, NanumGothicFont);
		insertDataInTable(language_table, "     ", "      ", NanumGothicFont);
		insertDataInTable(language_table, "     ", "      ", NanumGothicFont);
		

		String languageDate_value2 = "               ";
		String languageTitle_value2 = "              ";
		String languageScore_value2 = "              ";
		String languageDetail_vlaue2 = "             ";

		insertDataInTable(language_table, languageTitle_value2, NanumGothicFont);
		insertDataInTable(language_table, languageDate_value2, NanumGothicFont);
		insertDataInTable(language_table, languageScore_value2, NanumGothicFont);
		insertDataInTable(language_table, languageDetail_vlaue2, NanumGothicFont);
		insertDataInTable(language_table, "     ", "      ", NanumGothicFont);
		insertDataInTable(language_table, "     ", "      ", NanumGothicFont);

		language_table.setSpacingAfter(15f);
		document.add(language_table);

	}

	private void fillOut_LanguageList(Document document, List<Language_pofol_Impl_Vo> languageList, int first,
			int second, BaseFont font, BaseFont font2) throws DocumentException, IOException {

		Font NanumGothicFont = new Font(font, 9);

		Font NanumGothicBoldFont = new Font(font2, 9);

		// language content
		Paragraph language_content = new Paragraph("어학능력", NanumGothicBoldFont);
		language_content.setSpacingBefore(10);
		language_content.setSpacingAfter(5);
		document.add(language_content);

		// draw line
		LineSeparator sep = new LineSeparator();
		sep.setLineWidth(2);
		document.add(sep);

		// language_table
		float[] language_table_widths = { 0.25f, 0.25f, 0.25f, 0.25f };
		PdfPTable language_table = new PdfPTable(language_table_widths);
		language_table.setTotalWidth(540f);
		language_table.setWidthPercentage(100f);
		language_table.setLockedWidth(true);
		language_table.setSpacingBefore(10);

		String languageDate_value1 = "               ";
		String languageTitle_value1 = "              ";
		String languageScore_value1 = "              ";
		String languageDetail_vlaue1 = "             ";

		if (this.getLanguageList().get(first).getP_title() != null
				|| this.getAwardList().get(first).getP_title() != "") {
			
			languageTitle_value1 = this.getLanguageList().get(first).getP_title();
			languageDate_value1 = this.getLanguageList().get(first).getP_startDate();
			languageScore_value1 = this.getLanguageList().get(first).getP_examScore();
			languageDetail_vlaue1 = this.getLanguageList().get(first).getP_organizer();

		}

		insertDataInTable(language_table, languageTitle_value1, NanumGothicFont);
		insertDataInTable(language_table, languageDate_value1, NanumGothicFont);
		insertDataInTable(language_table, languageScore_value1, NanumGothicFont);
		insertDataInTable(language_table, languageDetail_vlaue1, NanumGothicFont);
		insertDataInTable(language_table, "     ", "      ", NanumGothicFont);
		insertDataInTable(language_table, "     ", "      ", NanumGothicFont);
		

		String languageDate_value2 = "               ";
		String languageTitle_value2 = "              ";
		String languageScore_value2 = "              ";
		String languageDetail_vlaue2 = "             ";

		if (this.getLanguageList().get(second).getP_title() != null
				|| this.getAwardList().get(second).getP_title() != "") {
			
			
			languageTitle_value2 = this.getLanguageList().get(second).getP_title();
			languageDate_value2 = this.getLanguageList().get(second).getP_startDate();
			languageScore_value2 = this.getLanguageList().get(second).getP_examScore();
			languageDetail_vlaue2 = this.getLanguageList().get(second).getP_organizer();

		}

		insertDataInTable(language_table, languageTitle_value2, NanumGothicFont);
		insertDataInTable(language_table, languageDate_value2, NanumGothicFont);
		insertDataInTable(language_table, languageScore_value2, NanumGothicFont);
		insertDataInTable(language_table, languageDetail_vlaue2, NanumGothicFont);
		insertDataInTable(language_table, "     ", "      ", NanumGothicFont);
		insertDataInTable(language_table, "     ", "      ", NanumGothicFont);

		language_table.setSpacingAfter(15f);
		document.add(language_table);

	}

	private void fillOut_MilitaryList(Document document, List<Military_pofol_Impl_Vo> militaryList, BaseFont font,
			BaseFont font2) throws DocumentException, IOException {

		Font NanumGothicFont = new Font(font, 9);
		Font NanumGothicBoldFont = new Font(font2, 9);

		// military content
		Paragraph military_content = new Paragraph("병역", NanumGothicBoldFont);
		military_content.setSpacingBefore(10);
		military_content.setSpacingAfter(5);
		document.add(military_content);

		// draw line
		LineSeparator sep = new LineSeparator();
		sep.setLineWidth(2);
		document.add(sep);

		// military_table
		float[] military_table_widths = { 0.25f, 0.25f, 0.25f, 0.25f };
		PdfPTable military_table = new PdfPTable(military_table_widths);
		military_table.setTotalWidth(540f);
		military_table.setWidthPercentage(100f);
		military_table.setLockedWidth(true);
		military_table.setSpacingBefore(10);

		insertDataInTable(military_table, "        ", NanumGothicFont);
		insertDataInTable(military_table, "        ", NanumGothicFont);
		insertDataInTable(military_table, "      ", NanumGothicFont);
		insertDataInTable(military_table, "      ", NanumGothicFont);

		military_table.setSpacingAfter(15f);
		document.add(military_table);

	}

	private void fillOut_MilitaryList(Document document, List<Military_pofol_Impl_Vo> militaryList, int a,
			BaseFont font, BaseFont font2) throws DocumentException, IOException {

		Font NanumGothicFont = new Font(font, 9);
		Font NanumGothicBoldFont = new Font(font2, 9);

		// military content
		Paragraph military_content = new Paragraph("병역", NanumGothicBoldFont);
		military_content.setSpacingBefore(10);
		military_content.setSpacingAfter(5);
		document.add(military_content);

		// draw line
		LineSeparator sep = new LineSeparator();
		sep.setLineWidth(2);
		document.add(sep);

		// military_table
		float[] military_table_widths = { 0.25f, 0.25f, 0.25f, 0.25f };
		PdfPTable military_table = new PdfPTable(military_table_widths);
		military_table.setTotalWidth(540f);
		military_table.setWidthPercentage(100f);
		military_table.setLockedWidth(true);
		military_table.setSpacingBefore(10);

		insertDataInTable(military_table, this.getMilitaryList().get(a).getP_startDate(), NanumGothicFont);
		insertDataInTable(military_table, this.getMilitaryList().get(a).getP_endDate(), NanumGothicFont);
		insertDataInTable(military_table, this.getMilitaryList().get(a).getP_title(), NanumGothicFont);
		insertDataInTable(military_table, this.getMilitaryList().get(a).getP_organizer(), NanumGothicFont);

		military_table.setSpacingAfter(15f);
		document.add(military_table);

	}

	private void fillOut_Final(Document document, BaseFont font, BaseFont font2) throws DocumentException, IOException {
		// TODO Auto-generated method stub

		Font NanumMyeongjoFont = new Font(font, 10);
		Font batangFont = new Font(font2, 10);

		// title table
		float[] title_widths = { 0.3f, 0.5f, 0.2f };
		PdfPTable title_table = new PdfPTable(title_widths);
		title_table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
		// table total width MAX : 600
		title_table.setTotalWidth(540f);
		title_table.setWidthPercentage(100f);
		title_table.setLockedWidth(true);

		
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy.MM.dd", Locale.KOREA );
		Date currentTime = new Date ( );
		String mTime = mSimpleDateFormat.format ( currentTime );
		
		
		insertDataInTable(title_table, "   ", NanumMyeongjoFont);
		insertDataInTable(title_table, "        위의 사실이 틀림없음을 서약합니다.", NanumMyeongjoFont);
		insertDataInTable(title_table, "작성일     "+ mTime, NanumMyeongjoFont);

		insertDataInTable(title_table, "   ", NanumMyeongjoFont);
		insertDataInTable(title_table, "   ", NanumMyeongjoFont);
		insertDataInTable(title_table, "작성자    "+ userVo.getU_name()+"   (인)", NanumMyeongjoFont);

		title_table.setSpacingBefore(30);
		document.add(title_table);

	}

	// table에 선 그리기
	private void insertLineInTable(PdfPTable table) {

		PdfPCell pdfpCell = new PdfPCell();

		pdfpCell.setBorder(PdfPCell.ALIGN_BOTTOM);
		table.addCell(pdfpCell);

		PdfPCell pdfpCell2 = new PdfPCell();
		pdfpCell2.setBorder(PdfPCell.ALIGN_BOTTOM);
		table.addCell(pdfpCell2);
	}

	// 들어가는 값 key = 이름 분류, value = 이름
	private void insertDataInTable(PdfPTable table, String key, String value, Font font) {

		PdfPCell pdfpCell_key = new PdfPCell(new Paragraph(key, font));
		pdfpCell_key.setBorder(PdfPCell.NO_BORDER);
		table.addCell(pdfpCell_key);

		PdfPCell pdfpCell_value = new PdfPCell(new Paragraph(value, font));
		pdfpCell_value.setBorder(PdfPCell.NO_BORDER);
		table.addCell(pdfpCell_value);

	}

	// 들어가는 값이 한개 일때
	private void insertDataInTable(PdfPTable table, String string, Font font) {

		PdfPCell pdfpCell = new PdfPCell(new Paragraph(string, font));
		pdfpCell.setBorder(PdfPCell.NO_BORDER);
		table.addCell(pdfpCell);

	}

	public User_Info_Vo getUserVo() {
		return userVo;
	}

	public void setUserVo(User_Info_Vo userVo) {
		this.userVo = userVo;
	}

	public List<Edu_pofol_Impl_Vo> getEduList() {
		return eduList;
	}

	public void setEduList(List<Edu_pofol_Impl_Vo> eduList) {
		this.eduList = eduList;
	}

	public List<Award_pofol_Impl_Vo> getAwardList() {
		return awardList;
	}

	public void setAwardList(List<Award_pofol_Impl_Vo> awardList) {
		this.awardList = awardList;
	}

	public List<Language_pofol_Impl_Vo> getLanguageList() {
		return languageList;
	}

	public void setLanguageList(List<Language_pofol_Impl_Vo> languageList) {
		this.languageList = languageList;
	}

	public List<MainAct_pofol_Impl_Vo> getMainActList() {
		return mainActList;
	}

	public void setMainActList(List<MainAct_pofol_Impl_Vo> mainActList) {
		this.mainActList = mainActList;
	}

	public List<Qualifi_pofol_Impl_Vo> getQualifiList() {
		return qualifiList;
	}

	public void setQualifiList(List<Qualifi_pofol_Impl_Vo> qualifiList) {
		this.qualifiList = qualifiList;
	}

	public List<Military_pofol_Impl_Vo> getMilitaryList() {
		return militaryList;
	}

	public void setMilitaryList(List<Military_pofol_Impl_Vo> militaryList) {
		this.militaryList = militaryList;
	}

	public String getJuso() {
		return juso;
	}

	public void setJuso(String juso) {
		this.juso = juso;
	}
}