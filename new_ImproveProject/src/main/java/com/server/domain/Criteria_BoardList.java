package com.server.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Criteria_BoardList extends Criteria implements ValueObjcet_IF{
	
/*	private int page;
	private int perPageNum;

	private String hashtag;*/
		
	private List<Integer> list;

	
	/*
	 List<AttachVo> p_aList=new ArrayList<AttachVo>();
		
		for(int n = 0; n < aJSONList.length(); n++)
		{
		    JSONObject object =aJSONList.getJSONObject(n);
		    AttachVo avo=new AttachVo();
		   avo=avo.parseTOObject(object.toString());
		    p_aList.add(avo);
		}
		
		return p_aList;
	 *
	 */
	

	@Override
	public String parseTOJSON() {
		// TODO Auto-generated method stub
		JSONObject obj = new JSONObject();

		obj.put("page", this.getPage());
		obj.put("perPageNum", this.getPerPageNum());
		obj.put("hashtag", this.getHashtag());
		
		JSONArray arr=new JSONArray(list);
		
		obj.put("b_noList", arr);
		
		return obj.toString();
	}

	@Override
	public Criteria_BoardList parseTOObject(String jsonStr) {
		// TODO Auto-generated method stub
		
		JSONObject obj = new JSONObject(jsonStr);
		
		Criteria_BoardList cri_bl=new Criteria_BoardList();
		
		int page = obj.getInt("page");
		int perPageNum = obj.getInt("perPageNum");
		String hashtag = obj.getString("hashtag");

		cri_bl.setPage(page);
		cri_bl.setPerPageNum(perPageNum);
		cri_bl.setHashtag(hashtag);
		
		
		
		List<Integer> bList=new LinkedList<Integer>();
		
		JSONArray arr=obj.getJSONArray("b_noList");
		
		for(int i=0;i<arr.length();i++){
			bList.add(arr.getInt(i));
		}
		
		
		cri_bl.setList(bList);
		
		return cri_bl;
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	

	
	
		
	
	
}
