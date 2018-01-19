package com.server.domain;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.server.domain.pofol.Edu_pofol_Impl_Vo;
import com.server.dto.ResumeDTO;

class EmployeeInfo {
	public int rank;

	EmployeeInfo(int rank) {
		this.rank = rank;
	}
}

class Person<T, S> {
	public T info;
	public S id;

	Person(T info, S id) {
		this.info = info;
		this.id = id;
	}

	public <U> void printInfo(U info) {
		System.out.println(info);
	}

	
	@SuppressWarnings("hiding")
	public <T> List<Integer> extractP_no(List<T> pofolList) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		List<Integer> p_noList=new ArrayList<Integer>();	 	
		if(pofolList.isEmpty()){
			return null;
		}
		
		Class<? extends Object> cl= pofolList.get(0).getClass();
		Method method = cl.getMethod("getP_no");
		
		for (T pofol: pofolList) {
			
 			Object retobj = method.invoke(pofol, null);

			
			Integer p_no = (Integer) retobj;
			p_noList.add(p_no);
		}

		return p_noList;
	}
	
	
	public Map<String, String> makepofolParam(String uniqueResumeKey, String pofolType) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		
		ResumeDTO resumeDto = null;
		Map<String, String> pofolParam = new HashMap<String, String>();
		pofolParam.put("uniqueResumeKey", uniqueResumeKey);
		Class resumeDtoClass = ResumeDTO.class;
		
		String transString=pofolType.substring(0, 1).toUpperCase();
		transString+=pofolType.substring(1);
		

		System.out.println(transString);
		
		Method method = resumeDtoClass.getMethod(
				"get" + transString +"NoList" ,null);
		List<Integer> retobj = (List<Integer>) method.invoke(resumeDto.getClass(), null);
		List<Integer> p_noList=(List<Integer>) retobj;
		for (Integer p_no : p_noList) {
			pofolParam.put("p_no", String.valueOf(p_no));
		}
		return pofolParam;
		
	}
	
	

}

public class GenericDemo {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		EmployeeInfo e = new EmployeeInfo(1);
		Integer i = new Integer(10);
		Person<EmployeeInfo, Integer> p1 = new Person<EmployeeInfo, Integer>(e, i);
		p1.<EmployeeInfo> printInfo(e);
		p1.printInfo(e);
	
	
		List<Edu_pofol_Impl_Vo> pofolList=new LinkedList<Edu_pofol_Impl_Vo>();
		Edu_pofol_Impl_Vo vo=new Edu_pofol_Impl_Vo(); vo.setP_no(3);
		pofolList.add(vo);
		
		Edu_pofol_Impl_Vo vo2=new Edu_pofol_Impl_Vo(); vo.setP_no(77);
		pofolList.add(vo2);
		
		List<Integer> p_noList= p1.<Edu_pofol_Impl_Vo> extractP_no(pofolList);
	
		for(int p_no:p_noList){			
			System.out.println(p_no);
		}
	
		String uniqueResumeKey="qawsedrf";
		Map<String, String> pofolParam = new HashMap<String, String>();
		Map<String, String> pofolParam1= p1.makepofolParam(uniqueResumeKey,"edu");
		Map<String, String> pofolParamp2 =p1.makepofolParam(uniqueResumeKey,"award");
		Map<String, String> pofolParamp3=p1.makepofolParam(uniqueResumeKey,"lang");
		Map<String, String> pofolParamp4=p1.makepofolParam(uniqueResumeKey,"main");
		Map<String, String> pofolParamp5=p1.makepofolParam(uniqueResumeKey,"qualifi");
		Map<String, String> pofolParamp6=p1.makepofolParam(uniqueResumeKey,"military");
		
	
	
	
	
	}
}