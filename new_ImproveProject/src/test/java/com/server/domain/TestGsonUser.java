package com.server.domain;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by 1004lucifer on 2015-04-08.
 */
public class TestGsonUser {
    public static void main(String[] argv) {
        Company company = Company.getCompanyDummy();
 
        System.out.println("========= Object => Json ==========");
        String company2Json = new Gson().toJson(company);
        System.out.println(company2Json);
 
        System.out.println("========= Json => Object =========");
        Company json2Company = new Gson().fromJson(company2Json, Company.class);
        printCompanyObject(json2Company);
 
        System.out.println("========= Object => Json =========");
        String company2JsonIsNull = new GsonBuilder().serializeNulls().create().toJson(company);
        System.out.println(company2JsonIsNull);
 
        System.out.println("========= Json => Object =========");
        Company json2CompanyIsNull = new Gson().fromJson(company2Json, Company.class);
        printCompanyObject(json2CompanyIsNull);
        
        
        
        User_Info_Vo user1 = new User_Info_Vo();
        AttachVo vo = new AttachVo(32, "\\2016\\09\\01\\improve_kaka.png", "asdf", "asdf", 43, 12);
        
        
        
		user1.setU_no(23);
		user1.setU_name("김성렬");
		user1.setU_id("sky5367");
		user1.setU_pw("123456");
		user1.setU_pnum("010-7237-6602");
		user1.setU_email("rlatjduf510@naver.com");
		// user1.setU_military("육군병장 만기전역");
		user1.setU_sex("woman");
		user1.setU_birthDate("1993-08-23");
		user1.setU_regDate("2016-08-11 12:32:22");
		user1.setU_profilePhoto(vo);
        
        
        System.out.println("========= Object => Json =========");
        String userInfoStr=new Gson().toJson(user1, User_Info_Vo.class);
        
        System.out.println(userInfoStr);
        
        System.out.println("========= Json => Object =========");
        User_Info_Vo userGet=new Gson().fromJson(userInfoStr, User_Info_Vo.class);
        System.out.println(userGet.toString());
        
        
        
        
        
    }
 
    private static void printCompanyObject(Company company) {
        List<Company.Person> personList = company.getEmployees();
        System.out.println("userName: " + company.getName());
        for (Company.Person person : personList) {
            System.out.println(person);
        }
    }
}