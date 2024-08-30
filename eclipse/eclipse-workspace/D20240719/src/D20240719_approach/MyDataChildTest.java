package D20240719_approach;

public class MyDataChildTest {

	public static void main(String[] args) {
		MyDataChild my = new MyDataChild();
		my.setDay(10);
		System.out.println(my.getDay());
		my.month = 12; // prodected
		System.out.println(my.month);
		my.year = 2004; // default
		System.out.println(my.year);
		
	}

}
