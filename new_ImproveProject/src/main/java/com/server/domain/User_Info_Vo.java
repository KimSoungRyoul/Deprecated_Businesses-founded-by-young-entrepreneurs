package com.server.domain;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.server.domain.pofol.Military_pofol_Impl_Vo;

public class User_Info_Vo implements ValueObjcet_IF {

	private int u_no;
	private String u_regDate;

	private String u_name;
	private String u_id;
	private String u_pw;
	private String u_email;
	private String u_pnum;
	// private String u_military;
	private String u_sex;
	private String u_birthDate;

	private AttachVo u_profilePhoto;

	

	public User_Info_Vo() {
		// TODO Auto-generated constructor stub
	}

	public User_Info_Vo(int u_no, String u_regDate, String u_name, String u_id, String u_pw, String u_email,
			String u_pnum/* , String u_military */, String u_sex, String u_birthDate, AttachVo profilePhoto) {
		super();
		this.u_no = u_no;
		this.u_regDate = u_regDate;
		this.u_name = u_name;
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.u_email = u_email;
		this.u_pnum = u_pnum;
		this.u_sex = u_sex;
		this.u_birthDate = u_birthDate;
		this.u_profilePhoto = profilePhoto;
		

	}

	public String parseTOJSON() {

		return new Gson().toJson(this, User_Info_Vo.class);

		
	}

	public User_Info_Vo parseTOObject(String jsonStr) {

		return new Gson().fromJson(jsonStr, User_Info_Vo.class);
	}

	public int getU_no() {
		return u_no;
	}

	public void setU_no(int u_no) {
		this.u_no = u_no;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_pw() {
		return u_pw;
	}

	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public String getU_pnum() {
		return u_pnum;
	}

	public void setU_pnum(String u_pnum) {
		this.u_pnum = u_pnum;
	}

	
	public String getU_sex() {
		return u_sex;
	}

	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}

	public String getU_birthDate() {
		return u_birthDate;
	}

	public void setU_birthDate(String u_birthDate) {
		this.u_birthDate = u_birthDate;
	}

	public String getU_regDate() {
		return u_regDate;
	}

	public void setU_regDate(String u_regDate) {
		this.u_regDate = u_regDate;
	}

	public AttachVo getU_profilePhoto() {
		return u_profilePhoto;
	}

	public void setU_profilePhoto(AttachVo u_profilePhoto) {
		this.u_profilePhoto = u_profilePhoto;
	}

	@Override
	public String toString() {
		return "User_Info_Vo [u_no=" + u_no + ", u_regDate=" + u_regDate + ", u_name=" + u_name + ", u_id=" + u_id
				+ ", u_pw=" + u_pw + ", u_email=" + u_email + ", u_pnum=" + u_pnum + ", u_sex=" + u_sex
				+ ", u_birthDate=" + u_birthDate + ", u_profilePhoto=" + u_profilePhoto + "]";
	}

}
