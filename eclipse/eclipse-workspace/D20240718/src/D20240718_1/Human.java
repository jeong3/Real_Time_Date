package D20240718_1;

public class Human extends Animal {
	@Override
	public void move() {
		System.out.println("사람이 걸어다닙니다.");
	}
	public void readBook() {
		System.out.println("사람이 책을 읽습니다.");
	}
}
