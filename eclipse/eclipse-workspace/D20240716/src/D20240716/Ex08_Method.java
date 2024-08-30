package D20240716;

public class Ex08_Method {
	int first = 10;
	int second = 20;
	int result;
	
	public Ex08_Method() {}
	// 생성자 오버로딩
	public Ex08_Method(int first, int second) {
		this.first = first;
		this.second = second;
	}
	public void add() {
		result = first + second; //매개변수가 없으므로 멤버필드가 된다.
	}
	// 메서드 오버로딩 : 반환형 public int add(){}는 오버로딩이 성립하지 않음, 메서드명이 같아서 오류발생
	public void add(int first) {
		result = first + second; //first : 매개변수 first
	}
	public void add(int first, int second) {
		this.first = first;
		this.second = second;
		result = this.first + this.second;
	}
}

//오버로딩 : 이름이 같고 매개변수의 개수가 다르거나 매개변수의 타입이 달라야 한다. 
//메서드 오버로딩
//생성자 오버로딩 
//this() : 생성자 내에서 다른 생성자를 사용 할 때 
//메서드 : 값 전달 방식, 객체 전달 방식
//함수와 메서드의 차이
// : 클래스(객체) 밖에 있으면 함수 , 그 안에 있으면 메서드
//함수(메서드) : x값에 따른 y의 값의 변화 -> y값을 알아내기 위한 함수




