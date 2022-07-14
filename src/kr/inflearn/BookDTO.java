package kr.inflearn;

public class BookDTO { // 책의 직접적인 정보가 들어가는 객체
	
	private String title; // 책 제목
	private int price; // 책 가격
	private String company; // 출판사
	private int page; // 책의 페이지 
	
	public BookDTO() {} // 기본 생성자는 항상 만든다

	// 마우스 오른쪽 클릭하고 source 로 가서 Generate 하면된다
	
	public BookDTO(String title, int price, String company, int page) {
		super();
		this.title = title;
		this.price = price;
		this.company = company;
		this.page = page;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "BookDTO [title=" + title + ", price=" + price + ", company=" + company + ", page=" + page + "]";
	}
	
	

	
	
	
	
	
	
	
}
