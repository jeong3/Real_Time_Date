package D20240718_1;

public class Animal_Ex01 {

	public static void main(String[] args) {
		//다향성	
		Animal animal = new Tiger();
		animal.move();
		animal = new Human();
		animal.move();
		animal = new Eagle();
		animal.move();
		animal = new Eagle();
		//animal.flying(); 부모클래스인 animal에 없는 메서드로 사용할 수 없다.
		//그렇기 때문에 강제 형 변환 Casting을 통해서 animal을 Eagle로 바꿔서 사용할 수 있다.
		Eagle eagle = (Eagle)animal;
		eagle.flying();
		
		animal = new Human(); //animal을 human으로 바꿔준 후 강제 형 변환을 해야한다.
		Human hu = (Human)animal;
		hu.readBook();
	}

}
