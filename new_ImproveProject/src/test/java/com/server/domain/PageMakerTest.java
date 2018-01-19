package com.server.domain;

public class PageMakerTest {

	
	public static void main(String[] args) {
		
		PageMaker pageMaker;
		
		pageMaker=new PageMaker();
		
		Criteria cri=new Criteria();
		
		cri.setPage(1);
		
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(113);
		
		
		System.out.println(cri.toString());
		System.out.println(pageMaker.toString());
		
		pageMaker.toString();
		
	}
}
