package kr.inflearn;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class Project01_A {

	public static void main(String[] args) {
		// Object(BookDTO)  --> JSON(String)
		
		//DAO --> 실제로 DB에 접근하는 객체, Service와 DB룰 연결하는 고리역할 
		//DTO --> DB에서 데이터를 얻어 Service나 Controller 등으로 보낼 때 사용하는 객체를 말한다.
		//로직을 갖고있지 않은 순수한 데이터 객체이며, getter/setter 메서드만을 갖는다 
		// VO --> VO는 DTO와 비슷한 개념이지만 read only 속성을 갖는다.  
		
		BookDTO dto = new BookDTO("자바", 21000, "에이콘", 670);
		// 이 객체를 json으로 바꾸고 싶다
		Gson g = new Gson(); // Gson 객체 생성 (json) 객체를 생성하기 위한 Gson 객체 
		
		String json = g.toJson(dto); 
		System.out.println(json); //{"title":"자바","price":21000,"company":"에이콘","page":670}
		
		
		// 다시 자바의 객체로 변환시키고 싶다
		BookDTO dto1 = g.fromJson(json, BookDTO.class); // json 객체를 BookDTO타입 객체로 다시 만들고 싶다
		System.out.println(dto1); //BookDTO [title=자바, price=21000, company=에이콘, page=670]
		System.out.println(dto1.getPrice());
		
		// List 객체안에 BookDTO 객채들을 넣고 싶다. 여러개의 DTO 객체를 넣고싶다. 
		
		List<BookDTO> list = new ArrayList<>(); 
		list.add(new BookDTO("자바1", 21000, "에이콘1", 570));
		list.add(new BookDTO("자바2", 31000, "에이콘2", 970));
		list.add(new BookDTO("자바3", 41000, "에이콘3", 670));
		
		// 이 객체를 JSON 객체로 바꾸고 싶다. 
		
		 String listJson = g.toJson(list); // list 객체를 json 객체로 만들었다. 긴 문자열 형태 
		 System.out.println(listJson);
		 
		 // json 객체(List 객체가 json객체가 된 형태)를 다시 BookDTO 타입의 객체로 만들고 싶다. 
		 
		 // 즉 JSON(Stinrg) ---> Objsect(list<BookDTO>) 로 바꾸고싶다
		 List<BookDTO> list1 = g.fromJson(listJson, new TypeToken<List<BookDTO>>() {}.getType());
		 
		 // List<BookDTO>는 런타임시 제네릭은 소거가 된다. 따라서 어떤 객체로 만들어야하는지 GSON 객체는 모른다. 
		 // 따라서 편법을 사용해서 TypeToken 객체로 감싼 후, 익명객체로 바로 구현한다.
		 // GSON 객체가 어떤 List 안에 어떤 객체의 타입이 들어가는지 확인할 수 있다는 것이다 
		 // 자바 리플렉션 기법
		 
		 for(BookDTO vo : list1) {
			 System.out.println(vo);
		 }
		
		
		
	}

}
