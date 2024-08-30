package D20240716;

public class Ex07 {

	public static void main(String[] args) {
		Ex07_Method met = new Ex07_Method();
		met.add(); //멤버필드의 first와 second 값 10, 20
		met.print();
		Ex07_Method met1 = new Ex07_Method(100,200);
		met1.add();
		met1.print();
		met1.add(1000); // 

	}

}
