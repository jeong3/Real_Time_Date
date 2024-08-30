package J20240828;

public class CalculatorImp implements CalculatorInterface{

	@Override
	public int add() {
		return NUM1 + NUM2;
	}

	@Override
	public int div() {
		return NUM1 / NUM2;
	}

}
