package D20240722;

public class FourCalculatorAbstract extends CalculatorAbstract {

	public FourCalculatorAbstract(int first, int second) {
		super(first, second);
	}

	public int sub() {
		return first - second;
	}
	public int mul() {
		return first * second;
	}
	
	@Override
	public int div() {
		if(second == 0)return 0;
		else return first / second;
	}

}
