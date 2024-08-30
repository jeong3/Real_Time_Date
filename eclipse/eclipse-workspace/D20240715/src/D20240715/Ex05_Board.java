package D20240715;

public class Ex05_Board { // 캡슐화 
	//캡슐화를 하여 private을 통해 멤버들을 은닉할 수 있음
	//private = 접근지정자 : 엑세스를 할 수 있도록 하는 권한
	private int num;
	private String subject;
	private String contents;
	private String writer;
	
	public void setData(int num, String subject, String contents, String writer) {
		this.num = num;
		this.subject = subject;
		this.contents = contents;
		this.writer = writer;
	}
	
	//setter : 은닉 멤버를 엑세스하여 사용
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public void setWriter(String writer){
		this.writer = writer;
	}
	
	//void는 비어있다는 뜻으로 출력할 때는 사용하지 않는다.
	//getter
	public int getNum() { //public 타입(반환형) 메서드이름() 피호출 메서드
		return num; // return : 외부로 값을 전달한다. 호출 메서드로 값을 전달
	}
	public String getsubject() {
		return subject;
	}
	public String getcontents() {
		return contents;
	}
	public String getwriter() {
		return writer;
	}
	
	
	public void print() {
		System.out.println(num);
		System.out.println(subject);
		System.out.println(contents);
		System.out.println(writer);
	}
}
