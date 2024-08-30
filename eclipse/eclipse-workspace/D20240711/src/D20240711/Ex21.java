package D20240711;

public class Ex21 {

	public static void main(String[] args) {
		/* 변수의 장점 : 값을 바꿀 수 있다.
		 * 변수의 단점 : 하나의 값만 저장할 수 있다.
		 * 배열의 장점 : 하나 이상의 값을 저장할 수 있다.
		 * 배열의 단점 : 한 종류의 값만 저장할 수 있다.
		 * class : 여러 종류의 값을 저장하기 위해서 사용
		 */
		Student student = new Student(); // 객체 생성
		student.name = "정지원";
		student.studentNum = "20191023";
		student.age = 25;
		student.height = 200.0;
		student.gender = true;
		System.out.println(student.name);
		System.out.println(student.studentNum);
		System.out.println(student.age);
		System.out.println(student.height);
		System.out.println(student.gender);
		
		Student student1 = new Student();
		student1.name = "정모씨";
		System.out.println(student1.name);

	}

}
