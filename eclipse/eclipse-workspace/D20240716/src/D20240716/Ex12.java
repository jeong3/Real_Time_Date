package D20240716;

public class Ex12 {

	public static void main(String[] args) {
		//학생 3명
		
		int i1 = 10;
		int i2 = 20;
		int i3 = 30;
		int i4 = 40;
		int [] i = new int[4];
		i[0] = i1;
		i[1] = i2;
		i[2] = i3;
		i[3] = i4;
		for(int val : i) {
			System.out.println(val);
		}
		
		Ex12_Student st1 = new Ex12_Student(100001, "정지원1", 4, "광명1");
		Ex12_Student [] st = new Ex12_Student[3];
		st[0] = new Ex12_Student(100001, "정지원1", 4, "광명1");
		st[1] = new Ex12_Student(100002, "정지원2", 4, "광명2");
		st[2] = new Ex12_Student(100003, "정지원3", 4, "광명3");
		for(Ex12_Student obj : st) {
			obj.print();
		}
		
	}

}
