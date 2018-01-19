package com.server.domain;

public interface ValueObjcet_IF { //vo 계열의 클래스들은 반드시 아래 메소드를 가지고 있어야한다
	
	public String parseTOJSON();
	
	public Object parseTOObject(String jsonStr);
	
}
