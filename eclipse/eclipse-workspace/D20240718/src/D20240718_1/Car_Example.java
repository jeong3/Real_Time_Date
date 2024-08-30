package D20240718_1;

public class Car_Example {

	public static void main(String[] args) {
		Car car = new Car();
		for(int i = 0; i <= 7; i++) {
			int num = car.run();
			switch(num) {
			case 1 ://앞 왼쪽
				System.out.println("앞 왼쪽 금호타이어로 교체");
				car.fLTire = new KumhoTire(10, "앞 왼쪽");
			case 2 ://앞 왼쪽
				System.out.println("앞 오른쪽 금호타이어로 교체");
				car.fRTire = new KumhoTire(10, "앞 오른쪽");
			case 3 ://앞 왼쪽
				System.out.println("뒤 왼쪽 금호타이어로 교체");
				car.bLTire = new KumhoTire(10, "뒤 왼쪽");
			case 4 ://앞 왼쪽
				System.out.println("뒤 오른쪽 금호타이어로 교체");
				car.bRTire = new KumhoTire(10, "뒤 오른쪽");
			}
		}

	}

}
