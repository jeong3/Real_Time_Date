package D20240718_1;

public class KoreaTire extends Tire{

	
	public KoreaTire(int accRotation, String location) {
		super(accRotation, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean roll() {
		accRotation++;
		if(maxRotation > accRotation) {
			System.out.println(location + "한국타이어 수명은" + accRotation + "회");
			return true;
		}else {
			System.out.println(location + "한국타이어 펑크");
			return false;
		}
	}
	
}
