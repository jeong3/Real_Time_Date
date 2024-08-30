package D20240722;

public class FourCalculatorImp implements CalculatorImp {
	int first;
	int second;
	public FourCalculatorImp(int first, int second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public int add() {
		// TODO Auto-generated method stub
		return first + second;
	}

	@Override
	public int sub() {
		return first - second;
	}
	public int div() {
		return first / second;
	}
	@Override
	public void print() {
		System.out.println(first);
		System.out.println(second);
	}
	
	
	
	

}
