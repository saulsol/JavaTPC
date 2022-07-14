package kr.inflearn;

import java.io.*;
import java.net.*;
import java.util.Date;
import org.json.*;




public class Project01_D {

	public static void main(String[] args) {
		
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		String clientId = "at69eivyqa"; 
		String clientSecret = "XBGpILhkc5FTVrNkTSQ77p9vD06ZVaOSAlNJDVuK";
		
		try {
			System.out.print("주소를 입력하세요 :");
			String address = io.readLine();
			String addr = URLEncoder.encode(address, "UTF-8");
			
			String apiURL = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=" + addr; // json
			URL url = new URL(apiURL);
			
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.addRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
			con.addRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
			
			int responseCode = con.getResponseCode();
			
			BufferedReader br;
			if(responseCode==200)
				br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
			else 
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			
			JSONTokener tokener = new JSONTokener(response.toString());
			JSONObject object = new JSONObject(tokener);
			// System.out.println(object); // 확인
			
			JSONArray arr = object.getJSONArray("addresses");
			
			for(int i=0; i<arr.length(); i++) {
				JSONObject temp = (JSONObject) arr.get(i);
				System.out.println("address : " + temp.get("roadAddress"));
				System.out.println("jibunAddress : " + temp.get("jibunAddress"));
				System.out.println("경도 : "+temp.get("x"));
				System.out.println("위도 : "+temp.get("y"));
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
