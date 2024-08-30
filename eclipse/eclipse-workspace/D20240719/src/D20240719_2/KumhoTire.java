package D20240719_2;

public class KumhoTire implements Tire {
	int maxRotation; // 최대 회전 수
	int accRotation; // 현재 회전 수
	String location; // 타이어의 위치

	public KumhoTire(int maxRotation, String location) {
		this.maxRotation = maxRotation;
		this.location = location;
	}
	@Override
	public boolean roll() {
		accRotation++;
		if (maxRotation > accRotation) {
			System.out.println(location + "Tire 수명은" + accRotation + "회");
			return true;
		} else {
			System.out.println("*** " + location + "Tire 펑크 ***");
			return false;
		}

	}
}
