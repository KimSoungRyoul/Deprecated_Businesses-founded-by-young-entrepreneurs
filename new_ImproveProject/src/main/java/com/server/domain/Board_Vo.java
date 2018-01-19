package com.server.domain;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;


public class Board_Vo implements ValueObjcet_IF{

	private int b_parent_no;
	private int b_no;
	private String b_regDate;
	
	private String b_title;
	private String b_writer;
	private String b_content;
	private int b_viewcnt;
	
	private int b_replycnt;
	
	List<String> hashTagList=new LinkedList<String>();
	List<String> likeList=new LinkedList<String>();
	
	
	List<Board_Vo> replyList= new LinkedList<Board_Vo>();
	
	
	public Board_Vo() {
		// TODO Auto-generated constructor stub
	this.b_replycnt=this.replyList.size();
	
	}
	
	
	@Override
	public String parseTOJSON() {
		JSONObject obj = new JSONObject();
		
		obj.put("b_parent_no", this.b_parent_no);
		//obj.put("b_no", this.b_no);
		//obj.put("b_regDate", this.b_regDate);
		obj.put("b_title", this.b_title);
		obj.put("b_writer", this.b_writer);
		obj.put("b_content", this.b_content);
		//obj.put("hashTagList", this.hashTagList);
		
		JSONArray arr=new JSONArray(this.hashTagList);
		//System.out.println(arr.toString());
		obj.put("hashTagList", arr);
		//obj.put("likeList", this.likeList);
		//obj.put("b_viewcnt", this.b_viewcnt);
		//obj.put("replyList", this.replyList);
		//obj.put("b_replycnt", this.b_replycnt);
		
		return obj.toString();
	}

	
	@Override
	public Board_Vo parseTOObject(String jsonStr) {
		// TODO Auto-generated method stub
		JSONObject obj=new JSONObject(jsonStr);
		Board_Vo vo=new Board_Vo();
		
		int b_parent_no=obj.getInt("b_parent_no");
		int b_no=obj.getInt("b_no");
		String b_regDate=obj.getString("b_regDate");
		String b_title=obj.getString("b_title");
		String b_writer=obj.getString("b_writer");
		String b_content=obj.getString("b_content");
		//int b_viewcnt=obj.getInt("b_viewcnt");
		//int b_replycnt=obj.getInt("b_replycnt");
		
		
		JSONArray hashListStr=obj.getJSONArray("hashTagList");
		JSONArray likeListStr=obj.getJSONArray("likeList");
		//JSONArray replyListStr=obj.getJSONArray("replyList");
		
		
		List<String> hashList= parseToStrList(hashListStr);
		List<String> likeList=parseToStrList(likeListStr);
		List<Board_Vo> replyList=new LinkedList<Board_Vo>();
		
		/*Board_Vo board=new Board_Vo();
		for(int n = 0; n < replyListStr.length(); n++){
			JSONObject jObj=new JSONObject(replyList.get(n));
			replyList.add(board.parseTOObject(jObj.toString()));
			
		}*/
		
		
		//it's just test print  
		//System.out.println(hashList.toString());
		vo.setB_parent_no(b_parent_no);
		vo.setB_no(b_no);
		vo.setB_regDate(b_regDate);
		
		vo.setB_content(b_content);
		vo.setB_title(b_title);
		vo.setB_writer(b_writer);
		vo.setB_viewcnt(b_viewcnt);
		
		vo.setHashTagList(hashList);
		vo.setLikeList(likeList);
		
		//vo.setReplyList(replyList);
		//vo.setB_replycnt(b_replycnt);
		
		return vo;
	}
	
	private List<String> parseToStrList(JSONArray jArray){
		List<String> list=new LinkedList<String>();
		for(int n = 0; n < jArray.length(); n++)
		{
		    String str =jArray.getString(n);
		    list.add(str);
		}
		
		return list; 
	}
	
	
	
	
	public int getB_viewcnt() {
		return b_viewcnt;
	}


	public void setB_viewcnt(int b_viewcnt) {
		this.b_viewcnt = b_viewcnt;
	}


	public int getB_parent_no() {
		return b_parent_no;
	}

	public void setB_parent_no(int b_parent_no) {
		this.b_parent_no = b_parent_no;
	}

	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public String getB_regDate() {
		return b_regDate;
	}

	public void setB_regDate(String b_regDate) {
		this.b_regDate = b_regDate;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_writer() {
		return b_writer;
	}

	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public List<String> getHashTagList() {
		return hashTagList;
	}

	public void setHashTagList(List<String> hashTagList) {
		this.hashTagList = hashTagList;
	}

	public List<String> getLikeList() {
		return likeList;
	}

	public void setLikeList(List<String> likeList) {
		this.likeList = likeList;
	}


	public List<Board_Vo> getReplyList() {
		return replyList;
	}


	public void setReplyList(List<Board_Vo> replyList) {
		this.replyList = replyList;
		this.b_replycnt=replyList.size();
	}

	public int getB_replycnt() {
		return b_replycnt;
	}


	public void setB_replycnt(int b_replycnt) {
		this.b_replycnt = b_replycnt;
	}


	@Override
	public String toString() {
		return "Board_Vo [b_parent_no=" + b_parent_no + ", b_no=" + b_no + ", b_regDate=" + b_regDate + ", b_title="
				+ b_title + ", b_writer=" + b_writer + ", b_content=" + b_content + ", hashTagList=" + hashTagList
				+ ", likeList=" + likeList + "]";
	}

	
	
	
	
	
	
	
}