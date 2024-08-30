package D20240719;

public class TestEx {

	public static void main(String[] args) {
		// 정적변수, 정적 메서드는 객체생성 없이 클래스명을 이용해서 사용할 수 있다.
		// 정적변수는 객체 안이 아닌 클래스 안에 있어서 멤버필드라고 부르지 않는다.
		System.out.println(Test.i); 
		Test.staticMethod();

	}

}
