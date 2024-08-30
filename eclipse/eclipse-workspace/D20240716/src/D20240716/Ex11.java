package D20240716;

public class Ex11 {

	public static void main(String[] args) {
		Ex11_Student student1 = new Ex11_Student(++Ex11_Student.seialNum ,"정지원1",4,"광명1");
		Ex11_Student student2 = new Ex11_Student(++Ex11_Student.seialNum,"정지원2",4,"광명2");
		Ex11_Student student_n = new Ex11_Student(++Ex11_Student.seialNum,"정지원n",4,"광명n");
		student1.print();
		student2.print();
		student_n.print();
		Ex11_Student.seialNum = 10;
		System.out.println(Ex11_Student.seialNum);
	}

}
