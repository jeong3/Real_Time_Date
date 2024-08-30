package D20240718_2;

public class Animal_Ex01 {

	public static void main(String[] args) {
	//	Animal animal = new Animal(); abstract는 객체 생성할 수 없다.
		Eagle eagle = new Eagle();
		eagle.move();
		Tiger tiger = new Tiger();
		tiger.move();
		Animal animal = new Tiger(); //다향성에는 문제되지 않는다.
	}


}
