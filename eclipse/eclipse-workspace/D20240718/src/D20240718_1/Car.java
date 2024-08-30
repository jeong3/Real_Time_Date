package D20240718_1;

public class Car {
	//앞바퀴 왼쪽 타이어 : 한국타이어 / 금호타이어
	Tire fLTire = new KoreaTire(6, "앞 왼쪽");
	Tire fRTire = new KoreaTire(7, "앞 오른쪽");
	Tire bLTire = new KoreaTire(8, "뒤 왼쪽");
	Tire bRTire = new KoreaTire(9, "뒤 오른쪽");
	
	int run() {
		System.out.println("[자동차가 달립니다.]");
		if(fLTire.roll() == false) return 1; // 앞 왼쪽
		if(fRTire.roll() == false) return 2; // 앞 오른쪽
		if(bLTire.roll() == false) return 3; // 뒤 왼쪽
		if(bRTire.roll() == false) return 4; // 뒤 오른쪽
		return 0;
	}
	void stop() {
		System.out.println("차가 멈췄습니다.");
	}
	
}
