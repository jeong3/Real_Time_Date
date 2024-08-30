package D20240716;

public class Ex11_Student {
	static int seialNum;
	static int num1;
	int id;
	String name;
	int grade;
	String address;
	
	static {//static 블럭 : 스태틱 변수에 초기값을 주기위해 사용하는 블럭
		seialNum = 1000000; //static블럭 안에는 static변수만을 초기화 할 수 있다.
		setNum1(); //static 메서드를 실행 할 수 있다.
	}
	public static void setNum1() {
		num1 = 10000; //static 블럭과 마찬가지로 static변수만을 초기화 할 수 있다.
	}
	
	public Ex11_Student() {}

	public Ex11_Student(int id, String name, int grade, String address) {
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.address = address;
	}
	public void print() {
		System.out.println(id);
		System.out.println(name);
		System.out.println(grade);
		System.out.println(address);
	}
}
