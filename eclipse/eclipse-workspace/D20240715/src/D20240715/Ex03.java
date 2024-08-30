package D20240715;

public class Ex03 {

	public static void main(String[] args) {
		Ex03_Student st = new Ex03_Student();
		st.name = "정지원";
		Ex03_Student st1 = new Ex03_Student();
		//호출 메서드 ( 인자(실인자) arguments ) //아규먼트와 파라미터는 1:1대응한다.
		st1.setData("정지원", "광명", 2019 , 24, 4, 175, true);
		System.out.println(st1.name);
		st1.print();
	
	}

}
