package kr.inflearn;

import org.json.JSONArray;
import org.json.JSONObject;

public class Project01_B {

	public static void main(String[] args) {
		
		JSONArray students = new JSONArray();
		
		//JSON-Java(org.json) 
		JSONObject student = new JSONObject(); //JSONObject 생성
		student.put("name", "LimSol");
		student.put("phone", "010-1111-1111");
		student.put("address", "서울");
		// 한 사람의 JSON 객체 
		students.put(student);
		
		
		student = new JSONObject();
		student.put("name", "LeeHaeJu");
		student.put("phone", "010-2111-3111");
		student.put("address", "서울");
		students.put(student);
		
		
		JSONObject object = new JSONObject();
		object.put("students", students);
		
		System.out.println(object);

	}

}
