package D20240715;

import D20240715_1.person;

public class Ex06 {

	public static void main(String[] args) {
		Ex06_Person person = new Ex06_Person();
		person.setData("이름", "010~", "주소", 20, 174.5, true);
		person.print();
		System.out.println(person.isGender());
		//person.gender = false; 직접 접근이 안되므로 setter를 사용해야 한다.
		//setter를 사용하지 않을 때는 같은 패키지에서 사용한다.
		person p = new person(); // 다른 패키지에 있는 클래스를 가져올 수 있다.
	}

}
