package D20240717;

public class Ex04 {

	public static void main(String[] args) {
		Ex04_Calculator calc = new Ex04_Calculator(10,20);
		Ex04_FourCalculator f_calc = new Ex04_FourCalculator(10,20);
	}

}
// Ex04에 Ex04_FourCalculator 객체 생성을 하기위해선
// Ex04_FourCalculator 클래스에 생성자가 있어야 한다.
// Ex04_FourCalculator 클래스에 생성자를 만들기 위해서는 
// Ex04_Calculator클래스의 생성자를 가져와야 한다.
// 가져오기 위해서는 super()메서드를 사용한다.