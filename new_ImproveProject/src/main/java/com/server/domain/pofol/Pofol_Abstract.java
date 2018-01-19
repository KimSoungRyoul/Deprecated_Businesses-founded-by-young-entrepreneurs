package com.server.domain.pofol;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.server.domain.AttachVo;
import com.server.domain.Multi_Media_VO;
import com.server.domain.ValueObjcet_IF;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public abstract class Pofol_Abstract implements ValueObjcet_IF{

	// 서버 통신과 필요한 내용
	protected int p_no;
	protected String p_type;
	protected String p_u_id;
	protected String p_regDate;

	// ui 보여줄 필요 내용
	protected String p_title;
	protected String p_startDate;
	protected String p_endDate;
	protected String p_organizer;
	protected String p_actcontent;

	protected List<AttachVo> p_attachFileList = new LinkedList<AttachVo>();
	protected List<Multi_Media_VO> p_mAttachFileList = new ArrayList<Multi_Media_VO>();

	public Pofol_Abstract() {
		// TODO Auto-generated constructor stub
	}

	public Pofol_Abstract(int p_no, String p_type, String p_u_id, String p_regDate, String p_title, String p_startDate,
						  String p_endDate, String p_organizer, String p_actcontent, List<AttachVo> p_attachFileList,
						  List<Multi_Media_VO> p_mAttachFileList) {
		super();
		this.p_no = p_no;
		this.p_type = p_type;
		this.p_u_id = p_u_id;
		this.p_regDate = p_regDate;
		this.p_title = p_title;
		this.p_startDate = p_startDate;
		this.p_endDate = p_endDate;
		this.p_organizer = p_organizer;
		this.p_actcontent = p_actcontent;
		this.p_attachFileList = p_attachFileList;
		this.p_mAttachFileList = p_mAttachFileList;
	}

	protected List<AttachVo> parseToAttachList(JSONArray aJSONList) throws JSONException {

		List<AttachVo> p_aList = new ArrayList<AttachVo>();

		for (int n = 0; n < aJSONList.length(); n++) {
			JSONObject object = aJSONList.getJSONObject(n);
			AttachVo avo = new AttachVo();
			avo = avo.parseTOObject(object.toString());
			p_aList.add(avo);
		}

		return p_aList;
	}
	protected List<Multi_Media_VO> parseToMattachList(JSONArray aJSONList) throws JSONException {

		List<Multi_Media_VO> p_mAList = new ArrayList<Multi_Media_VO>();

		for (int n = 0; n < aJSONList.length(); n++) {
			JSONObject object = aJSONList.getJSONObject(n);
			Multi_Media_VO mVo=new Multi_Media_VO();
			mVo = mVo.parseTOObject(object.toString());
			p_mAList.add(mVo);
		}

		return p_mAList;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public String getP_type() {
		return p_type;
	}

	public void setP_type(String p_type) {
		this.p_type = p_type;
	}

	public String getP_u_id() {
		return p_u_id;
	}

	public void setP_u_id(String p_u_id) {
		this.p_u_id = p_u_id;
	}

	public String getP_title() {
		return p_title;
	}

	public void setP_title(String p_title) {
		this.p_title = p_title;
	}

	public String getP_startDate() {
		return p_startDate;
	}

	public void setP_startDate(String p_startDate) {
		this.p_startDate = p_startDate;
	}

	public String getP_endDate() {
		return p_endDate;
	}

	public String getP_regDate() {
		return p_regDate;
	}

	public void setP_regDate(String p_regDate) {
		this.p_regDate = p_regDate;
	}

	public void setP_endDate(String p_endDate) {
		this.p_endDate = p_endDate;
	}

	public String getP_organizer() {
		return p_organizer;
	}

	public void setP_organizer(String p_organizer) {
		this.p_organizer = p_organizer;
	}

	public List<AttachVo> getP_attachFileList() {
		return p_attachFileList;
	}

	public void setP_attachFileList(List<AttachVo> p_attachFileList) {
		this.p_attachFileList = p_attachFileList;
	}

	public String getP_actcontent() {
		return p_actcontent;
	}

	public void setP_actcontent(String p_act_content) {
		this.p_actcontent = p_act_content;
	}



	public List<Multi_Media_VO> getP_mAttachFileList() {
		return p_mAttachFileList;
	}

	public void setP_mAttachFileList(List<Multi_Media_VO> p_mAttachFileList) {
		this.p_mAttachFileList = p_mAttachFileList;
	}

	@Override
	public String toString() {
		return "Pofol_Abstract [p_no=" + p_no + ", p_type=" + p_type + ", p_u_id=" + p_u_id + ", p_regDate=" + p_regDate
				+ ", p_title=" + p_title + ", p_startDate=" + p_startDate + ", p_endDate=" + p_endDate
				+ ", p_organizer=" + p_organizer + ", p_attachFileList=" + p_attachFileList + "]";
	}




}
