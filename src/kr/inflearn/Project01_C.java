package kr.inflearn;

import java.io.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Project01_C {

	public static void main(String[] args) {
		String src = "info.json";
		// json 파일과 연결 
		InputStream is = Project01_C.class.getResourceAsStream(src);
		// 해당 클래스가 있는 곳에서 해당 파일(src)과 연결해라 스트림 객체 생성해라
		
		if(is == null)
			throw new NullPointerException("Cannot find resource file");
		
		JSONTokener tokener = new JSONTokener(is);
		// json 구조로 토큰화 
		
		JSONObject object = new JSONObject(tokener);
		JSONArray students = object.getJSONArray("students");

		for(int i=0; i<students.length(); i++) {
			 JSONObject student =(JSONObject)students.get(i); // 넘겨주는 타입이 Object 타입이기 때문에 
			 System.out.print(student.get("name"));
			 System.out.print(student.get("address"));
			 System.out.println(student.get("phone"));
		}

			
		
		
		

	}

}
