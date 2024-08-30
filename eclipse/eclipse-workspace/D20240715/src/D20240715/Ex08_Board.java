package D20240715;

public class Ex08_Board {
	int num;
	String subject;
	String contents;
	String writer;
	//public Ex08_Board(){} 생성자가 정의되지 않은 경우 기본생성자가 존재한다.
	//멤버를 초기화하기 위해서 생성자 사용
	public Ex08_Board(int num, String subject, String contents, String writer){
		this.num = num; this.subject = subject; this.contents = contents; this.writer = writer;
	} 
	// 위와 같이 생성자를 정의하면 기본생성자는 존재하지않는다.
	// 따라서 기본생성자를 정의 해주어야 한다.
	public Ex08_Board(){} 
	//같은 이름의 메서드 명을 가진 것을 오버로딩이라고 한다.
	
	
	
	
	
	public void print() {
		System.out.println(num);
		System.out.println(subject);
		System.out.println(contents);
		System.out.println(writer);
	}
	
	
	
	
	
	
}
