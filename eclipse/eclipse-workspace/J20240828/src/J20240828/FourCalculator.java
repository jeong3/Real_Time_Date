package J20240828;

public class FourCalculator extends Calculator {
	public FourCalculator(int num1, int num2) {
		super(num1,num2);
	}
	public int sub() {
		return num1 - num2;
	}
	public int mul() {
		return num1 * num2;
	}
	@Override
	public int div() {
		if(num2 == 0) {
			return 0;
		}else {
			return num1 / num2;
		}
		
	}
}
