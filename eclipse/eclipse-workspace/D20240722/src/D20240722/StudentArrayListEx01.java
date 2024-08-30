package D20240722;

import java.util.ArrayList;
import java.util.List;

public class StudentArrayListEx01 {

	public static void main(String[] args) {
		// 객체 리스트 선언
		List <Student> stu = new ArrayList<Student>();
		// 객체 리스트 저장
		stu.add(new Student(1, "정지원1", 181, true, 4));
		stu.add(new Student(2, "정지원2", 182, false, 4));
		stu.add(new Student(3, "정지원3", 183, false, 4));
		stu.add(new Student(4, "정지원4", 184, true, 4));
		// 객체 수정
		stu.set(1, new Student(2, "정지원02", 182, false, 4));
		// 크기
		System.out.println(stu.size());
		// 객체 리스트 삭제 
		Student str = stu.remove(3);
		System.out.println(str.getStudentName());
		// 전체 출력
		for(Student s : stu) {
			System.out.println(s.getStudentName());
		}
		stu.get(0).print();
		
		
		
		// 모두삭제
		stu.clear();
		

	}

}
