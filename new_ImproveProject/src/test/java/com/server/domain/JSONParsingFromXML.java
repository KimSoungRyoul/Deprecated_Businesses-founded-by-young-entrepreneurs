package com.server.domain;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
 
import org.json.JSONObject;
import org.json.XML;
 
public class JSONParsingFromXML {
    public static int INDENT_FACTOR = 4;
    public static void main(String args[]) throws MalformedURLException,
            IOException {
       /* HttpURLConnection conn = (HttpURLConnection) new URL("http://openapi.hira.or.kr/openapi/service/pharmacyInfoService/getParmacyBasisList?"
                + "ServiceKey=[SERVICE_KEY]").openConnection();
        conn.connect();
        BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(bis));
        StringBuffer st = new StringBuffer();
        String line;
        while ((line = reader.readLine()) != null) {
            st.append(line);
        }*/
 
    	String st="";
    	
    	
        JSONObject xmlJSONObj = XML.toJSONObject(st.toString());
        String jsonPrettyPrintString = xmlJSONObj.toString(INDENT_FACTOR);
        System.out.println(jsonPrettyPrintString);
 
    }
}
 