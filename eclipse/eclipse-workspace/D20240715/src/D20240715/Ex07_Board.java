package D20240715;

public class Ex07_Board {
	/*(default)*/int num; //기본적으로 dafault로 은닉되어 있다. 
	String subject;
	String contents;
	String writer;
	
	//생성자 : 객체가 생성이 될 때 자동으로 실행되는 메서드
	//오버로딩 : 메서드의 이름이 같을 때 오버로딩이라고 한다.
	public Ex07_Board() {} // 기본 생성자(default 생성자) : 정의하지 않아도 존재하는 생성자
	//기본 생성자이지만 같은 이름의 생성자를 정의하게 되면 자동으로 생성되지 않는다.
	public Ex07_Board(int num, String subject, String contents, String writer) {
		this.num = num;
		this.subject = subject;
		this.contents = contents;
		this.writer = writer;
	}
	
	public void print() {
		System.out.println(num);
		System.out.println(subject);
		System.out.println(contents);
		System.out.println(writer);
	}

}
