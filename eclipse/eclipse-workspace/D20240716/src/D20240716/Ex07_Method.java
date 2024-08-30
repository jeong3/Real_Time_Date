package D20240716;

public class Ex07_Method {
	int first = 10;
	int second = 20;
	int result;
	
	public Ex07_Method() {} // 생성자 오버로딩
	public Ex07_Method(int first, int second) {
		this.first = first;
		this.second = second;
	}
	public void add() { // 메서드 오버로딩
		result = first + second;
	}
	public void add(int first) {
		this.first = first; // 멤버필드의 first의 값을 변경
		result = first + second; 
		// 위의 this.first = first;가 없다면 멤버필드의 값은 그대로 / 매개변수 first의 값을 더해준다
	}
	public void add(int first, int second) {
		result = first + second;
	}
	public void print() {
		System.out.println(first);
		System.out.println(second);
		System.out.println(result);
	}
	
}
