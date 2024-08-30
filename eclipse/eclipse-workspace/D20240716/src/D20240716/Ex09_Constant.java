package D20240716;

public class Ex09_Constant {
	final double PI = 3.141592; //상수 / final을 통해서 변수를 상수로 만들어 줄 수 있다.
	int radius;
	double result;
	public void circle(int radius) {
		//this.PI = 10.5; final로 상수가 되었기 때문에 성립되지 않는다.
		result = radius * radius * PI;
	}
	
	
	
	
	
	
	
	
	
	
}
