package D20240715;

public class Ex03_Student {
	// 멤버 필드이자 멤버 변수
	String name;
	String addr;
	int studentNum;
	int age;
	int grade;
	double height;
	boolean gender;

	//피호출 메서드
	public void setData(/* 매개변수 (가인자) parameter*/
			String name, String addr,  int studentNum, int age, 
			int grade, double height, boolean gender) {
		this.name = name; this.addr = addr; this.age = age; this.studentNum = studentNum;
		this.grade = grade; this.height = height; this.gender = gender;
	} // this -> 멤버 필드
	
	public void print() {
		System.out.println(name);
		System.out.println(addr);
		System.out.println(studentNum);
		System.out.println(age);
		System.out.println(grade);
		System.out.println(height);
		System.out.println(gender);
	}
}
