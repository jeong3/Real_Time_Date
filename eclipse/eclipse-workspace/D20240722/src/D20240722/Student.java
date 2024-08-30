package D20240722;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 생성자
@Setter 
@Getter

public class Student { // 캡슐화 : 멤버를 은닉하기 위해서
	
	// 멤버 
	int StudentNum;
	String studentName;
	double height;
	boolean gender;
	int grade;
	
	//메서드
	public void print() {
		System.out.println(StudentNum);
		System.out.println(studentName);
		System.out.println(height);
		System.out.println(gender);
		System.out.println(grade);
	}
	
	
	
}
