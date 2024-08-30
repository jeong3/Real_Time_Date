package D20240719_2;

public class CarEx {

	public static void main(String[] args) {
		Car car = new Car();
		for(int i = 0; i <= 12; i++) {
			int num = car.run();
			switch(num) {
			case 1: System.out.println("왼쪽 앞바퀴 금호 타이어로 교체");
			car.tire[0] = new KumhoTire(7, "앞 왼쪽");break;
			case 2: System.out.println("오른쪽 앞바퀴 금호 타이어로 교체");
			car.tire[1] = new KumhoTire(7, "앞 오른쪽");break;
			case 3: System.out.println("왼쪽 뒷바퀴 금호 타이어로 교체");
			car.tire[2] = new KumhoTire(7, "뒤 왼쪽");break;
			case 4: System.out.println("오른쪽 뒷바퀴 금호 타이어로 교체");
			car.tire[3] = new KumhoTire(7, "뒤 오른쪽");break;
			}
		}
	}
}
