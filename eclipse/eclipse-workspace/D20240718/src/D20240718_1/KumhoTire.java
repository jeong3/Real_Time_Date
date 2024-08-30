package D20240718_1;

public class KumhoTire extends Tire{

	
	public KumhoTire(int accRotation, String location) {
		super(accRotation, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean roll() {
		accRotation++;
		if(maxRotation > accRotation) {
			System.out.println(location + "금호타이어 수명은" + accRotation + "회");
			return true;
		}else {
			System.out.println(location + "금호타이어 펑크");
			return false;
		}
	}
	
}
